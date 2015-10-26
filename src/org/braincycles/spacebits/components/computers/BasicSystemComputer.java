package org.braincycles.spacebits.components.computers;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.braincycles.spacebits.Spacecraft;
import org.braincycles.spacebits.SystemStatus;
import org.braincycles.spacebits.SystemStatusMessage;
import org.braincycles.spacebits.components.Component;
import org.braincycles.spacebits.components.computers.os.MessageMediator;

public class BasicSystemComputer extends AbstractComputer implements SystemComputer {

	private MessageMediator messagingSystem;

	private List<SystemStatusMessage> systemMessages;

	protected List<Component> components;

	public BasicSystemComputer(String name, double mass, double volume,
			double power, double cpu, double maxCPUThroughput, Spacecraft spacecraftBus) {
		super(name, mass, volume, power, cpu, maxCPUThroughput, spacecraftBus);

		components = new ArrayList<Component>();
		systemMessages = new ArrayList<SystemStatusMessage>();
	}


	public BasicSystemComputer(String name, double mass, double volume,
			double power, double cpu, double maxCPUThroughput) {
		super(name, mass, volume, power, cpu, maxCPUThroughput);

		components = new ArrayList<Component>();
		systemMessages = new ArrayList<SystemStatusMessage>();
	}




	@Override
	public List<SystemStatusMessage> getSystemMessages() {
		return this.systemMessages;
	}


	public SystemStatus online() {
		SystemStatus status = new SystemStatus(this);
		
		
		status.addSystemMessage(addSystemMessage(this, this.getName() + " online.", 1));
		
		status.addSystemMessage(addSystemMessage(this, "Scanning spacecraft bus for components.", 1));
		this.components = spacecraftBus.getComponents();
		
		registerSpacecraftComponents();
		status.addSystemMessage(addSystemMessage(this, "Spacecraft components registered.", 1));

		SystemStatus checkSystemStatus = checkSystems();
		status.addSystemMessage(addSystemMessage(this, "All systems checked.", 1));
		status.mergeSystemStatus(checkSystemStatus);

		status.addSystemMessage(addSystemMessage(this, "Onlining spacecraft components", 1));
		for(Component component : components) {
			if(component != this)
				component.online();
		}

		return status;
	}


	public void addComponent(Component component) {
		components.add(component);
	}


	public void registerSpacecraftComponents() {
		for(Component component : components) {
			component.accept(this);
			//Set this as the registered computer in the component
			component.registerSystemComputer(this);
			// Register the component with the messaging system
			messagingSystem.addComponent(component);

			if(component instanceof Computer)
				totalCPUAvailable += ((Computer) component).getMaxCPUThroughput();

		}
	}


	@Override
	public int getIdentifier() {
		return this.hashCode();
	}

	@Override
	public boolean authorize(String authorizationCode) {
		return false;
	}

	@Override
	public boolean runDiagnostics(int level) {
		return super.runDiagnostics(level);
	}

	@Override
	public double getMaxCPUThroughput() {
		return this.maxCPUThroughput;
	}

	@Override
	public String describe() {
		return "System computer";
	}

	@Override
	public MessageMediator getMessagingSystem() {
		return messagingSystem;
	}


	@Override
	public void setMessagingSystem(MessageMediator messagingSystem) {
		this.messagingSystem = messagingSystem;
	}


	@Override
	public void visit(Component component) {
		totalMassOfComponents += component.getMass();
		totalVolumeOfComponents += component.getVolume();
		totalPowerRequirementOfComponents += component.getPower();
		totalCPURequirementOfComponents += component.getCPU();
	}




	public double getTotalMassOfComponents() {
		return totalMassOfComponents;
	}


	public double getTotalVolumeOfComponents() {
		return totalVolumeOfComponents;
	}


	public double getTotalPowerRequirementOfComponents() {
		return totalPowerRequirementOfComponents;
	}


	public double getTotalCPURequirementOfComponents() {
		return totalCPURequirementOfComponents;
	}




	@Override
	public double getTotalCPUAvailable() {
		return totalCPUAvailable;
	}


	@Override
	public SystemStatus checkSystems() {
		SystemStatus status = new SystemStatus(this);

		double maximumAvailableVolume = spacecraftBus.getVolume();

		status.addSystemMessage(addSystemMessage(this, "Total vessel mass: " + totalMassOfComponents, 0));
		
		status.addSystemMessage(addSystemMessage(this, "Available hull volume: " + maximumAvailableVolume, 0));
		status.addSystemMessage(addSystemMessage(this, "Required hull volume: " + totalVolumeOfComponents, 0));
		
		if(maximumAvailableVolume < totalVolumeOfComponents)
			status.addSystemMessage(addSystemMessage(this, "Not enough space", -1));

			status.addSystemMessage(addSystemMessage(this, "Available CPU throughput: " + totalCPUAvailable, 0));
			status.addSystemMessage(addSystemMessage(this, "Required CPU throughput: " + totalCPURequirementOfComponents, 0));
		
		if(totalCPUAvailable < totalCPURequirementOfComponents)
			status.addSystemMessage(addSystemMessage(this, "Not enough CPU", -1));

		return status;
	}


	@Override
	public SystemStatusMessage addSystemMessage(Component component, String message, int status) {
		SystemStatusMessage systemStatusMessage = new SystemStatusMessage(component, message, getUniversalTime(), status);
		this.systemMessages.add(systemStatusMessage);
		return systemStatusMessage;
	}


	@Override
	public double getUniversalTime() {
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int day = cal.get(Calendar.DAY_OF_YEAR);
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		int minute = cal.get(Calendar.MINUTE);
		int second = cal.get(Calendar.SECOND);
		int millisecond = cal.get(Calendar.MILLISECOND);
		
		//Change this;
		return ((year+0) + day/365.0 + 
				(hour/(365*24.0)) + 
				(minute/(365.0*24.0*60.0)) + 
				(second/(365.0*86400.0)) + 
				(millisecond/(365.0*86400000.0)));
	}






}

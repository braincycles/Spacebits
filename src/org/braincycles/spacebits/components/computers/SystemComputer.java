package org.braincycles.spacebits.components.computers;

import java.util.List;

import org.braincycles.spacebits.SystemStatus;
import org.braincycles.spacebits.SystemStatusMessage;
import org.braincycles.spacebits.components.Component;
import org.braincycles.spacebits.components.ComponentVisitor;
import org.braincycles.spacebits.components.computers.os.MessageMediator;


public interface SystemComputer extends Computer, ComponentVisitor {
	
	public MessageMediator getMessagingSystem();
	public void setMessagingSystem(MessageMediator messagingSystem);
	
	public void registerSpacecraftComponents();
	
	public void addComponent(Component component);
	
	
	public double getTotalMassOfComponents();
	public double getTotalVolumeOfComponents();
	public double getTotalPowerRequirementOfComponents();
	public double getTotalCPURequirementOfComponents();
	
	public double getTotalCPUAvailable();
	
	public SystemStatusMessage addSystemMessage(Component component, String message, int status);
	
	public List<SystemStatusMessage> getSystemMessages();
	
	public SystemStatus checkSystems();
	
	public double getUniversalTime();
	
}

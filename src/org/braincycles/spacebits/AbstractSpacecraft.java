package org.braincycles.spacebits;

import java.util.ArrayList;
import java.util.List;

import org.braincycles.spacebits.components.AbstractComponent;
import org.braincycles.spacebits.components.Component;
import org.braincycles.spacebits.components.comms.CommunicationComponent;
import org.braincycles.spacebits.components.computers.Computer;
import org.braincycles.spacebits.components.computers.SystemComputer;
import org.braincycles.spacebits.components.engines.Engine;
import org.braincycles.spacebits.structures.hulls.Hull;


public abstract class AbstractSpacecraft extends AbstractComponent implements Spacecraft {

	protected String name;
	protected Hull hull;
	protected List<Computer> computers;
	protected SystemComputer systemComputer;
	protected List<Engine> engines;
	protected List<CommunicationComponent> commDevices;
	protected List<Component> components;

	public AbstractSpacecraft(String name, Hull hull, List<Computer> computers,
			List<Engine> engines, List<CommunicationComponent> commDevices) {
		super(name, 0, 0, 0, 0);
		
		this.components = new ArrayList<Component>();
		
		this.name = name;
		setHull(hull);
		
		//components.addAll(engines);
		
		this.computers = computers;
		this.engines = engines;
		this.commDevices = commDevices;
		
	}
	
	
	public AbstractSpacecraft(String name, Hull hull) {
		super(name, 0, 0, 0, 0);
		components = new ArrayList<Component>();
		this.name = name;
		setHull(hull);
		
		computers = new ArrayList<Computer>();
		engines = new ArrayList<Engine>();
		commDevices = new ArrayList<CommunicationComponent>();
		
	}




	@Override
	public SystemStatus onlineSystems() {
		SystemStatus status = new SystemStatus(this);
		
		if(bootstrapSystemComputer() == false) {
			System.out.println("No system computer found! Aborting spacecraft onlining.");
			status.addSystemMessage("No system computer found! Aborting spacecraft onlining.", 11, 10);
			return status;
		}

		systemComputer.runDiagnostics(1);
		
		
		//Online the system computer
		SystemStatus systemComputerStatus = systemComputer.online();
		
		status.mergeSystemStatus(systemComputerStatus);
		
		if(status.getStatus() < 0)
			System.out.println("Bad status!.");
		
		//put all this in an initialize method on the computer

		return status;
	}
	


	private boolean bootstrapSystemComputer() {
		int systemComputerIndex = findSystemComputer();
		boolean hasSystemComputer = (systemComputerIndex >= 0);
		if(hasSystemComputer) {
			systemComputer = (SystemComputer) computers.get(systemComputerIndex);
			systemComputer.setSpacecraftBus(this);
		}

		return hasSystemComputer;
	}



	private int findSystemComputer() {
		int counter = -1;
		for(Computer computer : computers)
			if(computer instanceof SystemComputer) {
				counter++;
			} 
		return counter;
	}



	

	public Hull getHull() {
		return hull;
	}


	public void setHull(Hull hull) {
		this.hull = hull;
		components.add(hull);
	}


	@Override
	public String getName() {
		return this.name;
	}



	@Override
	public void setName(String name) {
		this.name = name;
	}



	@Override
	public List<Engine> getEngines() {
		return engines;
	}
	
	public void setEngines(List<Engine> engines) {
		this.engines = engines;
		for(Component engine : engines)
			components.add(engine);
	}

	@Override
	public void addEngine(Engine engine) {
		engines.add(engine);
	}
	
	
	
	@Override
	public List<Computer> getComputers() {
		return computers;
	}
	
	public void setComputers(List<Computer> computers) {
		this.computers = computers;
		for(Component computer : computers)
			components.add(computer);
	}

	@Override
	public void addComputer(Computer computer) {
		computers.add(computer);
	}

	
	


	public List<CommunicationComponent> getCommDevices() {
		return commDevices;
	}

	public void setCommDevices(List<CommunicationComponent> commDevices) {
		this.commDevices = commDevices;
		for(Component comDevice : commDevices)
			components.add(comDevice);
	}

	@Override
	public void addCommDevice(CommunicationComponent commDevice) {
		this.commDevices.add(commDevice);
	}



	@Override
	public SystemComputer getSystemComputer() {
		return this.systemComputer;
	}

	
	public void setSystemComputer(SystemComputer systemComputer) {
		this.systemComputer = systemComputer;
	}

	//Delegate methods
	
	
	public double getLength() {
		return hull.getLength();
	}


	public double getWidth() {
		return hull.getWidth();
	}



	public double getVolume() {
		return hull.getVolume();
	}


	public List<Component> getComponents() {
		return components;
	}


	public void setComponents(List<Component> components) {
		this.components = components;
	}


	
	

}

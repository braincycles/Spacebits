package org.braincycles.spacebits;

import java.util.List;

import org.braincycles.spacebits.components.Component;
import org.braincycles.spacebits.components.comms.CommunicationComponent;
import org.braincycles.spacebits.components.computers.Computer;
import org.braincycles.spacebits.components.computers.SystemComputer;
import org.braincycles.spacebits.components.engines.Engine;

public interface Spacecraft extends Component {
	
	public int getIdentifier();
	
	public String getName();
	public void setName(String name);
	
	public double getVolume();
	
	public SystemStatus onlineSystems();
	
	public List<Component> getComponents();
	
	public List<Engine> getEngines();
	public List<Computer> getComputers();
	public List<CommunicationComponent> getCommDevices();
	
	public void setEngines(List<Engine> engines);
	public void setComputers(List<Computer> computers);
	public void setCommDevices(List<CommunicationComponent> commDevices);
	
	public void addEngine(Engine engine);
	public void addComputer(Computer computer);
	public void addCommDevice(CommunicationComponent commDevice);
	
	public SystemComputer getSystemComputer();
	public void setSystemComputer(SystemComputer computer);
	
}

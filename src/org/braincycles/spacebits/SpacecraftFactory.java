package org.braincycles.spacebits;

import java.util.ArrayList;
import java.util.List;

import org.braincycles.spacebits.components.comms.CommunicationComponent;
import org.braincycles.spacebits.components.comms.CommunicatorDeviceFactory;
import org.braincycles.spacebits.components.computers.Computer;
import org.braincycles.spacebits.components.computers.ComputerFactory;
import org.braincycles.spacebits.components.computers.SystemComputer;
import org.braincycles.spacebits.components.engines.Engine;
import org.braincycles.spacebits.components.engines.EngineFactory;
import org.braincycles.spacebits.structures.hulls.Hull;
import org.braincycles.spacebits.structures.hulls.HullFactory;

public class SpacecraftFactory {
	
	public final static String SHUTTLE="Shuttle"; 
	
	public static Spacecraft getSpacecraft(String spacecraftType) {
		
		switch (spacecraftType) {
			
		case SHUTTLE:
			Hull hull = HullFactory.getHull(SHUTTLE);
			
			Spacecraft spacecraft = new SimpleSpacecraft(SHUTTLE, hull);
			

			Computer systemComputer = ComputerFactory.getComputer(ComputerFactory.SIMPLE_SYSTEM);
			systemComputer.setSpacecraftBus(spacecraft);
			spacecraft.setSystemComputer((SystemComputer) systemComputer);
			
			List<Computer> computers = new ArrayList<Computer>();
			computers.add(systemComputer);
			
			Engine engine = EngineFactory.getEngine(EngineFactory.SMALL_ION_ENGINE);
			List<Engine> engines = new ArrayList<Engine>();
			engines.add(engine);
			
			CommunicationComponent commDevice = CommunicatorDeviceFactory.getCommunicator(CommunicatorDeviceFactory.SMALL_RF_COMMUNICATOR);
	        List<CommunicationComponent> communicationDevices = new ArrayList<CommunicationComponent>();
			communicationDevices.add(commDevice);
			
			spacecraft.setComputers(computers);
			spacecraft.setEngines(engines);
			spacecraft.setCommDevices(communicationDevices);
	
			
			return spacecraft;
		}
		
		
		return null;
		
	}

}

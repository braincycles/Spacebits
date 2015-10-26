package org.braincycles.spacebits;

import java.util.List;

import org.braincycles.spacebits.components.comms.CommunicationComponent;
import org.braincycles.spacebits.components.computers.Computer;
import org.braincycles.spacebits.components.computers.os.Message;
import org.braincycles.spacebits.components.engines.Engine;
import org.braincycles.spacebits.structures.hulls.Hull;

public class SimpleSpacecraft extends AbstractSpacecraft {

	public SimpleSpacecraft(String name, Hull hull, List<Computer> computers,
			List<Engine> engines, List<CommunicationComponent> commDevices) {
		super(name, hull, computers, engines, commDevices);
	}
	
	public SimpleSpacecraft(String name, Hull hull) {
		super(name, hull);
	}
	

	@Override
	public int getIdentifier() {
		return this.hashCode();
	}


	@Override
	public boolean runDiagnostics(int level) {
		boolean check = false;
		//Check engines
		for(Engine engine : engines) {
			check = engine.runDiagnostics(level);
		}
		//Check computers
		for(Computer computer : computers) {
			check = computer.runDiagnostics(level);
		}

		return check;
	}

	@Override
	public void recieveMessage(Message message) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String describe() {
		return "Simple spacecraft";
	}

	@Override
	public SystemStatus online() {
		// TODO Auto-generated method stub
		return null;
	}

	

}

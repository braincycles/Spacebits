package org.braincycles.spacebits.structures.hulls;

import org.braincycles.spacebits.SystemStatus;
import org.braincycles.spacebits.components.computers.os.Message;

public class SimpleHull extends AbstractHull {

	public SimpleHull(String name, double mass, double volume, double power, double cpu,
			double length, double width) {
		super(name, mass, volume, power, cpu, length, width);
	}

	@Override
	public String describe() {
		return "Simple Hull";
	}

	@Override
	public boolean runDiagnostics(int level) {
		return true;
	}

	@Override
	public void recieveMessage(Message message) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public SystemStatus online() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}

package org.braincycles.spacebits.components;

import org.braincycles.spacebits.SystemStatus;
import org.braincycles.spacebits.SystemStatusMessage;
import org.braincycles.spacebits.components.computers.Computer;
import org.braincycles.spacebits.components.computers.SystemComputer;

public abstract class AbstractComponent implements Component {

	protected String name;

	protected double mass;

	protected double volume;

	protected double power;

	protected double cpu;

	protected SystemComputer systemComputer;

	public AbstractComponent(String name, double mass, double volume, double power, double cpu) {
		super();
		this.name = name;
		this.mass = mass;
		this.volume = volume;
		this.power = power;
		this.cpu = cpu;
	}


	


	@Override
	public void accept(ComponentVisitor componentVisitor) {
		componentVisitor.visit(this);
	}


	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getMass() {
		return mass;
	}

	public void setMass(double mass) {
		this.mass = mass;
	}

	public double getVolume() {
		return volume;
	}

	public void setVolume(double volume) {
		this.volume = volume;
	}

	public double getPower() {
		return power;
	}

	public void setPower(double power) {
		this.power = power;
	}

	public double getCPU() {
		return cpu;
	}

	public void setCPU(double cpu) {
		this.cpu = cpu;
	}

	public Computer getSystemComputer() {
		return systemComputer;
	}

	public void registerSystemComputer(SystemComputer systemComputer) {
		this.systemComputer = systemComputer;
		systemComputer.addSystemMessage(this,getName() + " registering with system computer", 0);
	}

	@Override
	public int getIdent() {
		return hashCode();
	}
	
	





	@Override
	public String toString() {
		return getName();
	}





	@Override
	public SystemStatus online() {
		// Run low level diagnostics during onlining
		runDiagnostics(3);
		SystemStatus systemStatus = new SystemStatus(this);
		SystemStatusMessage systemStatusMessage = 
				new SystemStatusMessage(this, this.getName() + " online.", 11, 0);
		systemStatus.addSystemMessage(systemStatusMessage);
		systemComputer.addSystemMessage(this, this.getName() + " online.", 0);
		return systemStatus;
	}
	
	
	



}

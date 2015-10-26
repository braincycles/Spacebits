package org.braincycles.spacebits.components.engines;

import org.braincycles.spacebits.components.AbstractComponent;
import org.braincycles.spacebits.components.computers.os.Message;
import org.braincycles.spacebits.models.thrust.ThrustModel;

public abstract class AbstractEngine extends AbstractComponent implements Engine {
	
	protected ThrustModel thrustModel;
	protected double powerLevel;
	protected double maxThrust;
	protected EngineVector engineVector;
	protected boolean vectored;

	public AbstractEngine(String name, double mass, double volume, double power, double cpu, double maxThrust, ThrustModel thrustModel, EngineVector engineVector, boolean vectored) {
		super(name, mass, volume, power, cpu);
		this.thrustModel = thrustModel;
		this.maxThrust = maxThrust;
		this.engineVector = engineVector;
		this.vectored = vectored;
	}
	

	@Override
	public ThrustModel getThrustModel() {
		return this.thrustModel;
	}
	

	@Override
	public void setThrustModel(ThrustModel thrustModel) {
		this.thrustModel = thrustModel;
	}
	

	@Override
	public double getThrust(double[] velocity) {
		return this.thrustModel.getThrust(velocity);
	}
	
	

	public double getPowerLevel() {
		return powerLevel;
	}

	public void setPowerLevel(double powerLevel) {
		this.powerLevel = powerLevel;
		this.thrustModel.setPowerLevel(powerLevel);
	}
	
	

	@Override
	public double getPower() {
		return this.thrustModel.getPower();
	}
	

	
	public double getMaxThrust() {
		return maxThrust;
	}


	public void setMaxThrust(double maxThrust) {
		this.maxThrust = maxThrust;
	}


	@Override
	public String describe() {
		String description = " -- Simple Ion Engine -- \n" + 
	    "Mass: " + getMass() + " Kg, Volume: " + getVolume() + " m3, Power: <thrust dep.> GJ/s, CPU: " + getCPU() + " GFLOPS";
		description += "\n";
		description += "   ---------------------------------------------";
		description += "   Thrust model: " + thrustModel.toString() +"\n";
		description += "   Max. thrust: " + thrustModel.getMaxThrust() + " N\n";
		description += "   Max. power: " + thrustModel.getMaxPower() + " GJ/s";
		return description;
	}
	
	
	@Override
	public boolean runDiagnostics(int level) {
		return thrustModel.runDiagnostics(level);
	}


	@Override
	public void recieveMessage(Message message) {
		System.out.println("Message recieved by engine : " + getName() + "\n " + message.getMessage());
		
	}


	public EngineVector getEngineVector() {
		return engineVector;
	}


	public void setEngineVector(EngineVector engineVector) {
		this.engineVector = engineVector;
	}


	public boolean isVectored() {
		return vectored;
	}


	public void setVectored(boolean vectored) {
		this.vectored = vectored;
	}
	
	
	
	
	
	

}

package org.braincycles.spacebits.models.thrust;

public abstract class AbstractThrustModel implements ThrustModel {

	protected double maxThrust;
	protected double maxPower;
	
	protected double powerLevel;
	
	public AbstractThrustModel(String name, double maxThrust, double maxPower) {
		this.maxThrust = maxThrust;
		this.maxPower = maxPower;
	}

	@Override
	public double getMaxThrust() {
		return this.maxThrust;
	}

	@Override
	public double getMaxPower() {
		return this.maxPower;
	}

	@Override
	public void setPowerLevel(double powerLevel) {
		this.powerLevel = powerLevel;
	}


	
}

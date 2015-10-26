package org.braincycles.spacebits.models.thrust;

import org.braincycles.spacebits.Diagnosable;

public interface ThrustModel extends Diagnosable {
	
	public double getThrust(double[] velocity);
	public double getMaxThrust();
	public double getMaxPower();
	public void setPowerLevel(double powerLevel);
	public double[][] getThrustProfile();
	public double getPower();
	public double[][] getPowerProfile();
	
}

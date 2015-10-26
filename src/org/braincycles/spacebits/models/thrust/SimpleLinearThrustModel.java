package org.braincycles.spacebits.models.thrust;

public class SimpleLinearThrustModel extends AbstractThrustModel {
	
	private static double MAX_POWERLEVEL = 100;

	public SimpleLinearThrustModel(String name, double maxThrust, double maxPower) {
		super(name, maxThrust, maxPower);
	}

	@Override
	public double getThrust(double[] velocity) {
		return this.getMaxThrust() * this.powerLevel/MAX_POWERLEVEL;
	}

	@Override
	public String toString() {
		return "Simple Linear Thrust Model";
	}

	@Override
	public double getMaxThrust() {
		return maxThrust;
	}

	@Override
	public double[][] getThrustProfile() {
		double[] profile = new double[10];
		for(int i = 0; i<10;i++)
			profile[i] =  getMaxThrust() / (10-i);
		return new double[][]{profile};
	}
	
	@Override
	public double[][] getPowerProfile() {
		double[] profile = new double[10];
		for(int i = 0; i<10;i++)
			profile[i] =  maxPower / (10-i);
		return new double[][]{profile};
	}
	
	
	@Override
	public double getPower() {
		return this.getMaxPower() * this.powerLevel/MAX_POWERLEVEL;
	}

	@Override
	public boolean runDiagnostics(int level) {
		return validateModel();
	}
	
	
	private boolean validateModel() {
		if(maxPower <= 0)
			return false;
		if(this.powerLevel < 0)
			return false;
		if(this.maxThrust < 0)
			return false;
		
		return true;
	}
	
}

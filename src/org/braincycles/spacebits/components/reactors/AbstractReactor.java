package org.braincycles.spacebits.components.reactors;

import org.braincycles.spacebits.components.AbstractComponent;
import org.braincycles.spacebits.components.storage.fuel.AbstractFuelStorageTank;

public abstract class AbstractReactor extends AbstractComponent {
	
	protected double maximumPowerOutput;
	
	protected AbstractFuelStorageTank fuelTank;

	public AbstractReactor(String name, double mass, double volume,
			double power, double cpu, double maximumPowerOutput) {
		super(name, mass, volume, power, cpu);
		
		setMaximumPowerOutput(maximumPowerOutput);
	}

	
	public double getMaximumPowerOutput() {
		return maximumPowerOutput;
	}

	public void setMaximumPowerOutput(double maximumPowerOutput) {
		this.maximumPowerOutput = maximumPowerOutput;
	}



	@Override
	public boolean runDiagnostics(int level) {
		return false;
	}
	
	
	

}

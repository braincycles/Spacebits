package org.braincycles.spacebits.components.computers;

import org.braincycles.spacebits.Spacecraft;
import org.braincycles.spacebits.components.AbstractComponent;
import org.braincycles.spacebits.components.computers.os.Message;

public abstract class AbstractComputer extends AbstractComponent implements Computer {

	protected double maxCPUThroughput;
	protected Spacecraft spacecraftBus;
	protected double totalMassOfComponents;
	protected double totalVolumeOfComponents;
	protected double totalPowerRequirementOfComponents;
	protected double totalCPURequirementOfComponents;
	
	protected double totalCPUAvailable;
	
	public AbstractComputer(String name, double mass, double volume,
			double power, double cpu, double maxCPUThroughput, Spacecraft spacecraftBus) {
		super(name, mass, volume, power, cpu);
		this.maxCPUThroughput = maxCPUThroughput;
		this.spacecraftBus = spacecraftBus;
	}
	
	public AbstractComputer(String name, double mass, double volume,
			double power, double cpu, double maxCPUThroughput) {
		super(name, mass, volume, power, cpu);
		this.maxCPUThroughput = maxCPUThroughput;
	}
	
	
	@Override
	public void recieveMessage(Message message) {
		// TODO Auto-generated method stub
		
	}
	

	@Override
	public boolean runDiagnostics(int level) {
		return true;
	}


	public double getMaxCPUThroughput() {
		return maxCPUThroughput;
	}


	public void setMaxCPUThroughput(double maxCPUThroughput) {
		this.maxCPUThroughput = maxCPUThroughput;
	}

	@Override
	public void setSpacecraftBus(Spacecraft spacecraftBus) {
		this.spacecraftBus = spacecraftBus;
	}
	
	
	
	

	
	

}

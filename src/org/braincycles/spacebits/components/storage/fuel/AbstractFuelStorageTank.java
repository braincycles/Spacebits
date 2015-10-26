package org.braincycles.spacebits.components.storage.fuel;

import org.braincycles.spacebits.components.AbstractComponent;

public abstract class AbstractFuelStorageTank extends AbstractComponent {

	protected double capacity;
	protected double fuelLevel;
	
	public AbstractFuelStorageTank(String name, double mass, double volume,
			double power, double cpu, double capacity) {
		super(name, mass, volume, power, cpu);
		
		setCapacity(capacity);
		setFuelLevel(0);
	}

	

	public double getCapacity() {
		return capacity;
	}


	public void setCapacity(double capacity) {
		this.capacity = capacity;
	}



	public double getFuelLevel() {
		return fuelLevel;
	}



	public void setFuelLevel(double fuelLevel) {
		this.fuelLevel = fuelLevel;
	}
	
	
	

}

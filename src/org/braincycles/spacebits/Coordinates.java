package org.braincycles.spacebits;

public class Coordinates {
	
	private String name;
	
	private double[] locaton;

	public Coordinates(String name, double[] coords) {
		super();
		this.name = name;
		this.locaton = coords;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double[] getLocation() {
		return locaton;
	}

	public void setLocation(double[] location) {
		this.locaton = location;
	}
	
	
	
	
	

}

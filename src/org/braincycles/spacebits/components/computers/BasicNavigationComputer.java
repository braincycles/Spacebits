package org.braincycles.spacebits.components.computers;

import org.braincycles.spacebits.Coordinates;
import org.braincycles.spacebits.SystemStatus;

public class BasicNavigationComputer extends AbstractComputer implements NavigationComputer {

	private Coordinates currentLocation;

	public BasicNavigationComputer(String name, double mass, double volume,
			double power, double cpu, double maxCPUThroughput) {
		super(name, mass, volume, power, cpu, maxCPUThroughput);
	}


	public SystemStatus online() {

		runDiagnostics(1);
		return null; //remove and finish
	}

	@Override
	public int getIdentifier() {
		return this.hashCode();
	}

	@Override
	public boolean authorize(String authorizationCode) {
		return false;
	}

	@Override
	public boolean runDiagnostics(int level) {
		return super.runDiagnostics(level);
	}

	@Override
	public double getMaxCPUThroughput() {
		return this.maxCPUThroughput;
	}

	@Override
	public String describe() {
		return "Navigation computer";
	}

	@Override
	public Coordinates getCurrentLocation() {
		return this.currentLocation;
	}

	@Override
	public double getDistanceToCoordinates(Coordinates location) {

		double[] currentLocationArr = currentLocation.getLocation();
		double[] locationArr = location.getLocation();

		double distance = Math.sqrt(
				Math.abs(currentLocationArr[0] - locationArr[0]) +
				Math.abs(currentLocationArr[1] - locationArr[1]) + 
				Math.abs(currentLocationArr[2] - locationArr[2])
				);

		return distance;
	}



}

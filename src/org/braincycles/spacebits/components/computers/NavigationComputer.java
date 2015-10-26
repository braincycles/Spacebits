package org.braincycles.spacebits.components.computers;

import org.braincycles.spacebits.Coordinates;

public interface NavigationComputer extends Computer  {
	
	public Coordinates getCurrentLocation();
	
	public double getDistanceToCoordinates(Coordinates location);

}

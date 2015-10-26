package org.braincycles.spacebits.components.computers;

import org.braincycles.spacebits.Spacecraft;
import org.braincycles.spacebits.components.Component;

public interface Computer extends Component {
	
	public int getIdentifier();
	
	public boolean authorize(String authorizationCode);
	
	public double getMaxCPUThroughput();
	
	public void setSpacecraftBus(Spacecraft spacecraft);
	

}

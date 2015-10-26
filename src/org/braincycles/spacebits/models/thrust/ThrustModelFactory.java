package org.braincycles.spacebits.models.thrust;

public class ThrustModelFactory {
	
	
	public static String SIMPLE_LINEAR = "Simple Linear";


	public static ThrustModel getThrustModel(String thrustModelType){
		if(thrustModelType.equalsIgnoreCase(SIMPLE_LINEAR)){
			return new SimpleLinearThrustModel(SIMPLE_LINEAR, 100, 100);
		}

		return null;
	}

}

package org.braincycles.spacebits.components.engines;

import org.braincycles.spacebits.Unit;
import org.braincycles.spacebits.components.engines.thrust.SimpleIonEngine;
import org.braincycles.spacebits.models.thrust.ThrustModel;
import org.braincycles.spacebits.models.thrust.ThrustModelFactory;

public class EngineFactory {
	
	public static String SMALL_ION_ENGINE = "Small Ion Engine";


	public static Engine getEngine(String engineType){
		if(engineType.equalsIgnoreCase(SMALL_ION_ENGINE)){
			
			ThrustModel thrustModel = ThrustModelFactory.getThrustModel(ThrustModelFactory.SIMPLE_LINEAR);		
			
			double mass = 25.0;//Kg
			double volume = 1.0;//m3
			double power = 10000 * Unit.W; 
			double cpu = 10 * Unit.kFLOP;
			double maxThrust = 1; // N			
			boolean vectored = true;
			
			//Align along axis of spacecraft
			EngineVector engineVector = new EngineVector(1,0,0);
			
			return new SimpleIonEngine(
					SMALL_ION_ENGINE, mass, volume, power, cpu, 
					maxThrust, thrustModel, engineVector, vectored);
		}

		return null;
	}

}

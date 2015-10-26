package org.braincycles.spacebits.components.engines.thrust;

import org.braincycles.spacebits.components.engines.AbstractEngine;
import org.braincycles.spacebits.components.engines.EngineVector;
import org.braincycles.spacebits.models.thrust.ThrustModel;

public class SimpleIonEngine extends AbstractEngine {

	public SimpleIonEngine(String name, double mass, double volume,
			double power, double cpu, double maxThrust, ThrustModel thrustModel, EngineVector engineVector, boolean vectored) {
		super(name, mass, volume, power, cpu, maxThrust, thrustModel, engineVector, vectored);
	}


	
}

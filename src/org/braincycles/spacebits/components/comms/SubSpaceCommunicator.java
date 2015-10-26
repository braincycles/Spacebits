package org.braincycles.spacebits.components.comms;

import org.braincycles.spacebits.models.Model;

public class SubSpaceCommunicator extends AbstractCommunicationComponent {

	public SubSpaceCommunicator(String name, double mass, double volume,
			double power, double cpu, Model propagationModel) {
		super(name, mass, volume, power, cpu, propagationModel);
	}

	@Override
	public String describe() {
		return "Sub-space communication device";
	}

	@Override
	public boolean runDiagnostics(int level) {
		return true;
	}
	
	
	
	
}

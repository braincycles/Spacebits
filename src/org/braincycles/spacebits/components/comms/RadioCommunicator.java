package org.braincycles.spacebits.components.comms;

import org.braincycles.spacebits.models.Model;

public class RadioCommunicator extends AbstractCommunicationComponent {

	public RadioCommunicator(String name, double mass, double volume,
			double power, double cpu, Model propagationModel) {
		super(name, mass, volume, power, cpu, propagationModel);
	}

	@Override
	public String describe() {
		return "RF communication device";
	}


	@Override
	public boolean runDiagnostics(int level) {
		
		if(propagationModel == null)
			systemComputer.addSystemMessage(
					this, "Level " + level + "diagnostics : Problem. No propagation model.", -1);
		else 
			systemComputer.addSystemMessage(
					this, "Running diagnostics [level " + level + "].", 0);
		
		return true;
	}

	
}

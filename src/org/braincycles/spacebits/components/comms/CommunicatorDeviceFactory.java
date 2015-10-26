package org.braincycles.spacebits.components.comms;

import org.braincycles.spacebits.Unit;
import org.braincycles.spacebits.models.Model;
import org.braincycles.spacebits.models.SimpleRadioFrequencyPropagationModel;


public class CommunicatorDeviceFactory {
	
	public static String SMALL_RF_COMMUNICATOR = "Small RF Communicator";
	public static String SMALL_SUBSPACE_COMMUNICATOR = "Small Sub-space Communicator";

	public static CommunicationComponent getCommunicator(String commType){
		if(commType.equalsIgnoreCase(SMALL_RF_COMMUNICATOR)){
			double mass = 25.0;//Kg
			double volume = 1.0;//m3
			double power = 10 * Unit.kW; //GJ
			double cpu = 1; //GFLOP
			Model propagationModel = new SimpleRadioFrequencyPropagationModel("RF");
			CommunicationComponent communicationComponent = 
					new RadioCommunicator(SMALL_RF_COMMUNICATOR, mass, volume, power, cpu, propagationModel);
			communicationComponent.setDeviceNoiseLevel(Unit.dBm2W(-80)); // -80 dBm
			communicationComponent.setEfficiency(0.9);
			return communicationComponent;
		}
		else if(commType.equalsIgnoreCase(SMALL_SUBSPACE_COMMUNICATOR)){
			double mass = 1000.0;//Kg
			double volume = 15.0;//m3
			double power = 1 * Unit.MW;
			double cpu = 100; //GFLOP
			Model propagationModel = new SimpleRadioFrequencyPropagationModel("SUBSPACE");
			CommunicationComponent communicationComponent = 
					new SubSpaceCommunicator(SMALL_SUBSPACE_COMMUNICATOR, mass, volume, power, cpu, propagationModel);
			return communicationComponent;
		}
		return null;
	}
	

}

package org.braincycles.spacebits.components.comms;

import java.util.List;

import org.braincycles.spacebits.Unit;
import org.braincycles.spacebits.components.AbstractComponent;
import org.braincycles.spacebits.components.computers.os.Message;
import org.braincycles.spacebits.models.Model;
import org.braincycles.spacebits.models.ModelInputs;
import org.braincycles.spacebits.models.ModelResult;
import org.braincycles.spacebits.models.SimpleRadioFrequencyPropagationModel;

public abstract class AbstractCommunicationComponent extends AbstractComponent implements
		CommunicationComponent {
	
	private static double MAX_POWER_LEVEL = 100;
	
	protected double maxPower;
	protected double range;
	protected double powerLevel;
	protected double efficiency = 0.3;
	protected double deviceNoiseLevel = Unit.dBm2W(-80); // GJ/s or GW
	
	protected List<String> recievedMessages;
	protected List<String> broadcastMessages;
	
	protected int broadcastMessageQueueSize = 10;
	
	protected Model propagationModel;
	

	public AbstractCommunicationComponent(String name, double mass,
			double volume, double power, double cpu, Model propagationModel) {
		super(name, mass, volume, power, cpu);
		this.maxPower = power;
		this.propagationModel = propagationModel;
	}


	@Override
	public void broadcast(String message, int recipient) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean hasRecievedMessages() {
		return recievedMessages.size() > 0;
	}

	@Override
	public List<String> getMessages() {
		return recievedMessages;
	}

	@Override
	public boolean addMessageToQueue(String message) {
		if(broadcastMessageQueueSize != broadcastMessages.size()) {
			broadcastMessages.add(message);
			return true;
		}
		else {
			return false;
		}
	}


	public double getMaxPower() {
		return maxPower;
	}


	public void setMaxPower(double maxPower) {
		this.maxPower = maxPower;
	}


	public double getPowerLevel() {
		return powerLevel;
	}


	public void setPowerLevel(double powerLevel) {
		this.powerLevel = powerLevel;
	}
	
	
	public double getRange() {
		return getRange(this.powerLevel);
	}
	
	
	public double getRange(double powerLevel) {
		ModelInputs inputs = new ModelInputs();
		inputs.addInput("CALC_TYPE", SimpleRadioFrequencyPropagationModel.RANGE_CALC);
		inputs.addInput("POWER", maxPower * (powerLevel/100.00));
		inputs.addInput("NOISE", 0);
		inputs.addInput("EFFICIENCY", this.efficiency);
		inputs.addInput("RECIEVE_THRESHOLD", this.deviceNoiseLevel); //GJ/s
		inputs.addInput("MAX_POWER", maxPower);

		ModelResult result = propagationModel.getResult(inputs);
		return result.getResult("CALCULATED_RANGE");
	}
	


	@Override
	public boolean requestRange(double powerLevel) {
		//XXX FIX!
		double calcedRange = getRange(powerLevel);
		return calcedRange >= range;
	}


	@Override
	public double getMaximumRange() {
		return getRange(MAX_POWER_LEVEL);
	}


	public double getEfficiency() {
		return efficiency;
	}


	public void setEfficiency(double efficiency) {
		this.efficiency = efficiency;
	}


	@Override
	public void setDeviceNoiseLevel(double recieveThreshold) {
		this.deviceNoiseLevel = recieveThreshold;
	}
	
	@Override
	public double getDeviceNoiseLevel() {
		return this.deviceNoiseLevel;
	}


	@Override
	public void recieveMessage(Message message) {
		System.out.println("Message recieved by comm device: " + getName() + "\n " + message.getMessage());
		
	}
	
	
	

}

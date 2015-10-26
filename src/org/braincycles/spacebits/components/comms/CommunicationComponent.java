package org.braincycles.spacebits.components.comms;

import java.util.List;

import org.braincycles.spacebits.components.Component;

public interface CommunicationComponent extends Component {
	
	public void broadcast(String message, int recipient);
	
	public boolean hasRecievedMessages();
	
	public List<String> getMessages();
	
	public boolean addMessageToQueue(String message);
	
	public void setPowerLevel(double powerLevel);

	public double getRange();
	
	public boolean requestRange(double range);
	
	public double getMaximumRange();
	
	public void setDeviceNoiseLevel(double deviceNoiseLevel);
	public double getDeviceNoiseLevel();
	
	public double getEfficiency();
	public void setEfficiency(double efficiency);
	
}

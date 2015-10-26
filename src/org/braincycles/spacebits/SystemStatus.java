package org.braincycles.spacebits;

import java.util.ArrayList;
import java.util.List;

import org.braincycles.spacebits.components.Component;

public class SystemStatus {
	
	private int status;
	private Component component;
	private List<SystemStatusMessage> messages;

	public SystemStatus(Component component, int status, List<SystemStatusMessage> messages) {
		super();
		this.component = component;
		this.status = status;
		this.messages = messages;
	}
	
	public SystemStatus(Component component) {
		super();
		this.component = component;
		this.status = 0;
		this.messages = new ArrayList<SystemStatusMessage>();
	}
	
	public SystemStatus mergeSystemStatus(SystemStatus systemStatus) {
		//If the incoming status is false, set the status to false.	
		if(systemStatus.getStatus() < 0)
			this.status = -1;
		//Merge all messages
		this.messages.addAll(systemStatus.getMessages());
		return this;
	}
	
	public void addSystemMessage(SystemStatusMessage systemStatusMessage) {
		this.messages.add(systemStatusMessage);
	}
	
	public void addSystemMessage(String message, int dateTime, int status) {
		this.messages.add(new SystemStatusMessage(component, message, dateTime, status));
		this.status = status;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public List<SystemStatusMessage> getMessages() {
		return messages;
	}

	public void setMessages(List<SystemStatusMessage> messages) {
		this.messages = messages;
	}

	@Override
	public String toString() {
		return "SystemStatus//"+ component.getName() + "// [status=" + status + ", messages=" + messages
				+ "]";
	}
	
	

}

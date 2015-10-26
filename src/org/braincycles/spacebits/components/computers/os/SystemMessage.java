package org.braincycles.spacebits.components.computers.os;

import org.braincycles.spacebits.components.Component;

public class SystemMessage implements Message {
	
	private Component reciever;
	
	private Component sender;
	
	private String messageBody;
	
	private double universalDate;
	
	
	
	
	public SystemMessage(Component reciever, Component sender,
			String messageBody, double universalDate) {
		super();
		this.reciever = reciever;
		this.sender = sender;
		this.messageBody = messageBody;
		this.universalDate = universalDate;
	}

	@Override
	public int getRecieverIdent() {
		return reciever.getIdent();
	}

	@Override
	public int getSenderIdent() {
		return sender.getIdent();
	}

	@Override
	public String getMessage() {
		return messageBody;
	}

	@Override
	public double getUniversalDate() {
		return universalDate;
	}

}

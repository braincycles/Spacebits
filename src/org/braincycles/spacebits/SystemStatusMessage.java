package org.braincycles.spacebits;

import java.text.DecimalFormat;

import org.braincycles.spacebits.components.Component;

public class SystemStatusMessage {
	
	private Component component;
	private String message;
	private double universalDate;
	private int status;
	
	
	public SystemStatusMessage(Component component, String message, double universalDate, int status) {
		super();
		this.component = component;
		this.message = message;
		this.universalDate = universalDate;
		this.status = status;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public double getUniversalDate() {
		return universalDate;
	}


	public void setUniversalDate(double universalDate) {
		this.universalDate = universalDate;
	}


	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}


	@Override
	public String toString() {
		DecimalFormat format = new DecimalFormat("0000.0000000000000");
		return format.format(universalDate) + " : " + component.getName() +": [message=" + message + " status=" + status + "]";
	}
	
	
	
	

}

package org.braincycles.spacebits.structures.hulls;

import org.braincycles.spacebits.components.AbstractComponent;
import org.braincycles.spacebits.components.computers.os.Message;

public abstract class AbstractHull extends AbstractComponent implements Hull {
	
	protected double length;
	protected double width;


	public AbstractHull(String name, double mass, double volume, double power, double cpu, double length, double width) {
		super(name, mass, volume, power, cpu);
		setLength(length);
		setWidth(width);
	}
	

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}


	@Override
	public void recieveMessage(Message message) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public String describe() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public boolean runDiagnostics(int level) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public double getVolume() {
		//Negative as this component PROVIDES volume to the spacecraft
		return super.getVolume() * -1;
	}
	
	
	
	

}

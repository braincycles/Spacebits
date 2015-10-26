package org.braincycles.spacebits.components;

import org.braincycles.spacebits.Diagnosable;
import org.braincycles.spacebits.SystemStatus;
import org.braincycles.spacebits.components.computers.SystemComputer;
import org.braincycles.spacebits.components.computers.os.Message;

public interface Component extends Diagnosable {
	
	public void setName(String name);

    public void setMass(double mass);

    public void setCPU(double cpu);

    public void setVolume(double volume);
    
    public void setPower(double power);

    public String getName();

    public double getMass();

    public double getCPU();

    public double getVolume();
    
    public double getPower();
    
    public int getIdent();
    
    public void recieveMessage(Message message);
    
    public void registerSystemComputer(SystemComputer computer);

    public String describe();
    
    public void accept(ComponentVisitor componentVisitor);
    
    public SystemStatus online();
    
}

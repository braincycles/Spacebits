package org.braincycles.spacebits.components.computers.os;

import org.braincycles.spacebits.components.Component;

public interface MessageMediator {
	
	public boolean sendMessageTo(Message message, Component component);
	
	public int broadcastMessage(Message message);
	 
    public boolean addComponent(Component component);

}

package org.braincycles.spacebits.components.computers.os;

import java.util.ArrayList;
import java.util.List;

import org.braincycles.spacebits.components.Component;

public class SystemMessageService implements MessageMediator {

	
	private List<Component> registeredComponents;
	
	public SystemMessageService() {
		registeredComponents = new ArrayList<Component>();
	}
	
	@Override
	public boolean addComponent(Component component) {
		return registeredComponents.add(component);	
	}
	

	@Override
	public boolean sendMessageTo(Message message, Component component) {
		int componentIndex = registeredComponents.indexOf(component);
		boolean componentIsRegistered = componentIndex != -1;
		if(componentIsRegistered)
			registeredComponents.get(componentIndex).recieveMessage(message);
		return componentIsRegistered;
	}


	@Override
	public int broadcastMessage(Message message) {
		int counter = 0;
		for(Component component : registeredComponents) {
			component.recieveMessage(message);
			counter++;
		}
		return counter;
	}

	
	
	
}

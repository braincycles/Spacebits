package org.braincycles.spacebits.components.computers;

import org.braincycles.spacebits.Unit;
import org.braincycles.spacebits.components.computers.os.MessageMediator;
import org.braincycles.spacebits.components.computers.os.SystemMessageService;

public class ComputerFactory {
	
	public static int SIMPLE_SYSTEM = 1;
	public static int SIMPLE_NAVIGATION = 2;

	public static Computer getComputer(int computerType){
		if(computerType == SIMPLE_SYSTEM){
			double mass = 25.0;//Kg
			double volume = 1.0;//m3
			double power = 10000 * Unit.W; 
			double cpu = 1; //GFLOP
			double maxCPUThroughput = 1000; //GFLOP
			SystemComputer computer = new BasicSystemComputer("Simple System Computer", mass, volume, power,cpu, maxCPUThroughput);
			MessageMediator messagingSystem = new SystemMessageService();
			computer.setMessagingSystem(messagingSystem);
			return computer;
		}
		
		else if(computerType == SIMPLE_NAVIGATION){
			double mass = 25.0;//Kg
			double volume = 1.0;//m3
			double power = 10000 * Unit.W; 
			double cpu = 1; //GFLOP
			double maxCPUThroughput = 1000; //GFLOP
			Computer computer = new BasicNavigationComputer("Simple Navigation Computer", mass, volume, power,cpu, maxCPUThroughput);
			return computer;
		}

		return null;
	}

}



import java.util.List;

import org.braincycles.spacebits.Spacecraft;
import org.braincycles.spacebits.SpacecraftFactory;
import org.braincycles.spacebits.SystemStatus;
import org.braincycles.spacebits.SystemStatusMessage;
import org.braincycles.spacebits.Unit;
import org.braincycles.spacebits.components.computers.os.Message;
import org.braincycles.spacebits.components.computers.os.SystemMessage;
import org.braincycles.spacebits.universe.Universe;


public class Driver {
	
	
	public Driver() {
		
		
		double dBm = -50;
		double dB = -80;
		
		double W = 1e-8;
		
		//System.out.println(Unit.dBm2W(dBm));
		//System.out.println(Unit.dB2W(dB));
		
		//System.out.println(Unit.W2dBm(W));
		//System.out.println(Unit.W2dB(W));
		
		Universe universe = new Universe();
		
		Spacecraft simpleSpacecraft = SpacecraftFactory.getSpacecraft(SpacecraftFactory.SHUTTLE);
		simpleSpacecraft.onlineSystems();
		List<SystemStatusMessage> statusMessages = simpleSpacecraft.getSystemComputer().getSystemMessages();
		
		//Message message = new SystemMessage(null, null,"Hello", 34.3);
		//simpleSpacecraft.getSystemComputer().getMessagingSystem().broadcastMessage(message);
		
		//Read system status messages
		
		for(SystemStatusMessage statuses : statusMessages) {
			System.out.println(statuses.toString());
		}
		
		int ident = simpleSpacecraft.getIdentifier();
		System.out.println(simpleSpacecraft.getSystemComputer().getTotalMassOfComponents());
		
	}
	
	
	public static void main(String args[]) {
		new Driver();
	}
	
	

}

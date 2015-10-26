package org.braincycles.spacebits.structures.hulls;

import org.braincycles.spacebits.Unit;

public class HullFactory {

	public static String SHUTTLE = "Shuttle";


	public static Hull getHull(String hullType){
		if(hullType.equalsIgnoreCase(SHUTTLE)){
			double mass = 100000 * Unit.kg;
			double volume  = 2000 * Unit.m3;
			double power = 1 * Unit.kW;
			double cpu = 1 * Unit.kFLOP;
			double length = 25 * Unit.m;
			double width = 10 * Unit.m;
			return new SimpleHull("Shuttle",mass,volume,power,cpu,length,width);
		}

		return null;
	}


}

package org.braincycles.spacebits;

public class Unit {
	
	//Units for mass
	public static double g = 1e-3;
	public static double kg = 1;
	public static double Tonne = 1e3;
	
	//Units for volume
	public static double m3 = 1;
	
	//Units for CPU throughput
	public static double kFLOP = 1e-3;
	public static double MFLOP = 1;
	public static double GFLOP = 1e3;
	public static double TFLOP = 1e6;
	
	//Units for power
	public static double uW = 1e-6;
	public static double mW = 1e-3;
	public static double W = 1;
	public static double kW = 1e3;
	public static double MW = 1e6;
	public static double GW = 1e9;
	
	//Units for energy
	public static double GJ = 1e-9;
	
	//Units for length
	public static double cm = 1e-2;
	public static double m = 1;
	public static double Km = 1e3;
	public static double Ly = 9.461e+15;
	public static double Pc = 3.26 * Ly;
	
	
	
	public static double dBm2W(double power_dBm) {
		return dB2W(power_dBm-30);
	}
	
	public static double dB2W(double power_dB) {
		return 1*Math.pow(10,power_dB/10.0);
	}
	
	public static double W2dB(double power_W) {
		return 10*Math.log10(power_W/1.0);
	}
	
	public static double W2dBm(double power_W) {
		return W2dB(power_W)+30;
	}

}

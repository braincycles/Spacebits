package org.braincycles.spacebits.components.engines;

public class EngineVector {
	
	private double[] vectorComponents;

	public EngineVector(double[] vectorComponents) {
		super();
		this.vectorComponents = vectorComponents;
	}
	
	public EngineVector(double rollAxisComponent, double pitchAxisCompoent, double yawAxisComponent) {
		super();
		this.vectorComponents = new double[]{rollAxisComponent, pitchAxisCompoent, yawAxisComponent};
	}

	public double[] getVectorComponents() {
		return vectorComponents;
	}

	public void setVectorComponents(double[] vectorComponents) {
		this.vectorComponents = vectorComponents;
	}
	

}

package org.braincycles.spacebits.components.engines;

import org.braincycles.spacebits.components.Component;
import org.braincycles.spacebits.models.thrust.ThrustModel;

public interface Engine extends Component {
	public ThrustModel getThrustModel();
	public void setThrustModel(ThrustModel thrustModel);
	public double getThrust(double[] velocity);
	public void setPowerLevel(double powerLevel);
	public void setMaxThrust(double maxThrust);
	public double getMaxThrust();
	public EngineVector getEngineVector();
	public boolean isVectored();
}

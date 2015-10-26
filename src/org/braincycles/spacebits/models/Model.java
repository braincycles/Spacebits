package org.braincycles.spacebits.models;

public interface Model {
	
	public void setName(String name);

    public String getName();
    
    public ModelResult getResult(ModelInputs inputs);
    
    
}

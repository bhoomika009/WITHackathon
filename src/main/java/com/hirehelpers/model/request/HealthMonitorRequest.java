package com.hirehelpers.model.request;

public class HealthMonitorRequest {
	
	int helperId;
	
	String temperature;
	
	String pulseRate;

	public HealthMonitorRequest(){
		
	}
	public int getHelperId() {
		return helperId;
	}

	public void setHelperId(int helperId) {
		this.helperId = helperId;
	}

	public String getTemperature() {
		return temperature;
	}

	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}

	public String getPulseRate() {
		return pulseRate;
	}

	public void setPulseRate(String pulseRate) {
		this.pulseRate = pulseRate;
	}
	
	

}

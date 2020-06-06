package com.hirehelpers.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "healthmonitor")
public class HealthMonitor {
	
	@Id
	@GeneratedValue
	private int id;   

	private int helperId;
	
	private String temperature;
	
	private String pulseRate;
	
	/*@OneToOne(mappedBy = "healthMonitor")
	private Helper helper;
	*/
	public HealthMonitor() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public int getHelperId() {
		return helperId;
	}

	public void setHelperId(int helperId) {
		this.helperId = helperId;
	}

/*	public Helper getHelper() {
		return helper;
	}

	public void setHelper(Helper helper) {
		this.helper = helper;
	}
	*/

}

package com.hirehelpers.model.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "helper")
public class Helper {

	@Id
	@GeneratedValue
	private int id;   

	private String fname;
	private String lname;
	private String username;
	private String password;

	@Size(min=10, message="Enter at least 10 Characters...")
	private String address;

	private long contactNumber;

	private long aadharNumber;

	private int agentId;

	private boolean isHired;

	private String hireDate;

	private int hireById;

	private String category;
	
	/*@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "health_id", referencedColumnName = "id")
	private HealthMonitor healthMonitor;*/
	
	public Helper() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}

	public long getAadharNumber() {
		return aadharNumber;
	}

	public void setAadharNumber(long aadharNumber) {
		this.aadharNumber = aadharNumber;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAgentId() {
		return agentId;
	}

	public void setAgentId(int agentId) {
		this.agentId = agentId;
	}

	public boolean isHired() {
		return isHired;
	}

	public void setHired(boolean isHired) {
		this.isHired = isHired;
	}

	public String getHireDate() {
		return hireDate;
	}

	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}

	public int getHireById() {
		return hireById;
	}

	public void setHireById(int hireById) {
		this.hireById = hireById;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	/*public HealthMonitor getHealthMonitor() {
		return healthMonitor;
	}

	public void setHealthMonitor(HealthMonitor healthMonitor) {
		this.healthMonitor = healthMonitor;
	}
*/
	@Override
	public int hashCode() {
		final int prime = 64;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Helper other = (Helper) obj;
		if (id != other.id) {
			return false;
		}
		
		return true;
	}

	@Override
	public String toString() {
		return String.format(
				"User [id=%s, Firstname=%s, Lastname=%s, address=%s, contactnum=%s]", id,
				fname,lname, address, contactNumber);
	}


}
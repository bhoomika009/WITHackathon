package com.hirehelpers.model.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
public class Agent {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;   

	@Size(max=8, message="Enter at max 8 Characters for agentId")
	@NotEmpty(message="AgentId cannot be empty")
	private String agentId;
	
	@Size(max=8, message="Enter at max 8 Characters for pan number")
	@NotEmpty(message="AgentId cannot be empty")
	private String panNo;
	
	@NotEmpty(message="Agent Password cannot be empty")
	private String agentPwd;	

	
	@Size(min=10, message="Enter at least 10 Characters for AgencyName")
	private String agencyName;

	@Size(min=10, message="Enter at least 10 Characters...")
	private String address;   


	@Min(value=10, message="Contact Number cannot be less than 10digits")	
	private long contactNumber;

	public Agent() {
		// TODO Auto-generated constructor stub	
		super();
	}



	public Agent(int id, String agentId, String panNo, String agentPwd, String agencyName, String address, long contactNumber) {
		super();
		this.id = id;
		this.agentId= agentId;
		this.panNo=panNo;
		this.agentPwd=agentPwd;
		this.agencyName =agencyName;
		this.address=address;
		this.contactNumber=contactNumber;

	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getAgentId() {
		return agentId;
	}

	public void setAgentId(String agentId) {
		this.agentId = agentId;
	}

	public String getAgentPwd() {
		return agentPwd;
	}


	public void setAgentPwd(String agentPwd) {
		this.agentPwd = agentPwd;
	}
	

	public String getPanNo() {
		return panNo;
	}



	public void setPanNo(String panNo) {
		this.panNo = panNo;
	}
	
	public String getName() {
		return agencyName;
	}

	public void setName(String agencyName) {
		this.agencyName = agencyName;
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


	@Override
	public int hashCode() {
		final int prime = 10;
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
		Agent other = (Agent) obj;
		if (id != other.id) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return String.format(
				"Agent [id=%s, agencyName=%s, address=%s, contactnum=%s]", id,
				agencyName, address, contactNumber);
	}

}
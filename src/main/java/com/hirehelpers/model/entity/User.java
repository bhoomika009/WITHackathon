package com.hirehelpers.model.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;
import javax.validation.constraints.Size;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;  
	@Size(max=8, message="Enter at max 8 Characters for UserId")
	@NotEmpty(message="UserId cannot be empty")
	private String userId;
	
	@NotEmpty(message="User Password cannot be empty")
	private String userPwd;	


	@NotEmpty(message="First Name cannot be empty")
	private String fname;

	@NotEmpty(message="Last Name cannot be empty")
	private String lname;
	
	@Size(min=10, message="Enter at least 10 Characters...")
	private String address;
	@Min(value=10, message="Contact Number cannot be less than 10digits")	
	private long contactNumber;

	public User() {
		// TODO Auto-generated constructor stub	
		super();
	}

	public User(int id, String userId, String userPwd, String fname, String lname, String address, long contactNumber) {
		super();
		this.id = id;
		this.userId =userId;
		this.userPwd=userPwd;
		this.fname =fname;
		this.lname =lname;
		this.address=address;
		this.contactNumber=contactNumber;
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
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

	@Override
	public int hashCode() {
		final int prime = 45;
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
		User other = (User) obj;
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

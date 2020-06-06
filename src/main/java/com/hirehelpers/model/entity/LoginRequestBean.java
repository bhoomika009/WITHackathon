package com.hirehelpers.model.entity;
public class LoginRequestBean {

	private String loginId;

	private String loginPwd;

	public LoginRequestBean() {
		super();
	}	

	public LoginRequestBean(String loginId, String loginPwd) {
		super();
		this.loginId = loginId;
		this.loginPwd = loginPwd;
	}    

	public String getLoginId() {
		return loginId;
	}


	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}


	public String getLoginPwd() {
		return loginPwd;
	}


	public void setLoginPwd(String loginPwd) {
		this.loginPwd = loginPwd;
	}

	@Override
	public String toString() {
		return String.format("Login RequestBean [loginId=%s]", loginId);
	}

}

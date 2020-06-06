package com.hirehelpers.model.response;
public class RegisterResponeBean {

    private boolean status;
	
	private String message;

    public RegisterResponeBean(boolean statusCode, String message) {
    	this.status=statusCode;
        this.message = message;
    }

    public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

   

	public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return String.format("HelloWorldBean [message=%s]", message);
    }

}
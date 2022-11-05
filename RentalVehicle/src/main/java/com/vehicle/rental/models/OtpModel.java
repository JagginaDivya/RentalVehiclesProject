package com.vehicle.rental.models;


public class OtpModel {
	
	private String email;
    private String otp;
    
    
	public String getKey() {
		return email;
	}
	public void setKey(String key) {
		this.email = key;
	}
	public String getOtp() {
		return otp;
	}
	public void setOtp(String otp) {
		this.otp = otp;
	}

}

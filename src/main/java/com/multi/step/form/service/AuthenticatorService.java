package com.multi.step.form.service;

import org.springframework.stereotype.Service;

import com.warrenstrange.googleauth.GoogleAuthenticator;
import com.warrenstrange.googleauth.GoogleAuthenticatorKey;

@Service
public class AuthenticatorService {

	private final GoogleAuthenticator googleAuthenticator = new GoogleAuthenticator();
	
	public String generateSecrateKey() {
		GoogleAuthenticatorKey key = googleAuthenticator.createCredentials();
		return key.getKey();
	}
	
	 public String getQRBarcodeURL(String userEmail, String secretKey) {
	    String appName = "SYN Portal"; // Replace with your application name
	    return String.format("otpauth://totp/%s:%s?secret=%s&issuer=%s",appName, userEmail, secretKey, appName);
	 }
	 
	 public boolean verifyAuthenticatorOtp(String secretKey, int otp) {
	    return googleAuthenticator.authorize(secretKey, otp);
	 }
}

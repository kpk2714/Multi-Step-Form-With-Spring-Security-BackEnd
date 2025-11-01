package com.multi.step.form.service;

import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import jakarta.servlet.http.HttpServletRequest;

@Service
public class LocationService {

	private final RestTemplate restTemplate = new RestTemplate();
	
	public String getClientIp(HttpServletRequest request) {
		
		String[] headers = {
				"X-Forwarded-For",
				"X-Real-IP",
				"Proxy-Client-IP",
				"WL-Proxy-Clien-IP",
				"HTTP_CLIENT_IP",
				"HTTP_X_FORWARDED_FOR"
		};
		System.out.println("Location Service is called");
		
		String ip = "";
		
		for(String header : headers) {
			String ipAddr = request.getHeader(header);
			if(ip!=null && !ip.isEmpty() && !"unknown".equalsIgnoreCase(ip)) {
				ip =  ipAddr.split(",")[0].trim();
			}
		}
		
		return ip;
		
	}
	
	public JSONObject getLocationDetails(String ip) {
		String url = "http://ip-api.com/json/" + ip;
		String response = restTemplate.getForObject(url, String.class);
		return new JSONObject(response);
	}
}

package com.multi.step.form.config;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.multi.step.form.entities.AuthClientUser;
import com.multi.step.form.entities.User;
import com.multi.step.form.repository.AuthClientUserRepository;
import com.multi.step.form.service.LocationService;
import com.multi.step.form.service.UserService;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class OAuth2LoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

	@Autowired
	private AuthClientUserRepository authClientUserRepository;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private LocationService locationService;
	
	@Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) 
            throws IOException, ServletException {

        OAuth2User oAuth2User = (OAuth2User) authentication.getPrincipal();
        Map<String, Object> attributes = oAuth2User.getAttributes();

        
        String email = (String) attributes.get("email");
        String firstName = (String) attributes.get("given_name");
        String lastName = (String) attributes.get("family_name");
        String profilePictureUrl = (String) attributes.get("picture");
        
        System.out.println("OnAuthenticationSuccess is called");
        
        byte[] profilePictureData = downloadImage(profilePictureUrl);
        
        String ip = locationService.getClientIp(request);
        JSONObject locationData = locationService.getLocationDetails(ip);
        
        String city = locationData.optString("city", "Unknown");
        String town = locationData.optString("regionName", "Unknown");
        String country = locationData.optString("country", "Unknown");
        String region = locationData.optString("regionName", "Unknown");
        String pincode = locationData.optString("zip", "Unknown");
        double latitude = locationData.optDouble("lat", 0);
        double longitude = locationData.optDouble("lon", 0);

        // Check if the user exists in the database
        User registeredUser = userService.getUser(email);

        if (registeredUser != null) {
        	
        	AuthClientUser existingUser = authClientUserRepository.findByEmail(email);
        	
            if(existingUser==null) {
            	
            	AuthClientUser newUser = new AuthClientUser();
                newUser.setEmail(email);
                newUser.setFirstName(firstName);
                newUser.setLastName(lastName);
                newUser.setUsername(registeredUser.getUsername());
                newUser.setProfilePicture(profilePictureData);
                newUser.setWindowIP(ip);
                newUser.setCity(city);
                newUser.setTown(town);
                newUser.setCountry(country);
                newUser.setRegion(region);
                newUser.setPincode(pincode);
                newUser.setLatitude(latitude);
                newUser.setLongitude(longitude);
                newUser.setRole(registeredUser.getRoles()); // Assign role from Login table
                authClientUserRepository.save(newUser);
                
                System.out.println("✅ User stored: " + newUser);
                
            } else {
            	
            	existingUser.setFirstName(firstName);
            	existingUser.setLastName(lastName);
            	existingUser.setUsername(registeredUser.getUsername());
            	existingUser.setProfilePicture(profilePictureData);
            	existingUser.setWindowIP(ip);
            	existingUser.setCity(city);
            	existingUser.setTown(town);
            	existingUser.setCountry(country);
            	existingUser.setRegion(region);
            	existingUser.setPincode(pincode);
            	existingUser.setLatitude(latitude);
            	existingUser.setLongitude(longitude);
            	existingUser.setRole(registeredUser.getRoles()); // Assign role from Login table
            	existingUser = authClientUserRepository.save(existingUser);
            	
            	System.out.println("✅ User stored: " + existingUser);
                
            }
            
        }
        
        // Redirect to appropriate dashboard
        String redirectUrl = "http://localhost:4200/continue";

        setDefaultTargetUrl(redirectUrl);
        super.onAuthenticationSuccess(request, response, authentication);
    }
	
	// Method to download image from URL and convert to byte array
    private byte[] downloadImage(String imageUrl) {
        try {
            URL url = new URL(imageUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("User-Agent", "Mozilla/5.0");
            connection.setDoInput(true);

            try (InputStream inputStream = connection.getInputStream()) {
                return inputStream.readAllBytes(); // Convert input stream to byte array
            }
        } catch (Exception e) {
            System.err.println("⚠️ Failed to download image: " + e.getMessage());
            return new byte[0]; // Return empty array if download fails
        }
    }
}

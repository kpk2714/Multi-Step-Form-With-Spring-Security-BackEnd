package com.multi.step.form.entities;

import java.util.Arrays;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

@Entity
public class AuthClientUser {

	@Id
	@GeneratedValue( strategy = GenerationType.AUTO)
	private int id;
	private String firstName;
    private String lastName;
    private String email;
    private String username;
    @Lob
    @Column(columnDefinition = "LONGBLOB") // MySQL: LONGBLOB, PostgreSQL: BYTEA
    private byte[] profilePicture;
    private String windowIP;
    
    private String city;
    private String town;
    private String country;
    private String region;
    private String pincode;
    private double latitude;
    private double longitude;
    
    private String role;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public byte[] getProfilePicture() {
		return profilePicture;
	}

	public void setProfilePicture(byte[] profilePicture) {
		this.profilePicture = profilePicture;
	}

	public String getWindowIP() {
		return windowIP;
	}

	public void setWindowIP(String windowIP) {
		this.windowIP = windowIP;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public AuthClientUser(int id, String firstName, String lastName, String email, String username,
			byte[] profilePicture, String windowIP, String city, String town, String country, String region,
			String pincode, double latitude, double longitude, String role) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.username = username;
		this.profilePicture = profilePicture;
		this.windowIP = windowIP;
		this.city = city;
		this.town = town;
		this.country = country;
		this.region = region;
		this.pincode = pincode;
		this.latitude = latitude;
		this.longitude = longitude;
		this.role = role;
	}

	public AuthClientUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "AuthClientUser [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", username=" + username + ", profilePicture=" + Arrays.toString(profilePicture) + ", windowIP="
				+ windowIP + ", city=" + city + ", town=" + town + ", country=" + country + ", region=" + region
				+ ", pincode=" + pincode + ", latitude=" + latitude + ", longitude=" + longitude + ", role=" + role
				+ "]";
	}
}

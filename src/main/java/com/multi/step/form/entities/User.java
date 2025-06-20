package com.multi.step.form.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String studentId;
	private String name;
	private String email;
	private String mobile;
	private String dob;
	private String state;
	private String university;
	private String institution;
	private String department;
	private String degree;
	private String year;
	private String semester;
	private String registration;
	private String roll;
	private String district;
	private String policeStation;
	private String post;
	private String pin;
	private String address;
	private String username;
	private String password;
	private String repassword;
	private String roles;
	private boolean enabled;
	private boolean rememberMe;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getUniversity() {
		return university;
	}
	public void setUniversity(String university) {
		this.university = university;
	}
	public String getInstitution() {
		return institution;
	}
	public void setInstitution(String institution) {
		this.institution = institution;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getSemester() {
		return semester;
	}
	public void setSemester(String semester) {
		this.semester = semester;
	}
	public String getRegistration() {
		return registration;
	}
	public void setRegistration(String registration) {
		this.registration = registration;
	}
	public String getRoll() {
		return roll;
	}
	public void setRoll(String roll) {
		this.roll = roll;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getPoliceStation() {
		return policeStation;
	}
	public void setPoliceStation(String policeStation) {
		this.policeStation = policeStation;
	}
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	public String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
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
	public String getRepassword() {
		return repassword;
	}
	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}
	public String getRoles() {
		return roles;
	}
	public void setRoles(String roles) {
		this.roles = roles;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public boolean isRememberMe() {
		return rememberMe;
	}
	public void setRememberMe(boolean rememberMe) {
		this.rememberMe = rememberMe;
	}
	public User(int id, String studentId, String name, String email, String mobile, String dob, String state,
			String university, String institution, String department, String degree, String year, String semester,
			String registration, String roll, String district, String policeStation, String post, String pin,
			String address, String username, String password, String repassword, String roles, boolean enabled,
			boolean rememberMe) {
		super();
		this.id = id;
		this.studentId = studentId;
		this.name = name;
		this.email = email;
		this.mobile = mobile;
		this.dob = dob;
		this.state = state;
		this.university = university;
		this.institution = institution;
		this.department = department;
		this.degree = degree;
		this.year = year;
		this.semester = semester;
		this.registration = registration;
		this.roll = roll;
		this.district = district;
		this.policeStation = policeStation;
		this.post = post;
		this.pin = pin;
		this.address = address;
		this.username = username;
		this.password = password;
		this.repassword = repassword;
		this.roles = roles;
		this.enabled = enabled;
		this.rememberMe = rememberMe;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", studentId=" + studentId + ", name=" + name + ", email=" + email + ", mobile="
				+ mobile + ", dob=" + dob + ", state=" + state + ", university=" + university + ", institution="
				+ institution + ", department=" + department + ", degree=" + degree + ", year=" + year + ", semester="
				+ semester + ", registration=" + registration + ", roll=" + roll + ", district=" + district
				+ ", policeStation=" + policeStation + ", post=" + post + ", pin=" + pin + ", address=" + address
				+ ", username=" + username + ", password=" + password + ", repassword=" + repassword + ", roles="
				+ roles + ", enabled=" + enabled + ", rememberMe=" + rememberMe + "]";
	}
	
	
}

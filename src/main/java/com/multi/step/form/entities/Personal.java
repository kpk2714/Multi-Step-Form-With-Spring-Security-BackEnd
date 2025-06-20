package com.multi.step.form.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Personal {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String userId;
	private String title;
	private String firstname;
	private String middlename;
	private String lastname;
	private String gender;
	private String dob;
	private String email;
	private String relation;
	private String alteremail;
	private String mobile;
	private String altermobile;
	private String relationpersonname;
	private String relationpersonmobile;
	private String nationality;
	private String citizen;
	private String religion;
	private String state;
	private String district;
	private String blood;
	private String reservation;
	private String aadhar;
	private String marital;
	private String drivinglicense;
	private String drivinglicensenumber;
	private String drivinglicensename;
	private String drivinglicenseplace;
	private String pancard;
	private String pancardnumber;
	private String pancardname;
	private String pancardplace;
	private String votercard;
	private String votercardnumber;
	private String votercardname;
	private String votercardplace;
	private String passport;
	private String passportnumber;
	private String passportname;
	private String passportplace;
	private String address1;
	private String address2;
	private String landmark;
	private String country;
	private String mailingstate;
	private String mailingdistrict;
	private String city;
	private String postalcode;
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getMiddlename() {
		return middlename;
	}
	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRelation() {
		return relation;
	}
	public void setRelation(String relation) {
		this.relation = relation;
	}
	public String getAlteremail() {
		return alteremail;
	}
	public void setAlteremail(String alteremail) {
		this.alteremail = alteremail;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getAltermobile() {
		return altermobile;
	}
	public void setAltermobile(String altermobile) {
		this.altermobile = altermobile;
	}
	public String getRelationpersonname() {
		return relationpersonname;
	}
	public void setRelationpersonname(String relationpersonname) {
		this.relationpersonname = relationpersonname;
	}
	public String getRelationpersonmobile() {
		return relationpersonmobile;
	}
	public void setRelationpersonmobile(String relationpersonmobile) {
		this.relationpersonmobile = relationpersonmobile;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public String getCitizen() {
		return citizen;
	}
	public void setCitizen(String citizen) {
		this.citizen = citizen;
	}
	public String getReligion() {
		return religion;
	}
	public void setReligion(String religion) {
		this.religion = religion;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getBlood() {
		return blood;
	}
	public void setBlood(String blood) {
		this.blood = blood;
	}
	public String getReservation() {
		return reservation;
	}
	public void setReservation(String reservation) {
		this.reservation = reservation;
	}
	public String getAadhar() {
		return aadhar;
	}
	public void setAadhar(String aadhar) {
		this.aadhar = aadhar;
	}
	public String getMarital() {
		return marital;
	}
	public void setMarital(String marital) {
		this.marital = marital;
	}
	public String getDrivinglicense() {
		return drivinglicense;
	}
	public void setDrivinglicense(String drivinglicense) {
		this.drivinglicense = drivinglicense;
	}
	public String getDrivinglicensenumber() {
		return drivinglicensenumber;
	}
	public void setDrivinglicensenumber(String drivinglicensenumber) {
		this.drivinglicensenumber = drivinglicensenumber;
	}
	public String getDrivinglicensename() {
		return drivinglicensename;
	}
	public void setDrivinglicensename(String drivinglicensename) {
		this.drivinglicensename = drivinglicensename;
	}
	public String getDrivinglicenseplace() {
		return drivinglicenseplace;
	}
	public void setDrivinglicenseplace(String drivinglicenseplace) {
		this.drivinglicenseplace = drivinglicenseplace;
	}
	public String getPancard() {
		return pancard;
	}
	public void setPancard(String pancard) {
		this.pancard = pancard;
	}
	public String getPancardnumber() {
		return pancardnumber;
	}
	public void setPancardnumber(String pancardnumber) {
		this.pancardnumber = pancardnumber;
	}
	public String getPancardname() {
		return pancardname;
	}
	public void setPancardname(String pancardname) {
		this.pancardname = pancardname;
	}
	public String getPancardplace() {
		return pancardplace;
	}
	public void setPancardplace(String pancardplace) {
		this.pancardplace = pancardplace;
	}
	public String getVotercard() {
		return votercard;
	}
	public void setVotercard(String votercard) {
		this.votercard = votercard;
	}
	public String getVotercardnumber() {
		return votercardnumber;
	}
	public void setVotercardnumber(String votercardnumber) {
		this.votercardnumber = votercardnumber;
	}
	public String getVotercardname() {
		return votercardname;
	}
	public void setVotercardname(String votercardname) {
		this.votercardname = votercardname;
	}
	public String getVotercardplace() {
		return votercardplace;
	}
	public void setVotercardplace(String votercardplace) {
		this.votercardplace = votercardplace;
	}
	public String getPassport() {
		return passport;
	}
	public void setPassport(String passport) {
		this.passport = passport;
	}
	public String getPassportnumber() {
		return passportnumber;
	}
	public void setPassportnumber(String passportnumber) {
		this.passportnumber = passportnumber;
	}
	public String getPassportname() {
		return passportname;
	}
	public void setPassportname(String passportname) {
		this.passportname = passportname;
	}
	public String getPassportplace() {
		return passportplace;
	}
	public void setPassportplace(String passportplace) {
		this.passportplace = passportplace;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getLandmark() {
		return landmark;
	}
	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getMailingstate() {
		return mailingstate;
	}
	public void setMailingstate(String mailingstate) {
		this.mailingstate = mailingstate;
	}
	public String getMailingdistrict() {
		return mailingdistrict;
	}
	public void setMailingdistrict(String mailingdistrict) {
		this.mailingdistrict = mailingdistrict;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPostalcode() {
		return postalcode;
	}
	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	}
	public Personal(int id, String userId, String title, String firstname, String middlename, String lastname,
			String gender, String dob, String email, String relation, String alteremail, String mobile,
			String altermobile, String relationpersonname, String relationpersonmobile, String nationality,
			String citizen, String religion, String state, String district, String blood, String reservation,
			String aadhar, String marital, String drivinglicense, String drivinglicensenumber,
			String drivinglicensename, String drivinglicenseplace, String pancard, String pancardnumber,
			String pancardname, String pancardplace, String votercard, String votercardnumber, String votercardname,
			String votercardplace, String passport, String passportnumber, String passportname, String passportplace,
			String address1, String address2, String landmark, String country, String mailingstate,
			String mailingdistrict, String city, String postalcode) {
		super();
		this.id = id;
		this.userId = userId;
		this.title = title;
		this.firstname = firstname;
		this.middlename = middlename;
		this.lastname = lastname;
		this.gender = gender;
		this.dob = dob;
		this.email = email;
		this.relation = relation;
		this.alteremail = alteremail;
		this.mobile = mobile;
		this.altermobile = altermobile;
		this.relationpersonname = relationpersonname;
		this.relationpersonmobile = relationpersonmobile;
		this.nationality = nationality;
		this.citizen = citizen;
		this.religion = religion;
		this.state = state;
		this.district = district;
		this.blood = blood;
		this.reservation = reservation;
		this.aadhar = aadhar;
		this.marital = marital;
		this.drivinglicense = drivinglicense;
		this.drivinglicensenumber = drivinglicensenumber;
		this.drivinglicensename = drivinglicensename;
		this.drivinglicenseplace = drivinglicenseplace;
		this.pancard = pancard;
		this.pancardnumber = pancardnumber;
		this.pancardname = pancardname;
		this.pancardplace = pancardplace;
		this.votercard = votercard;
		this.votercardnumber = votercardnumber;
		this.votercardname = votercardname;
		this.votercardplace = votercardplace;
		this.passport = passport;
		this.passportnumber = passportnumber;
		this.passportname = passportname;
		this.passportplace = passportplace;
		this.address1 = address1;
		this.address2 = address2;
		this.landmark = landmark;
		this.country = country;
		this.mailingstate = mailingstate;
		this.mailingdistrict = mailingdistrict;
		this.city = city;
		this.postalcode = postalcode;
	}
	public Personal() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Personal [id=" + id + ", userId=" + userId + ", title=" + title + ", firstname=" + firstname
				+ ", middlename=" + middlename + ", lastname=" + lastname + ", gender=" + gender + ", dob=" + dob
				+ ", email=" + email + ", relation=" + relation + ", alteremail=" + alteremail + ", mobile=" + mobile
				+ ", altermobile=" + altermobile + ", relationpersonname=" + relationpersonname
				+ ", relationpersonmobile=" + relationpersonmobile + ", nationality=" + nationality + ", citizen="
				+ citizen + ", religion=" + religion + ", state=" + state + ", district=" + district + ", blood="
				+ blood + ", reservation=" + reservation + ", aadhar=" + aadhar + ", marital=" + marital
				+ ", drivinglicense=" + drivinglicense + ", drivinglicensenumber=" + drivinglicensenumber
				+ ", drivinglicensename=" + drivinglicensename + ", drivinglicenseplace=" + drivinglicenseplace
				+ ", pancard=" + pancard + ", pancardnumber=" + pancardnumber + ", pancardname=" + pancardname
				+ ", pancardplace=" + pancardplace + ", votercard=" + votercard + ", votercardnumber=" + votercardnumber
				+ ", votercardname=" + votercardname + ", votercardplace=" + votercardplace + ", passport=" + passport
				+ ", passportnumber=" + passportnumber + ", passportname=" + passportname + ", passportplace="
				+ passportplace + ", address1=" + address1 + ", address2=" + address2 + ", landmark=" + landmark
				+ ", country=" + country + ", mailingstate=" + mailingstate + ", mailingdistrict=" + mailingdistrict
				+ ", city=" + city + ", postalcode=" + postalcode + "]";
	}
}

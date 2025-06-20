package com.multi.step.form.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Diploma {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String userId;
	
	private String diploma;
	private String diplomadegree;
	private String diplomaduration;
	private String diplomastartdate;
	private String diplomaenddate;
	private String diplomaschool;
	private String diplomaboard;
	private String diplomabranch;
	private String diplomacgpa;
	private String diplomapercentage;
	private String diplomaschoolstate;
	private String diplomaschoolcity;
	private String diplomasemester1sgpa;
	private String diplomasemester1cgpa;
	private String diplomasemester1backlog;
	private String diplomasemester1percentage;
	private String diplomasemester2sgpa;
	private String diplomasemester2cgpa;
	private String diplomasemester2backlog;
	private String diplomasemester2percentage;
	private String diplomasemester3sgpa;
	private String diplomasemester3cgpa;
	private String diplomasemester3backlog;
	private String diplomasemester3percentage;
	private String diplomasemester4sgpa;
	private String diplomasemester4cgpa;
	private String diplomasemester4backlog;
	private String diplomasemester4percentage;
	private String diplomasemester5sgpa;
	private String diplomasemester5cgpa;
	private String diplomasemester5backlog;
	private String diplomasemester5percentage;
	private String diplomasemester6sgpa;
	private String diplomasemester6cgpa;
	private String diplomasemester6backlog;
	private String diplomasemester6percentage;
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
	public String getDiploma() {
		return diploma;
	}
	public void setDiploma(String diploma) {
		this.diploma = diploma;
	}
	public String getDiplomadegree() {
		return diplomadegree;
	}
	public void setDiplomadegree(String diplomadegree) {
		this.diplomadegree = diplomadegree;
	}
	public String getDiplomaduration() {
		return diplomaduration;
	}
	public void setDiplomaduration(String diplomaduration) {
		this.diplomaduration = diplomaduration;
	}
	public String getDiplomastartdate() {
		return diplomastartdate;
	}
	public void setDiplomastartdate(String diplomastartdate) {
		this.diplomastartdate = diplomastartdate;
	}
	public String getDiplomaenddate() {
		return diplomaenddate;
	}
	public void setDiplomaenddate(String diplomaenddate) {
		this.diplomaenddate = diplomaenddate;
	}
	public String getDiplomaschool() {
		return diplomaschool;
	}
	public void setDiplomaschool(String diplomaschool) {
		this.diplomaschool = diplomaschool;
	}
	public String getDiplomaboard() {
		return diplomaboard;
	}
	public void setDiplomaboard(String diplomaboard) {
		this.diplomaboard = diplomaboard;
	}
	public String getDiplomabranch() {
		return diplomabranch;
	}
	public void setDiplomabranch(String diplomabranch) {
		this.diplomabranch = diplomabranch;
	}
	public String getDiplomacgpa() {
		return diplomacgpa;
	}
	public void setDiplomacgpa(String diplomacgpa) {
		this.diplomacgpa = diplomacgpa;
	}
	public String getDiplomapercentage() {
		return diplomapercentage;
	}
	public void setDiplomapercentage(String diplomapercentage) {
		this.diplomapercentage = diplomapercentage;
	}
	public String getDiplomaschoolstate() {
		return diplomaschoolstate;
	}
	public void setDiplomaschoolstate(String diplomaschoolstate) {
		this.diplomaschoolstate = diplomaschoolstate;
	}
	public String getDiplomaschoolcity() {
		return diplomaschoolcity;
	}
	public void setDiplomaschoolcity(String diplomaschoolcity) {
		this.diplomaschoolcity = diplomaschoolcity;
	}
	public String getDiplomasemester1sgpa() {
		return diplomasemester1sgpa;
	}
	public void setDiplomasemester1sgpa(String diplomasemester1sgpa) {
		this.diplomasemester1sgpa = diplomasemester1sgpa;
	}
	public String getDiplomasemester1cgpa() {
		return diplomasemester1cgpa;
	}
	public void setDiplomasemester1cgpa(String diplomasemester1cgpa) {
		this.diplomasemester1cgpa = diplomasemester1cgpa;
	}
	public String getDiplomasemester1backlog() {
		return diplomasemester1backlog;
	}
	public void setDiplomasemester1backlog(String diplomasemester1backlog) {
		this.diplomasemester1backlog = diplomasemester1backlog;
	}
	public String getDiplomasemester1percentage() {
		return diplomasemester1percentage;
	}
	public void setDiplomasemester1percentage(String diplomasemester1percentage) {
		this.diplomasemester1percentage = diplomasemester1percentage;
	}
	public String getDiplomasemester2sgpa() {
		return diplomasemester2sgpa;
	}
	public void setDiplomasemester2sgpa(String diplomasemester2sgpa) {
		this.diplomasemester2sgpa = diplomasemester2sgpa;
	}
	public String getDiplomasemester2cgpa() {
		return diplomasemester2cgpa;
	}
	public void setDiplomasemester2cgpa(String diplomasemester2cgpa) {
		this.diplomasemester2cgpa = diplomasemester2cgpa;
	}
	public String getDiplomasemester2backlog() {
		return diplomasemester2backlog;
	}
	public void setDiplomasemester2backlog(String diplomasemester2backlog) {
		this.diplomasemester2backlog = diplomasemester2backlog;
	}
	public String getDiplomasemester2percentage() {
		return diplomasemester2percentage;
	}
	public void setDiplomasemester2percentage(String diplomasemester2percentage) {
		this.diplomasemester2percentage = diplomasemester2percentage;
	}
	public String getDiplomasemester3sgpa() {
		return diplomasemester3sgpa;
	}
	public void setDiplomasemester3sgpa(String diplomasemester3sgpa) {
		this.diplomasemester3sgpa = diplomasemester3sgpa;
	}
	public String getDiplomasemester3cgpa() {
		return diplomasemester3cgpa;
	}
	public void setDiplomasemester3cgpa(String diplomasemester3cgpa) {
		this.diplomasemester3cgpa = diplomasemester3cgpa;
	}
	public String getDiplomasemester3backlog() {
		return diplomasemester3backlog;
	}
	public void setDiplomasemester3backlog(String diplomasemester3backlog) {
		this.diplomasemester3backlog = diplomasemester3backlog;
	}
	public String getDiplomasemester3percentage() {
		return diplomasemester3percentage;
	}
	public void setDiplomasemester3percentage(String diplomasemester3percentage) {
		this.diplomasemester3percentage = diplomasemester3percentage;
	}
	public String getDiplomasemester4sgpa() {
		return diplomasemester4sgpa;
	}
	public void setDiplomasemester4sgpa(String diplomasemester4sgpa) {
		this.diplomasemester4sgpa = diplomasemester4sgpa;
	}
	public String getDiplomasemester4cgpa() {
		return diplomasemester4cgpa;
	}
	public void setDiplomasemester4cgpa(String diplomasemester4cgpa) {
		this.diplomasemester4cgpa = diplomasemester4cgpa;
	}
	public String getDiplomasemester4backlog() {
		return diplomasemester4backlog;
	}
	public void setDiplomasemester4backlog(String diplomasemester4backlog) {
		this.diplomasemester4backlog = diplomasemester4backlog;
	}
	public String getDiplomasemester4percentage() {
		return diplomasemester4percentage;
	}
	public void setDiplomasemester4percentage(String diplomasemester4percentage) {
		this.diplomasemester4percentage = diplomasemester4percentage;
	}
	public String getDiplomasemester5sgpa() {
		return diplomasemester5sgpa;
	}
	public void setDiplomasemester5sgpa(String diplomasemester5sgpa) {
		this.diplomasemester5sgpa = diplomasemester5sgpa;
	}
	public String getDiplomasemester5cgpa() {
		return diplomasemester5cgpa;
	}
	public void setDiplomasemester5cgpa(String diplomasemester5cgpa) {
		this.diplomasemester5cgpa = diplomasemester5cgpa;
	}
	public String getDiplomasemester5backlog() {
		return diplomasemester5backlog;
	}
	public void setDiplomasemester5backlog(String diplomasemester5backlog) {
		this.diplomasemester5backlog = diplomasemester5backlog;
	}
	public String getDiplomasemester5percentage() {
		return diplomasemester5percentage;
	}
	public void setDiplomasemester5percentage(String diplomasemester5percentage) {
		this.diplomasemester5percentage = diplomasemester5percentage;
	}
	public String getDiplomasemester6sgpa() {
		return diplomasemester6sgpa;
	}
	public void setDiplomasemester6sgpa(String diplomasemester6sgpa) {
		this.diplomasemester6sgpa = diplomasemester6sgpa;
	}
	public String getDiplomasemester6cgpa() {
		return diplomasemester6cgpa;
	}
	public void setDiplomasemester6cgpa(String diplomasemester6cgpa) {
		this.diplomasemester6cgpa = diplomasemester6cgpa;
	}
	public String getDiplomasemester6backlog() {
		return diplomasemester6backlog;
	}
	public void setDiplomasemester6backlog(String diplomasemester6backlog) {
		this.diplomasemester6backlog = diplomasemester6backlog;
	}
	public String getDiplomasemester6percentage() {
		return diplomasemester6percentage;
	}
	public void setDiplomasemester6percentage(String diplomasemester6percentage) {
		this.diplomasemester6percentage = diplomasemester6percentage;
	}
	public Diploma(int id, String userId, String diploma, String diplomadegree, String diplomaduration,
			String diplomastartdate, String diplomaenddate, String diplomaschool, String diplomaboard,
			String diplomabranch, String diplomacgpa, String diplomapercentage, String diplomaschoolstate,
			String diplomaschoolcity, String diplomasemester1sgpa, String diplomasemester1cgpa,
			String diplomasemester1backlog, String diplomasemester1percentage, String diplomasemester2sgpa,
			String diplomasemester2cgpa, String diplomasemester2backlog, String diplomasemester2percentage,
			String diplomasemester3sgpa, String diplomasemester3cgpa, String diplomasemester3backlog,
			String diplomasemester3percentage, String diplomasemester4sgpa, String diplomasemester4cgpa,
			String diplomasemester4backlog, String diplomasemester4percentage, String diplomasemester5sgpa,
			String diplomasemester5cgpa, String diplomasemester5backlog, String diplomasemester5percentage,
			String diplomasemester6sgpa, String diplomasemester6cgpa, String diplomasemester6backlog,
			String diplomasemester6percentage) {
		super();
		this.id = id;
		this.userId = userId;
		this.diploma = diploma;
		this.diplomadegree = diplomadegree;
		this.diplomaduration = diplomaduration;
		this.diplomastartdate = diplomastartdate;
		this.diplomaenddate = diplomaenddate;
		this.diplomaschool = diplomaschool;
		this.diplomaboard = diplomaboard;
		this.diplomabranch = diplomabranch;
		this.diplomacgpa = diplomacgpa;
		this.diplomapercentage = diplomapercentage;
		this.diplomaschoolstate = diplomaschoolstate;
		this.diplomaschoolcity = diplomaschoolcity;
		this.diplomasemester1sgpa = diplomasemester1sgpa;
		this.diplomasemester1cgpa = diplomasemester1cgpa;
		this.diplomasemester1backlog = diplomasemester1backlog;
		this.diplomasemester1percentage = diplomasemester1percentage;
		this.diplomasemester2sgpa = diplomasemester2sgpa;
		this.diplomasemester2cgpa = diplomasemester2cgpa;
		this.diplomasemester2backlog = diplomasemester2backlog;
		this.diplomasemester2percentage = diplomasemester2percentage;
		this.diplomasemester3sgpa = diplomasemester3sgpa;
		this.diplomasemester3cgpa = diplomasemester3cgpa;
		this.diplomasemester3backlog = diplomasemester3backlog;
		this.diplomasemester3percentage = diplomasemester3percentage;
		this.diplomasemester4sgpa = diplomasemester4sgpa;
		this.diplomasemester4cgpa = diplomasemester4cgpa;
		this.diplomasemester4backlog = diplomasemester4backlog;
		this.diplomasemester4percentage = diplomasemester4percentage;
		this.diplomasemester5sgpa = diplomasemester5sgpa;
		this.diplomasemester5cgpa = diplomasemester5cgpa;
		this.diplomasemester5backlog = diplomasemester5backlog;
		this.diplomasemester5percentage = diplomasemester5percentage;
		this.diplomasemester6sgpa = diplomasemester6sgpa;
		this.diplomasemester6cgpa = diplomasemester6cgpa;
		this.diplomasemester6backlog = diplomasemester6backlog;
		this.diplomasemester6percentage = diplomasemester6percentage;
	}
	public Diploma() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Diploma [id=" + id + ", userId=" + userId + ", diploma=" + diploma + ", diplomadegree=" + diplomadegree
				+ ", diplomaduration=" + diplomaduration + ", diplomastartdate=" + diplomastartdate
				+ ", diplomaenddate=" + diplomaenddate + ", diplomaschool=" + diplomaschool + ", diplomaboard="
				+ diplomaboard + ", diplomabranch=" + diplomabranch + ", diplomacgpa=" + diplomacgpa
				+ ", diplomapercentage=" + diplomapercentage + ", diplomaschoolstate=" + diplomaschoolstate
				+ ", diplomaschoolcity=" + diplomaschoolcity + ", diplomasemester1sgpa=" + diplomasemester1sgpa
				+ ", diplomasemester1cgpa=" + diplomasemester1cgpa + ", diplomasemester1backlog="
				+ diplomasemester1backlog + ", diplomasemester1percentage=" + diplomasemester1percentage
				+ ", diplomasemester2sgpa=" + diplomasemester2sgpa + ", diplomasemester2cgpa=" + diplomasemester2cgpa
				+ ", diplomasemester2backlog=" + diplomasemester2backlog + ", diplomasemester2percentage="
				+ diplomasemester2percentage + ", diplomasemester3sgpa=" + diplomasemester3sgpa
				+ ", diplomasemester3cgpa=" + diplomasemester3cgpa + ", diplomasemester3backlog="
				+ diplomasemester3backlog + ", diplomasemester3percentage=" + diplomasemester3percentage
				+ ", diplomasemester4sgpa=" + diplomasemester4sgpa + ", diplomasemester4cgpa=" + diplomasemester4cgpa
				+ ", diplomasemester4backlog=" + diplomasemester4backlog + ", diplomasemester4percentage="
				+ diplomasemester4percentage + ", diplomasemester5sgpa=" + diplomasemester5sgpa
				+ ", diplomasemester5cgpa=" + diplomasemester5cgpa + ", diplomasemester5backlog="
				+ diplomasemester5backlog + ", diplomasemester5percentage=" + diplomasemester5percentage
				+ ", diplomasemester6sgpa=" + diplomasemester6sgpa + ", diplomasemester6cgpa=" + diplomasemester6cgpa
				+ ", diplomasemester6backlog=" + diplomasemester6backlog + ", diplomasemester6percentage="
				+ diplomasemester6percentage + "]";
	}
}

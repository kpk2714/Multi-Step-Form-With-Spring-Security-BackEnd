package com.multi.step.form.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Graduation {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String userId;
	
	private String graduation;
	private String graduationdegree;
	private String graduationduration;
	private String graduationstartdate;
	private String graduationenddate;
	private String graduationschool;
	private String graduationboard;
	private String graduationbranch;
	private String graduationcgpa;
	private String graduationpercentage;
	private String graduationschoolstate;
	private String graduationschoolcity;
	private String graduationsemester1sgpa;
	private String graduationsemester1cgpa;
	private String graduationsemester1backlog;
	private String graduationsemester1percentage;
	private String graduationsemester2sgpa;
	private String graduationsemester2cgpa;
	private String graduationsemester2backlog;
	private String graduationsemester2percentage;
	private String graduationsemester3sgpa;
	private String graduationsemester3cgpa;
	private String graduationsemester3backlog;
	private String graduationsemester3percentage;
	private String graduationsemester4sgpa;
	private String graduationsemester4cgpa;
	private String graduationsemester4backlog;
	private String graduationsemester4percentage;
	private String graduationsemester5sgpa;
	private String graduationsemester5cgpa;
	private String graduationsemester5backlog;
	private String graduationsemester5percentage;
	private String graduationsemester6sgpa;
	private String graduationsemester6cgpa;
	private String graduationsemester6backlog;
	private String graduationsemester6percentage;
	private String graduationsemester7sgpa;
	private String graduationsemester7cgpa;
	private String graduationsemester7backlog;
	private String graduationsemester7percentage;
	private String graduationsemester8sgpa;
	private String graduationsemester8cgpa;
	private String graduationsemester8backlog;
	private String graduationsemester8percentage;
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
	public String getGraduation() {
		return graduation;
	}
	public void setGraduation(String graduation) {
		this.graduation = graduation;
	}
	public String getGraduationdegree() {
		return graduationdegree;
	}
	public void setGraduationdegree(String graduationdegree) {
		this.graduationdegree = graduationdegree;
	}
	public String getGraduationduration() {
		return graduationduration;
	}
	public void setGraduationduration(String graduationduration) {
		this.graduationduration = graduationduration;
	}
	public String getGraduationstartdate() {
		return graduationstartdate;
	}
	public void setGraduationstartdate(String graduationstartdate) {
		this.graduationstartdate = graduationstartdate;
	}
	public String getGraduationenddate() {
		return graduationenddate;
	}
	public void setGraduationenddate(String graduationenddate) {
		this.graduationenddate = graduationenddate;
	}
	public String getGraduationschool() {
		return graduationschool;
	}
	public void setGraduationschool(String graduationschool) {
		this.graduationschool = graduationschool;
	}
	public String getGraduationboard() {
		return graduationboard;
	}
	public void setGraduationboard(String graduationboard) {
		this.graduationboard = graduationboard;
	}
	public String getGraduationbranch() {
		return graduationbranch;
	}
	public void setGraduationbranch(String graduationbranch) {
		this.graduationbranch = graduationbranch;
	}
	public String getGraduationcgpa() {
		return graduationcgpa;
	}
	public void setGraduationcgpa(String graduationcgpa) {
		this.graduationcgpa = graduationcgpa;
	}
	public String getGraduationpercentage() {
		return graduationpercentage;
	}
	public void setGraduationpercentage(String graduationpercentage) {
		this.graduationpercentage = graduationpercentage;
	}
	public String getGraduationschoolstate() {
		return graduationschoolstate;
	}
	public void setGraduationschoolstate(String graduationschoolstate) {
		this.graduationschoolstate = graduationschoolstate;
	}
	public String getGraduationschoolcity() {
		return graduationschoolcity;
	}
	public void setGraduationschoolcity(String graduationschoolcity) {
		this.graduationschoolcity = graduationschoolcity;
	}
	public String getGraduationsemester1sgpa() {
		return graduationsemester1sgpa;
	}
	public void setGraduationsemester1sgpa(String graduationsemester1sgpa) {
		this.graduationsemester1sgpa = graduationsemester1sgpa;
	}
	public String getGraduationsemester1cgpa() {
		return graduationsemester1cgpa;
	}
	public void setGraduationsemester1cgpa(String graduationsemester1cgpa) {
		this.graduationsemester1cgpa = graduationsemester1cgpa;
	}
	public String getGraduationsemester1backlog() {
		return graduationsemester1backlog;
	}
	public void setGraduationsemester1backlog(String graduationsemester1backlog) {
		this.graduationsemester1backlog = graduationsemester1backlog;
	}
	public String getGraduationsemester1percentage() {
		return graduationsemester1percentage;
	}
	public void setGraduationsemester1percentage(String graduationsemester1percentage) {
		this.graduationsemester1percentage = graduationsemester1percentage;
	}
	public String getGraduationsemester2sgpa() {
		return graduationsemester2sgpa;
	}
	public void setGraduationsemester2sgpa(String graduationsemester2sgpa) {
		this.graduationsemester2sgpa = graduationsemester2sgpa;
	}
	public String getGraduationsemester2cgpa() {
		return graduationsemester2cgpa;
	}
	public void setGraduationsemester2cgpa(String graduationsemester2cgpa) {
		this.graduationsemester2cgpa = graduationsemester2cgpa;
	}
	public String getGraduationsemester2backlog() {
		return graduationsemester2backlog;
	}
	public void setGraduationsemester2backlog(String graduationsemester2backlog) {
		this.graduationsemester2backlog = graduationsemester2backlog;
	}
	public String getGraduationsemester2percentage() {
		return graduationsemester2percentage;
	}
	public void setGraduationsemester2percentage(String graduationsemester2percentage) {
		this.graduationsemester2percentage = graduationsemester2percentage;
	}
	public String getGraduationsemester3sgpa() {
		return graduationsemester3sgpa;
	}
	public void setGraduationsemester3sgpa(String graduationsemester3sgpa) {
		this.graduationsemester3sgpa = graduationsemester3sgpa;
	}
	public String getGraduationsemester3cgpa() {
		return graduationsemester3cgpa;
	}
	public void setGraduationsemester3cgpa(String graduationsemester3cgpa) {
		this.graduationsemester3cgpa = graduationsemester3cgpa;
	}
	public String getGraduationsemester3backlog() {
		return graduationsemester3backlog;
	}
	public void setGraduationsemester3backlog(String graduationsemester3backlog) {
		this.graduationsemester3backlog = graduationsemester3backlog;
	}
	public String getGraduationsemester3percentage() {
		return graduationsemester3percentage;
	}
	public void setGraduationsemester3percentage(String graduationsemester3percentage) {
		this.graduationsemester3percentage = graduationsemester3percentage;
	}
	public String getGraduationsemester4sgpa() {
		return graduationsemester4sgpa;
	}
	public void setGraduationsemester4sgpa(String graduationsemester4sgpa) {
		this.graduationsemester4sgpa = graduationsemester4sgpa;
	}
	public String getGraduationsemester4cgpa() {
		return graduationsemester4cgpa;
	}
	public void setGraduationsemester4cgpa(String graduationsemester4cgpa) {
		this.graduationsemester4cgpa = graduationsemester4cgpa;
	}
	public String getGraduationsemester4backlog() {
		return graduationsemester4backlog;
	}
	public void setGraduationsemester4backlog(String graduationsemester4backlog) {
		this.graduationsemester4backlog = graduationsemester4backlog;
	}
	public String getGraduationsemester4percentage() {
		return graduationsemester4percentage;
	}
	public void setGraduationsemester4percentage(String graduationsemester4percentage) {
		this.graduationsemester4percentage = graduationsemester4percentage;
	}
	public String getGraduationsemester5sgpa() {
		return graduationsemester5sgpa;
	}
	public void setGraduationsemester5sgpa(String graduationsemester5sgpa) {
		this.graduationsemester5sgpa = graduationsemester5sgpa;
	}
	public String getGraduationsemester5cgpa() {
		return graduationsemester5cgpa;
	}
	public void setGraduationsemester5cgpa(String graduationsemester5cgpa) {
		this.graduationsemester5cgpa = graduationsemester5cgpa;
	}
	public String getGraduationsemester5backlog() {
		return graduationsemester5backlog;
	}
	public void setGraduationsemester5backlog(String graduationsemester5backlog) {
		this.graduationsemester5backlog = graduationsemester5backlog;
	}
	public String getGraduationsemester5percentage() {
		return graduationsemester5percentage;
	}
	public void setGraduationsemester5percentage(String graduationsemester5percentage) {
		this.graduationsemester5percentage = graduationsemester5percentage;
	}
	public String getGraduationsemester6sgpa() {
		return graduationsemester6sgpa;
	}
	public void setGraduationsemester6sgpa(String graduationsemester6sgpa) {
		this.graduationsemester6sgpa = graduationsemester6sgpa;
	}
	public String getGraduationsemester6cgpa() {
		return graduationsemester6cgpa;
	}
	public void setGraduationsemester6cgpa(String graduationsemester6cgpa) {
		this.graduationsemester6cgpa = graduationsemester6cgpa;
	}
	public String getGraduationsemester6backlog() {
		return graduationsemester6backlog;
	}
	public void setGraduationsemester6backlog(String graduationsemester6backlog) {
		this.graduationsemester6backlog = graduationsemester6backlog;
	}
	public String getGraduationsemester6percentage() {
		return graduationsemester6percentage;
	}
	public void setGraduationsemester6percentage(String graduationsemester6percentage) {
		this.graduationsemester6percentage = graduationsemester6percentage;
	}
	public String getGraduationsemester7sgpa() {
		return graduationsemester7sgpa;
	}
	public void setGraduationsemester7sgpa(String graduationsemester7sgpa) {
		this.graduationsemester7sgpa = graduationsemester7sgpa;
	}
	public String getGraduationsemester7cgpa() {
		return graduationsemester7cgpa;
	}
	public void setGraduationsemester7cgpa(String graduationsemester7cgpa) {
		this.graduationsemester7cgpa = graduationsemester7cgpa;
	}
	public String getGraduationsemester7backlog() {
		return graduationsemester7backlog;
	}
	public void setGraduationsemester7backlog(String graduationsemester7backlog) {
		this.graduationsemester7backlog = graduationsemester7backlog;
	}
	public String getGraduationsemester7percentage() {
		return graduationsemester7percentage;
	}
	public void setGraduationsemester7percentage(String graduationsemester7percentage) {
		this.graduationsemester7percentage = graduationsemester7percentage;
	}
	public String getGraduationsemester8sgpa() {
		return graduationsemester8sgpa;
	}
	public void setGraduationsemester8sgpa(String graduationsemester8sgpa) {
		this.graduationsemester8sgpa = graduationsemester8sgpa;
	}
	public String getGraduationsemester8cgpa() {
		return graduationsemester8cgpa;
	}
	public void setGraduationsemester8cgpa(String graduationsemester8cgpa) {
		this.graduationsemester8cgpa = graduationsemester8cgpa;
	}
	public String getGraduationsemester8backlog() {
		return graduationsemester8backlog;
	}
	public void setGraduationsemester8backlog(String graduationsemester8backlog) {
		this.graduationsemester8backlog = graduationsemester8backlog;
	}
	public String getGraduationsemester8percentage() {
		return graduationsemester8percentage;
	}
	public void setGraduationsemester8percentage(String graduationsemester8percentage) {
		this.graduationsemester8percentage = graduationsemester8percentage;
	}
	public Graduation(int id, String userId, String graduation, String graduationdegree, String graduationduration,
			String graduationstartdate, String graduationenddate, String graduationschool, String graduationboard,
			String graduationbranch, String graduationcgpa, String graduationpercentage, String graduationschoolstate,
			String graduationschoolcity, String graduationsemester1sgpa, String graduationsemester1cgpa,
			String graduationsemester1backlog, String graduationsemester1percentage, String graduationsemester2sgpa,
			String graduationsemester2cgpa, String graduationsemester2backlog, String graduationsemester2percentage,
			String graduationsemester3sgpa, String graduationsemester3cgpa, String graduationsemester3backlog,
			String graduationsemester3percentage, String graduationsemester4sgpa, String graduationsemester4cgpa,
			String graduationsemester4backlog, String graduationsemester4percentage, String graduationsemester5sgpa,
			String graduationsemester5cgpa, String graduationsemester5backlog, String graduationsemester5percentage,
			String graduationsemester6sgpa, String graduationsemester6cgpa, String graduationsemester6backlog,
			String graduationsemester6percentage, String graduationsemester7sgpa, String graduationsemester7cgpa,
			String graduationsemester7backlog, String graduationsemester7percentage, String graduationsemester8sgpa,
			String graduationsemester8cgpa, String graduationsemester8backlog, String graduationsemester8percentage) {
		super();
		this.id = id;
		this.userId = userId;
		this.graduation = graduation;
		this.graduationdegree = graduationdegree;
		this.graduationduration = graduationduration;
		this.graduationstartdate = graduationstartdate;
		this.graduationenddate = graduationenddate;
		this.graduationschool = graduationschool;
		this.graduationboard = graduationboard;
		this.graduationbranch = graduationbranch;
		this.graduationcgpa = graduationcgpa;
		this.graduationpercentage = graduationpercentage;
		this.graduationschoolstate = graduationschoolstate;
		this.graduationschoolcity = graduationschoolcity;
		this.graduationsemester1sgpa = graduationsemester1sgpa;
		this.graduationsemester1cgpa = graduationsemester1cgpa;
		this.graduationsemester1backlog = graduationsemester1backlog;
		this.graduationsemester1percentage = graduationsemester1percentage;
		this.graduationsemester2sgpa = graduationsemester2sgpa;
		this.graduationsemester2cgpa = graduationsemester2cgpa;
		this.graduationsemester2backlog = graduationsemester2backlog;
		this.graduationsemester2percentage = graduationsemester2percentage;
		this.graduationsemester3sgpa = graduationsemester3sgpa;
		this.graduationsemester3cgpa = graduationsemester3cgpa;
		this.graduationsemester3backlog = graduationsemester3backlog;
		this.graduationsemester3percentage = graduationsemester3percentage;
		this.graduationsemester4sgpa = graduationsemester4sgpa;
		this.graduationsemester4cgpa = graduationsemester4cgpa;
		this.graduationsemester4backlog = graduationsemester4backlog;
		this.graduationsemester4percentage = graduationsemester4percentage;
		this.graduationsemester5sgpa = graduationsemester5sgpa;
		this.graduationsemester5cgpa = graduationsemester5cgpa;
		this.graduationsemester5backlog = graduationsemester5backlog;
		this.graduationsemester5percentage = graduationsemester5percentage;
		this.graduationsemester6sgpa = graduationsemester6sgpa;
		this.graduationsemester6cgpa = graduationsemester6cgpa;
		this.graduationsemester6backlog = graduationsemester6backlog;
		this.graduationsemester6percentage = graduationsemester6percentage;
		this.graduationsemester7sgpa = graduationsemester7sgpa;
		this.graduationsemester7cgpa = graduationsemester7cgpa;
		this.graduationsemester7backlog = graduationsemester7backlog;
		this.graduationsemester7percentage = graduationsemester7percentage;
		this.graduationsemester8sgpa = graduationsemester8sgpa;
		this.graduationsemester8cgpa = graduationsemester8cgpa;
		this.graduationsemester8backlog = graduationsemester8backlog;
		this.graduationsemester8percentage = graduationsemester8percentage;
	}
	public Graduation() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Graduation [id=" + id + ", userId=" + userId + ", graduation=" + graduation + ", graduationdegree="
				+ graduationdegree + ", graduationduration=" + graduationduration + ", graduationstartdate="
				+ graduationstartdate + ", graduationenddate=" + graduationenddate + ", graduationschool="
				+ graduationschool + ", graduationboard=" + graduationboard + ", graduationbranch=" + graduationbranch
				+ ", graduationcgpa=" + graduationcgpa + ", graduationpercentage=" + graduationpercentage
				+ ", graduationschoolstate=" + graduationschoolstate + ", graduationschoolcity=" + graduationschoolcity
				+ ", graduationsemester1sgpa=" + graduationsemester1sgpa + ", graduationsemester1cgpa="
				+ graduationsemester1cgpa + ", graduationsemester1backlog=" + graduationsemester1backlog
				+ ", graduationsemester1percentage=" + graduationsemester1percentage + ", graduationsemester2sgpa="
				+ graduationsemester2sgpa + ", graduationsemester2cgpa=" + graduationsemester2cgpa
				+ ", graduationsemester2backlog=" + graduationsemester2backlog + ", graduationsemester2percentage="
				+ graduationsemester2percentage + ", graduationsemester3sgpa=" + graduationsemester3sgpa
				+ ", graduationsemester3cgpa=" + graduationsemester3cgpa + ", graduationsemester3backlog="
				+ graduationsemester3backlog + ", graduationsemester3percentage=" + graduationsemester3percentage
				+ ", graduationsemester4sgpa=" + graduationsemester4sgpa + ", graduationsemester4cgpa="
				+ graduationsemester4cgpa + ", graduationsemester4backlog=" + graduationsemester4backlog
				+ ", graduationsemester4percentage=" + graduationsemester4percentage + ", graduationsemester5sgpa="
				+ graduationsemester5sgpa + ", graduationsemester5cgpa=" + graduationsemester5cgpa
				+ ", graduationsemester5backlog=" + graduationsemester5backlog + ", graduationsemester5percentage="
				+ graduationsemester5percentage + ", graduationsemester6sgpa=" + graduationsemester6sgpa
				+ ", graduationsemester6cgpa=" + graduationsemester6cgpa + ", graduationsemester6backlog="
				+ graduationsemester6backlog + ", graduationsemester6percentage=" + graduationsemester6percentage
				+ ", graduationsemester7sgpa=" + graduationsemester7sgpa + ", graduationsemester7cgpa="
				+ graduationsemester7cgpa + ", graduationsemester7backlog=" + graduationsemester7backlog
				+ ", graduationsemester7percentage=" + graduationsemester7percentage + ", graduationsemester8sgpa="
				+ graduationsemester8sgpa + ", graduationsemester8cgpa=" + graduationsemester8cgpa
				+ ", graduationsemester8backlog=" + graduationsemester8backlog + ", graduationsemester8percentage="
				+ graduationsemester8percentage + "]";
	}
}

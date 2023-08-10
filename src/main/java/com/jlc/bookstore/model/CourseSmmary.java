package com.jlc.bookstore.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

/**
 * @author subodh 
 * 
 * Reference https://www.baeldung.com/jackson-jsonmappingexception
 *
 */
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public class CourseSmmary {

	
	private int ID;
	

	private String courseName;
	

	private String duration;
	

	private String trainer;

	private double enrollments;

	public void setID(int iD) {
		ID = iD;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public void setTrainer(String trainer) {
		this.trainer = trainer;
	}

	public void setEnrollments(double enrollments) {
		this.enrollments = enrollments;
	}

	public CourseSmmary() {
		super();
		
	}

	public CourseSmmary(int iD, String courseName, String duration, String trainer, double enrollments) {
		super();
		ID = iD;
		this.courseName = courseName;
		this.duration = duration;
		this.trainer = trainer;
		this.enrollments = enrollments;
	}
	
	
	
}

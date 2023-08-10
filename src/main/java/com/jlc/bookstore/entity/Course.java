package com.jlc.bookstore.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Course {
	
	@Id
	@GeneratedValue
	private int ID;
	
	@Column
	private String courseName;
	
	@Column
	private String description;
	
	@Column
	private String trainingModel;
	
	@Column
	private double discount;
	
	@Column
	private double price;
	
	@Column
	private double offerPrice;
	
	@Column
	private String workingProfessional;
	
	@Column
	private String duration;
	
	@Column
	private String trainer;
	
	@Column
	private double enrollments;

	public int getID() {
		return ID;
	}

	public String getCourseName() {
		return courseName;
	}

	public String getDescription() {
		return description;
	}

	public String getTrainingModel() {
		return trainingModel;
	}

	public double getDiscount() {
		return discount;
	}

	public double getPrice() {
		return price;
	}

	public double getOfferPrice() {
		return offerPrice;
	}

	public String getWorkingProfessional() {
		return workingProfessional;
	}

	public String getDuration() {
		return duration;
	}

	public String getTrainer() {
		return trainer;
	}

	public double getEnrollments() {
		return enrollments;
	}

	@Override
	public String toString() {
		return "Course [ID=" + ID + ", courseName=" + courseName + ", description=" + description + ", trainingModel="
				+ trainingModel + ", discount=" + discount + ", price=" + price + ", offerPrice=" + offerPrice
				+ ", workingProfessional=" + workingProfessional + ", duration=" + duration + ", trainer=" + trainer
				+ ", enrollments=" + enrollments + "]";
	}

	public Course(String courseName, String description, String trainingModel, double discount, double price,
			double offerPrice, String workingProfessional, String duration, String trainer, double enrollments) {
		super();
		this.courseName = courseName;
		this.description = description;
		this.trainingModel = trainingModel;
		this.discount = discount;
		this.price = price;
		this.offerPrice = offerPrice;
		this.workingProfessional = workingProfessional;
		this.duration = duration;
		this.trainer = trainer;
		this.enrollments = enrollments;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ID;
		result = prime * result + ((courseName == null) ? 0 : courseName.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		long temp;
		temp = Double.doubleToLongBits(discount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((duration == null) ? 0 : duration.hashCode());
		temp = Double.doubleToLongBits(enrollments);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(offerPrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((trainer == null) ? 0 : trainer.hashCode());
		result = prime * result + ((trainingModel == null) ? 0 : trainingModel.hashCode());
		result = prime * result + ((workingProfessional == null) ? 0 : workingProfessional.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		if (ID != other.ID)
			return false;
		if (courseName == null) {
			if (other.courseName != null)
				return false;
		} else if (!courseName.equals(other.courseName))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (Double.doubleToLongBits(discount) != Double.doubleToLongBits(other.discount))
			return false;
		if (duration == null) {
			if (other.duration != null)
				return false;
		} else if (!duration.equals(other.duration))
			return false;
		if (Double.doubleToLongBits(enrollments) != Double.doubleToLongBits(other.enrollments))
			return false;
		if (Double.doubleToLongBits(offerPrice) != Double.doubleToLongBits(other.offerPrice))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (trainer == null) {
			if (other.trainer != null)
				return false;
		} else if (!trainer.equals(other.trainer))
			return false;
		if (trainingModel == null) {
			if (other.trainingModel != null)
				return false;
		} else if (!trainingModel.equals(other.trainingModel))
			return false;
		if (workingProfessional == null) {
			if (other.workingProfessional != null)
				return false;
		} else if (!workingProfessional.equals(other.workingProfessional))
			return false;
		return true;
	}

	public Course() {
		super();
		// TODO Auto-generated constructor stub
	} 
		
	

}

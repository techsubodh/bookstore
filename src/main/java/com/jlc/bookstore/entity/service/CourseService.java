package com.jlc.bookstore.entity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jlc.bookstore.entity.Course;
import com.jlc.bookstore.entity.repo.CourseRepository;

@Service
public class CourseService {
	
	
	private CourseRepository courseRepository;
	

	@Autowired
	public CourseService(CourseRepository courseRepository) {
		super();
		this.courseRepository = courseRepository;
	}


	public Course createCourse(String courseName, String description, String description2, double discount,
			String duration, double enrollments, double offerPrice, double price, String trainer, String trainingModel,
			String workingProfessional) {
			
		return this.courseRepository.save(
				new Course(courseName, description2, trainingModel, discount, 
						price, offerPrice, workingProfessional, duration, trainer, enrollments));
		
		
	}
	
	public long totalAvilableCourse() {
		return this.courseRepository.count();
	}
	

}

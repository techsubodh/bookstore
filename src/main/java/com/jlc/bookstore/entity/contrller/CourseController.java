package com.jlc.bookstore.entity.contrller;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jlc.bookstore.entity.Course;
import com.jlc.bookstore.entity.repo.CourseRepository;
import com.jlc.bookstore.model.CourseSmmary;

@RestController
@RequestMapping("/rest")
public class CourseController {

	private CourseRepository courseRepository;

	@Autowired
	public CourseController(CourseRepository courseRepository) {
		super();
		this.courseRepository = courseRepository;
	}
	
	
	public CourseController() {
		super();
		// TODO Auto-generated constructor stub
	}


	@GetMapping("/full-courses")
	public List<Course> getAllCourses(){
		
		List<Course> courses = new ArrayList<Course>();
		courseRepository.findAll().forEach(courses::add);;
		
		return courses;
	}
	
	@GetMapping("/mini-courses")
	public List<CourseSmmary> getMiniCourses(){
		
		List<Course> courses = new ArrayList<Course>();
		courseRepository.findAll().forEach(courses::add);;
		
		return getCourseSmmary(courses);
	}
	
	@GetMapping("/full-courses/{id}")
	public Course getAllCourses(@PathVariable int id){
		
		return courseRepository.findByID(id).get();
		
	}
	
	private List<CourseSmmary> getCourseSmmary(List<Course> courses){
		
		List<CourseSmmary> courseSummaryList =  new ArrayList<CourseSmmary>();
		
		for (Course course : courses) {
			
			courseSummaryList.add( new CourseSmmary(course.getID(), course.getCourseName(),course.getDuration(), course.getTrainer(), course.getEnrollments()));
			
		}
		
		return courseSummaryList;
		
	}
}

package com.jlc.bookstore.entity.repo;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.jlc.bookstore.entity.Course;

public interface CourseRepository extends CrudRepository<Course, Integer>{

	Iterable<Course> findAll();
	
	Optional<Course> findByID(int ID);
}
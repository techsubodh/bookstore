package com.jlc.bookstore;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static com.fasterxml.jackson.annotation.PropertyAccessor.FIELD;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jlc.bookstore.entity.service.CourseService;

@SpringBootApplication
public class BookstoreApplication implements CommandLineRunner{

	@Value("${JSONFIleName}")
	private String courseJSONFile;
	
	@Autowired
	private CourseService courseService;
	
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		createCourse(courseJSONFile);
	}

	private void createCourse(String courseJSONFile2) {
		 try {
			CourseFromFile.read(courseJSONFile2).forEach(importedCourse ->
			 courseService.createCourse(importedCourse.getCourseName(),
			 importedCourse.getDescription(),
			 importedCourse.getDescription(),
			 importedCourse.getDiscount(),
			 importedCourse.getDuration(),
			 importedCourse.getEnrollments(),
			 importedCourse.getOfferPrice(),
			 importedCourse.getPrice(),
			 importedCourse.getTrainer(),
			 importedCourse.getTrainingModel(),
			 importedCourse.getWorkingProfessional()));
			
			System.err.println("BookstoreApplication.createCourse()   Total Course availale:"+courseService.totalAvilableCourse());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	private static class CourseFromFile{
		
		
		private String courseName;
		
		
		private String description;
		
		
		private String trainingModel;
		
		
		private double discount;
		
		
		private double price;
		
		
		private double offerPrice;
		
		
		private String workingProfessional;
		
		
		private String duration;
		
		
		private String trainer;
		
		
		private double enrollments;
		
		
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


		//reader
        static List<CourseFromFile> read(String fileToImport) throws IOException {
            return new ObjectMapper().setVisibility(FIELD, ANY).
                    readValue(new FileInputStream(fileToImport), new TypeReference<List<CourseFromFile>>() {});
        }
	}
}

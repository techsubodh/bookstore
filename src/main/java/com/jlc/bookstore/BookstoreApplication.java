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
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jlc.bookstore.entity.service.BookService;
import com.jlc.bookstore.entity.service.CourseService;
import com.jlc.bookstore.model.BookDto;

@SpringBootApplication
public class BookstoreApplication implements CommandLineRunner{

	/**
	 * Read Properties value 
	 * @Value("${property_key_name}")
	 * @Value("${property_key_name:default_value}") - Setting default values
	 */
	@Value("${JSONFIleName}")
	private String courseJSONFile;
	
	@Autowired
	private CourseService courseService;
	
	@Autowired
	BookService bookService;
	
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	/**
	 *  This will enable CORS so that the configured rest method will have 'Access-Control-Allow-Origin' header present in the response
	 */
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				///registry.addMapping("/rest/*").allowedOrigins("http://localhost:4200/");
				registry.addMapping("/rest/*").allowedOrigins("*");
				registry.addMapping("/rest/full-courses/*").allowedOrigins("*");
				//registry.addMapping("/api/books/add").allowedOrigins("*");
				
			}
		};
	}

	@Override
	public void run(String... args) throws Exception {
		
		createCourse(courseJSONFile);
		createBooks();
	}

	/**
	 *  Adding an in-memory user, this will avoid 403
	 * @return
	 */
	@Bean
	public InMemoryUserDetailsManager userDetailsService() {
	    UserDetails user = User.withUsername("user")
	      .password(encoder().encode("userPass"))
	      .roles("USER")
	      .build();
	    return new InMemoryUserDetailsManager(user);
	}
	 
	@Bean
	public PasswordEncoder encoder() {
	    return new BCryptPasswordEncoder();
	}
	
	private void createBooks() {
		bookService.createBook(new BookDto("Word Power Made Easy", "Norman Lewis", 20.00, "English Learning", "Anchor Books"));
		bookService.createBook(new BookDto("Word Power Made Easy-2", "Norman Lewis", 30.00, "English Learning", "Anchor Books"));
		bookService.createBook(new BookDto("Word Power Made Easy-3", "Norman Lewis", 40.00, "English Learning", "Anchor Books"));
		
		System.err.println("BookstoreApplication.createBooks()  --Total Count:"+bookService.totalAvilableBooks());
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

# bookstore
Use this project for practicing any front-end application requiring REST API calls.

This project is implemented to showcase REST API using Spring DATA JPA entity and also Rest Controller. 


Run the Project using BookstoreApplication.java will generate the following JPA REST resources,

{
_links: {
courses: {
href: "http://localhost:8080/courses"
},
profile: {
href: "http://localhost:8080/profile"
}
}
}

This also contains REST API based on REST controller 
Get full course - http://localhost:8080/rest/full-courses
Get Mini Course - http://localhost:8080/rest/full-courses/1
Get Single Course - http://localhost:8080/rest/mini-courses


#ID Generator

- https://thorben-janssen.com/custom-sequence-based-idgenerator/#comment-96326
- https://github.com/hendisantika/spring-boot-custom-ID-sample/tree/main 

# Adding In Memory User 
- https://www.baeldung.com/java-spring-fix-403-error#:~:text=Causes%20of%20Error%20403&text=One%20of%20them%20is%20when,resulting%20in%20a%20403%20error.&text=Moreover%2C%20Spring%20Security%20enables%20Cross,(CSRF)%20protection%20by%20default. 

# Disable CORS
 By default CORS are enabled in spring and you have disable by extending new class
-SecurityConfig
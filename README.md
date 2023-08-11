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

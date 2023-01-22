# Reservation Hotel
  
  Base projects of Spring Boot and Angular 
  
| Characteristics | Description |
| --- | --- |
| SDK | 11.0.12 |
| Node | v17.4.0 |
| Angular CLI | 15.1.2 |
| Docker | 20.10.11 |


# How to run only the backend

 - go to the reservations folder, and execute in a terminal the following commands
 - docker build -t backend .
 - docker run --name backend -p 8080:8080 -t backend
 - wait until the terminal says Tomcat started on port(s): 8080 (http) with context path ''
 - execute a request from the postman collection
 
 # How to run backend and frontend
 - go to the root folder of this repository, and execute in a terminal the following commands
 - docker-compose up
 - open in your web browser this url http://localhost:4200
 
 # Note
 - If you have previously created the backend image, you will need to stop and delete the image, use these commands
   - docker rm $(docker ps -a -q)
   - or docker rmi backend
 

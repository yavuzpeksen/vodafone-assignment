
# Car Producer Web Service
This is a Spring Boot project designed for the assignment. It behaves as a simple Restful web service that accepts car production request coming from users. Only a few Spring related libraries and plugin are used.
The service processes certain types of car. These are Sedan, Cabrio and Hatchback. If inputs are different than these types, it ignores the request and replies back to the user with HTTP status 415 (unprocessable entity). If input is correct, it produces the car and responds with a successful status message.


## Prerequisite
1. Java JDK version 1.8 
2. Maven
3. Postman

To run internal tests;
- mvn test

To start the application;
- mvn spring-boot:run

## Endpoints

1. http://localhost:8080/cars

The web service is listening on one endpoint and it expects to receive HTTP POST messages with a media type plain/text.

### Inputs
- cabrio
- sedan

HTTP request samples are collected in `inputs.json` file under the root folder. Import the file in Postman before testing with the real inputs.

# RequestDrive Microservice

Spring Boot microservice for managing ride requests.

## Features
- Create ride requests
- Store pickup/dropoff locations
- Track request status

## Run locally
mvn spring-boot:run

## Run tests
mvn test

## Docker
docker build -t requestdrive .
docker run -p 8080:8080 requestdrive


[![Build Status](https://travis-ci.org/ahmdgawad/vts-parent.svg?branch=master)](https://travis-ci.org/ahmdgawad/vts-parent)
[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=ahmdgawad_vts-project&metric=coverage)](https://sonarcloud.io/dashboard?id=ahmdgawad_vts-project)
[![Lines of Code](https://sonarcloud.io/api/project_badges/measure?project=ahmdgawad_vts-project&metric=ncloc)](https://sonarcloud.io/dashboard?id=ahmdgawad_vts-project)

# **Vehicle Tracking System Microservice Project**

This is a sample project to show microservices architecture for a vehicle tracking system.

The project creates Docker containers.

It uses two restful microservices:
- Customer service: to view and manage customers.
- Vehicle Service: to view and manage vehicle related to customers.

Method	| Path	| Description
------------- | ------------------------- | ------------- |
GET	| /vehicles/all	| Get all vehicles data
GET	| /vehicles/{1}	| Get specific vehicle data
PUT	| /vehicles/{1}	| Save specific vehicle data
POST	| /vehicles/	| Create new vehicle

The 2 services communicate using kafka message broker over topics to notify vehicle service about created customers.

Solution Architecture
------------

<img width="880" alt="Functional services" src="https://raw.githubusercontent.com/ahmdgawad/Vehicle-Tracking-System-Configuration/master/Architecture.png">

Microservices
------------

#### Customer service

Method	| Path	| Description
------------- | ------------------------- | ------------- |
GET	| /customers/all	| Get all customers data
GET	| /customers/{1}	| Get specific customer data
PUT	| /customers/{1}	| Save specific customer data
POST	| /customers/	| Create new customer

#### Vehicle service

Method	| Path	| Description
------------- | ------------------------- | ------------- |
GET	| /vehicles/all	| Get all vehicles data
GET	| /vehicles/{1}	| Get specific vehicle data
PUT	| /vehicles/{1}	| Save specific vehicle data
POST	| /vehicles/	| Create new vehicle

Technologies
------------

- Java 1.8
- Spring Boot
- Spring Cloud
- Eureka Discovery
- Spring Config
- Zuul proxy
- Spring Data, Hibernate
- H2 Database
- Kafka for Communication between microservices
- Docker compose
- Swagger2 (UI for testing of APIs)

Endpoints
------------

- http://localhost:5555 - API Gateway
- http://localhost:8761 - Eureka
- http://localhost:9301/ui/ - User Interface

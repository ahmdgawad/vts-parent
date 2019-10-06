
[![Build Status](https://travis-ci.org/ahmdgawad/vts-parent.svg?branch=master)](https://travis-ci.org/ahmdgawad/vts-parent)
[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=ahmdgawad_vts-project&metric=coverage)](https://sonarcloud.io/dashboard?id=ahmdgawad_vts-project)
[![Lines of Code](https://sonarcloud.io/api/project_badges/measure?project=ahmdgawad_vts-project&metric=ncloc)](https://sonarcloud.io/dashboard?id=ahmdgawad_vts-project)

# **Vehicle Tracking System Microservice Project**

This is a sample project to show microservices architecture for a vehicle tracking system.

The project creates Docker containers.

It uses two microservices:
- Customer service to view and manage customers.
- Vehicle Service to view and manage vehicle related to customers.

The 2 services communicate using kafka message broker over topics to notify vehicle service about created customers.

Technologies
------------

- Spring Boot
- Kafka
- Zookeeper
- H2 Database
- Docker Compose

# Reactive Spring

This repository shows how to implement a Reactive application using Spring Boot and MongoDB.

The application will be built using [Spring Initializer](https://start.spring.io/) with the following dependencies:
- Spring Web Reactive
- Spring Data Reactive Mongo DB
- Embedded MongoDB database

In addition, is necessary to download a mongo image from [Docker Hub](https://hub.docker.com/).

To do this use the following command:

`> docker pull bitnami/mongodb`

Then, to run docker use:

`> docker run -p 27017:27017 --name mongodb bitnami/mongodb:latest`

Once the container is configured you can run it using:

`> docker run -p 27017:27017 bitnami/mongodb:latest`

For the project, unzip the file downloaded from **Spring Initializer** and open the folder in your IDE.
Go to _ReactiveSpringApplication.java_ and run it. 
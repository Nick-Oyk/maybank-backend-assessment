# Overview

This is a sample Springboot Web Application able to perform CRUD operations connected to MSSQL Database leveraging Data JPA and Hibernate.

## Build the image for DB

To run the database you just need to build the image (from root directory):

```
docker build -t mssql-db .
```

## Run container

Then, you need to run the container:

```
docker run -p 1433:1433 -d mssql-db
```

## [Swagger Client Access ](http://localhost:8080/swagger-ui/index.html)

```
Upon executing the web application, access the Swagger client using the link. Here, you can seamlessly explore and test the various endpoints available.
```

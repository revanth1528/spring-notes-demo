# Spring Boot Demo Application

Simple application to view, save, update and delete notes

## Requirements

1. Java - 1.8

2. Maven - 3+

## Steps to Setup

**1. Clone the application**

**2. Build and run the app using maven**

```bash
mvn clean install
java -jar target/spring-demo-1.0.0.jar
```

Alternatively, you can run the app without packaging it using -

```bash
mvn spring-boot:run
```

The app will start running at <http://localhost:8082>.

## API's defined

The app defines following CRUD APIs.

    GET /api/v1/notes
    
    POST /api/v1/notes
    
    GET /api/v1/notes/{noteId}
    
    PUT /api/v1/notes/{noteId}
    
    DELETE /api/v1/notes/{noteId}

You can test them by opening swagger at <http://localhost:8082/swagger-ui.html#/note-controller>.

Note : I am using H2 database in this application. H2 is in-memory database and is volatile, and data will be lost when
we restart the application.


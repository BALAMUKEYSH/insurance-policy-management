# Insurance Policy Management System

A RESTful backend application built using **Java 17, Spring Boot, Spring Data JPA, and MySQL** to manage insurance policies and perform premium estimations.

## Overview

The Insurance Policy Management System provides REST APIs to create, retrieve, update, and cancel insurance policies. It also includes a premium estimation feature based on policy details.

The application uses MySQL for persistent data storage and follows a layered architecture to separate API handling, business logic, and database operations.

## Tech Stack

- **Language:** Java 17
- **Framework:** Spring Boot 3.5.6
- **Build Tool:** Maven
- **Database:** MySQL 8
- **ORM:** Spring Data JPA / Hibernate
- **Validation:** Jakarta Bean Validation
- **Testing:** JUnit 5, Spring Boot Test
- **API Testing:** Postman
- **IDE:** IntelliJ IDEA

## Features

- Create a new insurance policy.
- Retrieve all insurance policies.
- Retrieve a policy using its ID.
- Update existing policy details.
- Cancel an active policy.
- Estimate insurance premiums.
- Validate incoming API requests.
- Handle application exceptions with appropriate HTTP responses.
- Persist policy data in MySQL.

## Project Structure

```text
insurance-policy-management/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/mukesh/insurance/
│   │   │       ├── controller/
│   │   │       ├── service/
│   │   │       ├── repository/
│   │   │       ├── entity/
│   │   │       ├── dto/
│   │   │       ├── exception/
│   │   │       └── InsuranceApplication.java
│   │   │
│   │   └── resources/
│   │       └── application.properties
│   │
│   └── test/
│       └── java/
│
├── pom.xml
└── README.md
```

## Prerequisites

Make sure the following are installed:

- Java JDK 17
- Maven
- MySQL Server 8.x
- IntelliJ IDEA or another Java IDE
- Postman (for API testing)

## Database Configuration

1. Start your MySQL server.
2. Create the database:

```sql
CREATE DATABASE insurance_db;
```

3. Configure the database connection in `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/insurance_db
spring.datasource.username=root
spring.datasource.password=${DB_PASSWORD}

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
```

Set the `DB_PASSWORD` environment variable to your local MySQL password before starting the application.

**Security:** Never commit your actual database password or other credentials to GitHub.

## Running the Application

Clone the repository:

```bash
git clone YOUR_GITHUB_REPOSITORY_URL
```

Navigate to the project directory:

```bash
cd insurance-policy-management
```

Build the application:

```bash
mvn clean install
```

Run the application:

```bash
mvn spring-boot:run
```

The application will start on:

`http://localhost:8080`

## REST API Endpoints

| HTTP Method | Endpoint | Description |
|---|---|---|
| POST | `/api/policies` | Create a policy |
| GET | `/api/policies` | Retrieve all policies |
| GET | `/api/policies/{id}` | Retrieve a policy by ID |
| PUT | `/api/policies/{id}` | Update a policy |
| PATCH | `/api/policies/{id}/cancel` | Cancel a policy |
| GET | `/api/policies/{id}/premium` | Estimate policy premium |

*The API base path and endpoint details should match the controller implementation.*

## Exception Handling

The application includes centralized exception handling using `GlobalExceptionHandler`.

- Returns appropriate HTTP status codes.
- Handles policy-not-found scenarios.
- Provides structured error responses.

## Testing

The project includes unit testing using JUnit 5.

Run the test suite:

```bash
mvn test
```

API endpoints can also be tested using Postman.

## Future Enhancements

- JWT-based authentication and authorization.
- Swagger/OpenAPI documentation.
- Docker containerization.
- Advanced policy search and filtering.
- CI/CD pipeline integration.

## Author

**Mukesh**

Java | Spring Boot | REST APIs | MySQL | Spring Data JPA

---

*This project is developed as a learning and portfolio project to demonstrate backend development, REST API design, database integration, and Java application development.*

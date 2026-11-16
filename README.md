# Insurance Policy Management System

A personal portfolio project built with Java 17 and Spring Boot. It exposes REST APIs to create, view, update, and cancel insurance policies, with basic validation and premium calculation.

> This is an educational portfolio project. It is not production-ready insurance software and is not affiliated with any employer or insurance company.

## Technology
- Java 17
- Spring Boot 3.5
- Spring Web
- Spring Data JPA
- Bean Validation
- H2 in-memory database
- Maven
- JUnit 5 / Spring Boot Test

## Features
- Create an insurance policy
- List all policies and retrieve one by ID
- Update policyholder and coverage details
- Cancel a policy
- Calculate an illustrative annual premium
- Validate incoming request fields
- Persist data in an H2 database while the application is running

## Run locally
Prerequisites: JDK 17+ and Maven 3.9+.

```bash
mvn spring-boot:run
```

The API starts at `http://localhost:8080`.

H2 console: `http://localhost:8080/h2-console`
- JDBC URL: `jdbc:h2:mem:insurancedb`
- Username: `sa`
- Password: (leave blank)

The H2 database is in-memory; data is reset when the application stops.

## API examples

### Create a policy
`POST /api/policies`

```json
{
  "policyholderName": "Arun Kumar",
  "email": "arun@example.com",
  "policyType": "HEALTH",
  "coverageAmount": 500000,
  "termYears": 1
}
```

### List policies
`GET /api/policies`

### Get one policy
`GET /api/policies/{id}`

### Update a policy
`PUT /api/policies/{id}`

Use the same JSON shape as create.

### Cancel a policy
`PATCH /api/policies/{id}/cancel`

### Calculate an estimated premium
`GET /api/policies/premium-estimate?policyType=HEALTH&coverageAmount=500000&termYears=1`

The premium formula is intentionally simplified for demonstration and must not be used for real insurance pricing.

## Example premium assumptions
- LIFE: 0.8% of coverage per year
- HEALTH: 1.2%
- VEHICLE: 2.0%
- HOME: 0.5%

The estimated premium is: `coverageAmount × rate × termYears`.

## Project structure

```text
src/main/java/com/mukesh/insurance/
  InsurancePolicyApplication.java
  controller/PolicyController.java
  dto/PolicyRequest.java
  dto/PremiumEstimate.java
  entity/InsurancePolicy.java
  entity/PolicyStatus.java
  entity/PolicyType.java
  exception/GlobalExceptionHandler.java
  exception/PolicyNotFoundException.java
  repository/PolicyRepository.java
  service/PremiumCalculator.java
  service/PolicyService.java
src/main/resources/application.properties
src/test/java/com/mukesh/insurance/service/PremiumCalculatorTest.java
```

## Important before publishing
- This repository should contain only code you understand and have reviewed.
- Do not add employer/client source code, credentials, customer data, internal documents, or proprietary business rules.
- Replace this README's example details with your own after testing the application.
- Add meaningful features and tests over time; do not claim professional or production experience based only on this sample.

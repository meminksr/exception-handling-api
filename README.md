# 🛡️ Spring Boot Global Exception Handling API

A best-practice boilerplate project demonstrating how to handle errors centrally and professionally in Spring Boot applications using `@RestControllerAdvice`.

## 📖 About the Project

This project is a boilerplate architecture designed to manage exceptions from a centralized location in Spring Boot applications.

**Why is it necessary?**
Normally, when an error occurs, Spring Boot returns complex pages that are difficult for Frontend developers to understand (such as the Whitelabel Error Page or long Stack Trace logs). This project intercepts errors on the fly, no matter where they occur in the application, and always delivers a **standard, clean, and predictable JSON** format to the Frontend (React, Angular, Mobile, etc.).

## 🚀 Features

- **Centralized Shield (`@RestControllerAdvice`):** Throw away all those `try-catch` blocks! All errors are managed from a single center.
- **Standard Response Format (DTO):** The same JSON structure (`timestamp`, `status`, `message`, `path`) is returned for every error case.
- **Data Validation Management:** When a user enters missing or invalid form data (`@NotBlank`, `@Email`), it catches these errors, lists them, and presents them elegantly in a single JSON (HTTP 400 - Bad Request).
- **Custom Exceptions:** A custom `ResourceNotFoundException` is thrown and handled when data is not found in the database (HTTP 404 - Not Found).
- **Framework Errors:** Intercepts structural errors such as unexpected HTTP methods (e.g., sending a GET request when a POST is expected - HTTP 405).

## 🏗️ Architecture Diagram

```mermaid
sequenceDiagram
    participant Client as Client (Postman/Browser)
    participant Ctrl as UserController
    participant Svc as UserService
    participant GEH as GlobalExceptionHandler

    Client->>Ctrl: Sends Request (GET/POST)
    Ctrl->>Svc: Processes Data
    Svc-->>Ctrl: THROWS EXCEPTION! (e.g., ResourceNotFoundException)
    Ctrl-->>GEH: (Exception bubbles up to Global Handler)
    GEH->>GEH: Populates ErrorResponse DTO (404, Timestamp, Message)
    GEH-->>Client: Returns Clean JSON Response
```

## 🧪 How to Test? (Postman)

After starting the project, you can test the following scenarios:

### 1. Successful Request (HTTP 200)
- **Method:** `GET`
- **URL:** `http://localhost:8080/api/users/5`
- **Expected Result:** Success message string.

### 2. Not Found Error (HTTP 404)
- **Method:** `GET`
- **URL:** `http://localhost:8080/api/users/99`
- **Expected Result (JSON):**
```json
{
    "timestamp": "2026-08-01T12:45:00.123",
    "status": 404,
    "message": "User not found in DB! Requested ID: 99",
    "path": "/api/users/99"
}
```

### 3. Validation Error (HTTP 400)
- **Method:** `POST`
- **URL:** `http://localhost:8080/api/users`
- **Body (JSON):**
```json
{
    "name": "",
    "email": "invalid-email-address",
    "password": "123"
}
```
- **Expected Result (JSON):** A detailed list of validation errors for each invalid field.

### 4. Method Not Allowed Error (HTTP 405)
- **Method:** `GET` *(To an endpoint that only expects POST)*
- **URL:** `http://localhost:8080/api/users`
- **Expected Result (JSON):** JSON response indicating the unsupported HTTP method.

## 🛠️ Technologies
- Java 
- Spring Boot (Web, Validation)
- Lombok
- Maven

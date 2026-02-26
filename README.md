# URL Shortener

A simple URL Shortener built with Spring Boot using Clean Architecture principles.

## Overview

This application allows you to:

- Shorten a long URL into a unique short code
- Resolve a short code back to the original URL

The project is structured using a layered / hexagonal architecture approach:


## Architecture

The application follows a Clean Architecture pattern:


### Layers

- **web**  
  REST controllers and request/response DTOs.

- **app**
  - `port.in` → Inbound interfaces (e.g. ShortenUrlPort, ResolveUrlPort)
  - `port.out` → Outbound interfaces (e.g. UrlRepositoryPort)
  - Use cases implementing business logic.

- **domain**  
  Core domain objects (e.g. `UrlMapping`).

- **infra**  
  Repository implementations (currently in-memory).


##  How It Works

### 1. Shorten URL

**POST** `/urls/shorten`

Request:
```json
{
  "url": "https://example.com"
}
```
Response:
```json
{
  "originalUrl": "https://example.com",
  "shortCode": "abc123"
}
```


---

### **Part 4 – Tech Stack & Running**

```markdown
## 📦 Tech Stack

- Java 21
- Spring Boot
- Springdoc OpenAPI (Swagger)
- Maven

## 🧪 Running the Application

### Run with Maven:

```bash
mvn spring-boot:run
```


  
---

### **Part 5 – Code Formatting & Future Improvements**

```markdown
## 🎨 Code Formatting

### Recommended Style

- Use constructor injection (no field injection)
- Keep controllers thin
- Business logic belongs in use cases
- Repositories only handle data access
- Use `record` for DTOs when possible

### Format Code

If using IntelliJ:

- Mac: `Cmd + Option + L`  
- Windows/Linux: `Ctrl + Alt + L`

Or use Maven formatter plugins if configured.

## 📌 Future Improvements

- Persist data using a database (e.g., PostgreSQL)
- Add redirect endpoint (HTTP 302 instead of JSON response)
- Add click tracking
- Add validation & proper exception handling
- Add unit and integration tests
```

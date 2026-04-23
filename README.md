Spendly 💰 — Backend

Spendly is a backend system for a personal finance management platform under development, designed with a focus on security, data integrity, and scalable architecture.

Spendly is designed as a real-world, user-centric financial product, focusing on expense tracking, financial organization, and practical use cases.

🚧 Project Status: Active development

🎯 Overview

This project aims to design and implement a backend system aligned with real-world application needs, focusing on:

Secure authentication and data protection
Consistent domain modeling and business rules
Scalable and maintainable architecture
Clear separation of concerns and clean code practices
🚀 Tech Stack
Java 17+
Spring Boot (Web, Data JPA, Security, Validation)
Spring Security
JPA / Hibernate
PostgreSQL
Maven
Lombok
Bean Validation
JWT (JSON Web Token)
Docker
Docker Compose
🧱 Current Stage

Backend fully functional with authentication flow implemented and environment containerized using Docker.

The system is now reproducible and runs with isolated services (application + database), simulating a real-world backend environment.

🧠 Domain Direction

The project is positioned as Spendly, a personal finance management system, to:

Focus on a more realistic and widely applicable use case
Improve product-market alignment
Enable future features such as expense tracking, categorization, and financial insights
Maintain the technical robustness while shifting to a more practical domain
✅ Progress
Phase 1 — Domain Modeling (Completed)
Entity	Description
Customer	User of the platform with CPF, email and status
Wallet	Financial wallet representation
Transaction	Financial movements (expenses/income/transfers)
PaymentKey	Payment keys (CPF, email, phone, random)
LoginAudit	Login attempts tracking

Applied concepts:

JPA relationships (@OneToMany, @ManyToOne)
Bean Validation (@NotNull, @Email, @Size)
Strategic indexing (CPF, email)
Enums with @Enumerated(EnumType.STRING)
Domain encapsulation with business methods (block(), activate())
Phase 2 — Backend Core (Completed)
JPA repositories for domain entities
Service layer with dependency injection
DTO pattern (Request / Response separation)
Password hashing with BCrypt
Business validation (CPF uniqueness)
Global exception handling (@RestControllerAdvice)
Structured validation errors (field-level feedback)
🔐 Security & Authentication (Implemented)

Stateless authentication using JWT:

Spring Security configured with SecurityFilterChain
Stateless session management (SessionCreationPolicy.STATELESS)
Custom JWT authentication filter (JwtAuthenticationFilter)
Custom authentication entry point (401 handler)
Custom access denied handler (403 handler)
Password encryption using BCryptPasswordEncoder
🌐 Infrastructure (Dockerized)

The backend environment is fully containerized:

Dockerfile for application packaging
Docker Compose orchestrating backend and PostgreSQL
Environment variables externalized via .env
Isolated network between services

The application can be executed with a single command:

docker compose up

This ensures environment consistency and reproducibility across different machines.

🧠 Authentication Flow

Complete authentication flow implemented:

POST /auth/login → validates credentials and returns JWT
JWT includes subject (CPF) and user claims
Frontend sends token via Authorization header
JWT filter validates token on every request
Spring Security authenticates user via SecurityContext
🌐 API Overview
Create Customer

POST /customers

Request Body:

{
  "name": "Paulo Emilio",
  "cpf": "12345678901",
  "password": "123456",
  "email": "paulo@email.com"
}

Features:

CPF uniqueness validation
Secure password hashing (BCrypt)
DTO-based response
Structured validation error handling
Login

POST /auth/login

Request Body:

{
  "cpf": "12345678901",
  "password": "123456"
}

Response:

{
  "token": "eyJhbGciOiJIUzI1NiJ9...",
  "type": "Bearer"
}
Get Current User

GET /customers/me

Headers:

Authorization: Bearer <JWT_TOKEN>

Response:

{
  "id": 1,
  "name": "Paulo Emilio",
  "email": "paulo@email.com"
}
🧪 Running the Application
Using Docker (Recommended)
# Clone the repository
git clone https://github.com/paulojrtoledo/spendly-backend.git

# Navigate to the project folder
cd spendly-backend

# Create .env file with:
# JWT_SECRET
# DB_SPENDLY_URL
# DB_SPENDLY_USERNAME
# DB_SPENDLY_PASSWORD

# Run the application
docker compose up
Running Locally (without Docker)
./mvnw spring-boot:run
🔗 Related Repository

Frontend:
https://github.com/paulojrtoledo/spendly-frontend

👤 Author

Paulo Emilio de Toledo Jr

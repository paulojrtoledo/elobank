Elo Bank 💳 — Backend

Elo Bank is a backend system for a digital banking platform under development, designed with a focus on security, data integrity, and scalable architecture.

The project implements core banking concepts such as customer management, account structures, transaction modeling, and secure JWT-based authentication.

🚧 Project Status: Active development

🎯 Overview

This project aims to design and implement a backend system aligned with real-world banking requirements, focusing on:

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

🧱 Current Stage

Backend core and complete authentication flow with JWT implemented, including protected endpoints and stateless security configuration.

✅ Progress
Phase 1 — Domain Modeling (Completed)
Entity	Description
Customer	Bank customer (individual) with CPF, email, status
Account	Bank account (checking/savings)
Transaction	Financial transactions (PIX, TED, debit)
PixKey	Pix keys (CPF, email, phone, random)
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

Public Endpoints

POST /customers (registration)
POST /auth/login (authentication)
OPTIONS /** (CORS preflight)

Protected Endpoints

All other endpoints require a valid JWT token.

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

"12345678901"
🧪 Running Locally
# Clone the repository
git clone https://github.com/paulojrtoledo/elobank-backend.git

# Navigate to the project folder
cd elobank-backend

# Configure environment variables (PostgreSQL)
# DB_EB_URL
# DB_EB_USERNAME
# DB_EB_PASSWORD

# JWT configuration (for authentication)
# security.jwt.secret
# security.jwt.expiration-in-minutes

# Run the application
./mvnw spring-boot:run
🔗 Related Repository

Frontend: elobank-frontend
https://github.com/paulojrtoledo/elobank-frontend

👤 Author

Paulo Emilio de Toledo Jr

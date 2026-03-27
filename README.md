Elo Bank 💳 — Backend

Elo Bank is a backend system for a digital banking platform under development, designed with a focus on security, data integrity, and scalable architecture.

The project implements core banking concepts such as customer management, account structures, transaction modeling, and secure authentication mechanisms.

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
🧱 Current Stage

Core backend structure with domain modeling and initial API endpoints implemented.

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
Phase 2 — Backend Core (In Progress)
JPA repositories for domain entities
Service layer with dependency injection
DTO pattern (Request / Response separation)
Password hashing with BCrypt
Business validation (CPF uniqueness)
Global exception handling (@RestControllerAdvice)
Structured validation errors (field-level feedback)
Initial REST endpoint for customer registration
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
🧪 Running Locally
# Clone the repository
git clone https://github.com/paulojrtoledo/elobank-backend.git

# Navigate to the project folder
cd elobank-backend

# Configure environment variables (PostgreSQL)
# DB_EB_URL
# DB_EB_USERNAME
# DB_EB_PASSWORD

# Run the application
./mvnw spring-boot:run
🔗 Related Repository
Frontend: elobank-frontend

👤 Author
Paulo Emilio de Toledo Jr

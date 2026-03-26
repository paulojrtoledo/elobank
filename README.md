Elo Bank 💳 — Backend

Elo Bank is a digital banking platform under development, built with focus on security, scalability and best practices. The project simulates a real bank, allowing account opening, transfers (PIX/TED), Pix key management and secure authentication.

🚧 Project Status: Active development

🎯 Project Goal

Build a full stack application from scratch that demonstrates:

Mastery of Java, Spring Boot and ecosystem
Practical application of cybersecurity in a critical domain
Clean architecture, layered architecture and best practices
Ability to build a full stack application
🚀 Tech Stack
Java 17+
Spring Boot (Web, Data JPA, Security, Validation)
JPA / Hibernate with PostgreSQL
Spring Security
Maven
Lombok
Bean Validation
✅ Progress
Phase 1 — Domain Modeling (Completed)
Entity	Description
Customer	Bank customer (individual) with CPF, email, status
Account	Bank account (checking/savings)
Transaction	PIX, TED and debit transfers
PixKey	Pix keys (CPF, email, phone, random)
LoginAudit	Login attempts audit

Applied concepts:

✅ JPA relationships (@OneToMany, @ManyToOne)
✅ Bean Validation (@NotNull, @Email, @Size)
✅ Strategic indexes (cpf, email)
✅ Enums with @Enumerated(EnumType.STRING)
✅ Encapsulation with business methods (block(), activate())
Phase 2 — Backend Core (In progress)
✅ JPA Repositories for all domain entities
✅ Service layer with dependency injection
✅ DTO pattern (Request / Response separation)
✅ Password hashing with BCrypt
✅ Business validation (CPF uniqueness)
✅ Global exception handling (@RestControllerAdvice)
✅ Structured validation errors (field-level feedback)
✅ REST Controller for customer registration (POST /customers)
✅ Application running with embedded Tomcat (Spring Web)
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
Password hashing (BCrypt)
DTO-based response
Structured validation error handling
📦 How to run locally
# Clone the repository
git clone https://github.com/paulojrtoledo/elobank-backend.git

# Access the folder
cd elobank-backend

# Configure environment variables (PostgreSQL)
# DB_EB_URL, DB_EB_USERNAME, DB_EB_PASSWORD

# Run with Maven
./mvnw spring-boot:run
🔗 Related Repository

Frontend: elobank-frontend

📌 Author

Paulo Emilio de Toledo Jr
LinkedIn
 | GitHub

📝 License

This project is developed for study and portfolio purposes.

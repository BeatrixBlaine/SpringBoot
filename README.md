# Spring Boot

A collection of **Java backend projects and hands-on exercises** developed while learning and practicing Spring Boot.

This repository documents my progress with Spring Boot and backend development, covering everything from Spring MVC and Thymeleaf to REST APIs, JPA/Hibernate, Spring Data JPA, MySQL, and Spring Security.

## 🚀 Topics Covered

* Spring Boot fundamentals
* Spring MVC
* Thymeleaf
* Form handling
* Data binding
* Bean Validation
* REST APIs
* CRUD operations
* Spring Data JPA
* Hibernate / JPA
* Entity relationships
* MySQL
* Spring Security
* Authentication and authorization
* JDBC authentication
* Maven
* Application configuration
* Dependency injection
* Exception handling

## 🛠️ Technologies

| Technology         | Purpose                          |
| ------------------ | -------------------------------- |
| Java               | Programming language             |
| Spring Boot        | Backend framework                |
| Spring MVC         | Web application development      |
| Thymeleaf          | Server-side HTML rendering       |
| Spring Data JPA    | Database access                  |
| Hibernate          | ORM                              |
| MySQL              | Relational database              |
| Spring Security    | Authentication and authorization |
| Jakarta Validation | Input validation                 |
| Maven              | Build and dependency management  |

## 📂 Project Structure

This repository contains multiple exercises and applications developed throughout my Spring Boot learning process.

The projects cover different areas of backend development rather than representing a single production application.

```text
SpringBoot/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   └── resources/
│   │
│   └── test/
│
├── .mvn/
├── mvnw
├── mvnw.cmd
└── pom.xml
```

## 📚 What I Have Practiced

### Spring MVC

Hands-on practice with:

* Controllers
* Request mappings
* `@RequestParam`
* `@PathVariable`
* `@ModelAttribute`
* Model attributes
* Thymeleaf templates
* Form processing
* Redirects
* Validation errors

Example MVC flow:

```text
Browser
   ↓
Controller
   ↓
Service
   ↓
Database
   ↓
Model
   ↓
Thymeleaf
   ↓
HTML Response
```

### REST APIs

Practice building RESTful endpoints using:

* `@RestController`
* `@GetMapping`
* `@PostMapping`
* `@PutMapping`
* `@PatchMapping`
* `@DeleteMapping`
* `@RequestBody`
* `@PathVariable`
* HTTP status codes
* JSON request and response bodies

Typical REST architecture:

```text
Client
  ↓
REST Controller
  ↓
Service
  ↓
Repository
  ↓
Database
```

### JPA & Hibernate

Database persistence practice using:

* `@Entity`
* `@Table`
* `@Id`
* `@GeneratedValue`
* `@OneToMany`
* `@ManyToOne`
* `@JoinColumn`
* JPQL
* EntityManager
* Transactions
* Hibernate ORM

### Spring Data JPA

Practice with:

* `JpaRepository`
* CRUD operations
* Derived query methods
* Custom queries
* Sorting
* Finding entities by fields
* Repository-based data access

### Validation

Practice with Jakarta Bean Validation, including:

```java
@NotBlank
@NotNull
@Email
@Size
@Pattern
@Valid
```

Validation is used to prevent invalid input from reaching the application's business logic.

### Spring Security

Practice with:

* Form login
* Authentication
* Authorization
* Roles and authorities
* Custom login pages
* Login processing
* Logout
* JDBC authentication
* Password encoding
* Protected endpoints
* Role-based access control

Example:

```text
User
 ↓
Login
 ↓
Spring Security
 ↓
Authentication
 ↓
Authorization
 ↓
Protected Resource
```

### MySQL

Practice connecting Spring Boot applications to MySQL and working with relational data through JPA and Hibernate.

## 🏗️ Common Architecture

The projects in this repository follow layered backend architecture:

```text
Controller
    ↓
Service
    ↓
Repository
    ↓
JPA / Hibernate
    ↓
MySQL
```

Each layer has a specific responsibility:

**Controller**
Handles HTTP requests and responses.

**Service**
Contains business/application logic.

**Repository**
Handles database operations.

**Entity**
Represents persistent database data.

**DTO**
Separates API request/response data from entities when appropriate.

## 🎯 Learning Goals

This repository is part of my ongoing development as a **Java backend developer**.

The main goals are to build a strong understanding of:

* Java
* Spring Boot
* Backend architecture
* REST API development
* Database design
* JPA/Hibernate
* Authentication and authorization
* Clean separation of responsibilities
* Building complete backend applications

## 📈 Learning Progression

The projects in this repository represent a progression from basic Spring concepts toward more complete backend applications.

```text
Java
  ↓
Spring Boot
  ↓
Spring MVC
  ↓
Thymeleaf
  ↓
JPA / Hibernate
  ↓
Spring Data JPA
  ↓
REST APIs
  ↓
Validation
  ↓
Spring Security
  ↓
Authentication & Authorization
  ↓
Larger Backend Applications
```

## 🔮 Future Learning

Planned areas of exploration include:

* Automated testing
* JWT authentication
* Advanced REST API design
* Global exception handling
* DTO mapping
* API documentation
* Microservices
* Spring Cloud
* Docker
* Kafka
* Kubernetes
* Cloud deployment

## 👤 Author

**Beatrix Blaine**

GitHub:
https://github.com/BeatrixBlaine

---

This repository represents my hands-on journey learning **Java and Spring Boot backend development**.

# 🚀 Complaint Portal (Spring Boot Project)

A full-stack Complaint / Grievance Portal built using:

- ☕ Java
- 🌱 Spring Boot
- 🗄 Spring Data JPA
- 💾 H2 Database
- 🎨 Thymeleaf (HTML + CSS)
- 🛠 Maven
- 🧱 MVC Architecture

---

# 📌 Project Overview

This project is a beginner-to-intermediate level backend application designed to:

- Allow users to register
- Store user data in database
- Follow proper MVC architecture
- Use real backend logic
- Maintain professional Git structure

This project is built in a structured **5-Day Development Plan**.

---

# 🏗 Tech Stack Used

| Technology | Purpose |
|------------|----------|
| Spring Boot | Backend Framework |
| Spring Web | HTTP Handling |
| Spring Data JPA | ORM & Database Operations |
| Hibernate | JPA Implementation |
| H2 Database | In-memory database |
| Thymeleaf | Template Engine |
| Maven | Dependency & Build Management |
| Git | Version Control |

---

# 🧠 Architecture Used

MVC Pattern:

- **Model** → Entity classes (User)
- **View** → Thymeleaf HTML pages
- **Controller** → Handles HTTP requests
- **Service Layer** → Business logic
- **Repository Layer** → Database communication

Flow:

```
Browser → Controller → Service → Repository → Database
```

---

# 📅 5-Day Development Plan

---

# ✅ Day 1 – Project Setup + Landing Page

### Completed:
- Spring Boot project setup
- Maven configuration
- H2 database setup
- Folder structure creation
- HomeController created
- Professional animated landing page UI
- Clean Git setup
- .gitignore configuration

---

# ✅ Day 2 – User Registration Backend

### Completed:
- User Entity (`@Entity`)
- UserRepository (`JpaRepository`)
- UserService (Business layer)
- Registration form UI
- POST mapping for user registration
- Data persistence to H2
- Verified using H2 Console
- MVC architecture implemented

---

# 🔜 Day 3 – Login System (Next Step)

### Planned:
- Login page UI
- Find user by email
- Validate password
- Error handling
- Redirect to dashboard

---

# 🔜 Day 4 – Security + Complaint Module

### Planned:
- Password encryption (BCrypt)
- Complaint Entity
- Complaint submission form
- Save complaint to database
- Relationship mapping (User → Complaints)

---

# 🔜 Day 5 – Admin Panel + Final Polish

### Planned:
- Admin dashboard
- View all complaints
- Update complaint status
- Toast notifications
- UI polishing
- Code cleanup
- Final documentation

---

# 🗄 Database Configuration

application.properties:

```
spring.h2.console.enabled=true
spring.datasource.url=jdbc:h2:mem:testdb
spring.jpa.hibernate.ddl-auto=update
spring.thymeleaf.cache=false
```

Access H2 Console:

```
http://localhost:8080/h2-console
```

JDBC URL:
```
jdbc:h2:mem:testdb
```

User:
```
sa
```

Password:
```
(empty)
```

---

# 🚀 How to Run the Project

### Step 1
Clone repository:

```
git clone <https://github.com/COZYkrish/COMPLAINT-PORTAL>
```

### Step 2
Navigate to project folder:

```
cd complaintportal
```

### Step 3
Run project:

```
mvn spring-boot:run
```

### Step 4
Open in browser:

```
http://localhost:8080
```

---

# 📂 Complete Project Structure (After 5 Days)

```
complaintportal
│
├── pom.xml
├── README.md
├── .gitignore
│
└── src
    └── main
        ├── java
        │   └── com
        │       └── krish
        │           └── complaintportal
        │               │
        │               ├── ComplaintportalApplication.java
        │               │
        │               ├── controller
        │               │   ├── HomeController.java
        │               │   ├── AuthController.java
        │               │   └── ComplaintController.java
        │               │
        │               ├── model
        │               │   ├── User.java
        │               │   └── Complaint.java
        │               │
        │               ├── repository
        │               │   ├── UserRepository.java
        │               │   └── ComplaintRepository.java
        │               │
        │               └── service
        │                   ├── UserService.java
        │                   └── ComplaintService.java
        │
        └── resources
            ├── application.properties
            │
            ├── templates
            │   ├── index.html
            │   ├── register.html
            │   ├── login.html
            │   ├── dashboard.html
            │   └── admin.html
            │
            └── static
                ├── css
                │   └── style.css
                ├── js
                │   └── script.js
                └── images
```

---

# 🎯 Learning Outcomes

From this project you learn:

- Spring Boot fundamentals
- MVC architecture
- Layered design
- JPA & ORM
- Database persistence
- Form handling
- Git best practices
- Clean project structuring

---

# 🔐 Future Improvements

- JWT Authentication
- MySQL integration
- Role-based authorization
- REST API version
- Deployment on cloud (Render / Railway)

---

# 👨‍💻 Developed By

Krish Sharma  
Java + Spring Boot  🚀

---

# ⭐ Final Status

✔ Backend working  
✔ Database connected  
✔ Registration functional  
✔ Professional structure  
✔ Clean Git repository  

Project in active development.


# Spring Boot ID Card Generator

A simple Spring Boot + Thymeleaf based web application to generate student/employee ID cards with photo upload, live preview, and optional PDF download.

---

## 🚀 Features
- User-friendly **form to create ID card**
- **Photo upload** and automatic storage
- Dynamic **ID card preview**
- Ready for **Print integration**
- Lightweight & easy to deploy

---

## 🛠 Tech Stack
- **Backend:** Spring Boot, Spring MVC, Spring Data JPA
- **Frontend:** Thymeleaf, HTML5, CSS3
- **Database:** MySQL
- **Build Tool:** Maven

---

## 📂 Project Structure

```plaintext
springboot-idcard-generator/
│
├─ src/
│   ├─ main/
│   │   ├─ java/com/example/idcard/
│   │   │   ├─ controller/      → Handles form & view requests
│   │   │   ├─ model/           → ID card entity (IdCard.java)
│   │   │   ├─ repository/      → JPA repositories for DB
│   │   │   └─ service/         → Business logic (Service & Impl)
│   │   │
│   │   └─ resources/
│   │       ├─ static/
│   │       │   └─ uploads/     → Uploaded images
│   │       └─ templates/       → Thymeleaf templates (form.html, idcard.html)
│   │
│   └─ test/                    → Unit/Integration tests (optional)
│
├─ pom.xml                      → Maven dependencies
└─ README.md                    → Documentation

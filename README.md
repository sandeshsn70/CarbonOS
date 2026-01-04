# 🌍 CarbonOS 🌱  
## AI-based Carbon Emission Intelligence Platform

**Developed by:** **Sandesh Somnath Naikwade**  
**Role:** *Computer Engineer*  

CarbonOS is a **full-stack AI-powered Carbon Intelligence Platform** that calculates, predicts, and analyzes carbon emissions using **rule-based logic** and **machine learning models**.

It follows a **microservices architecture** built with **React, Spring Boot, and Flask (ML)**.

---
## 🚀 Key Features

- ✅ Rule-based carbon emission calculation (**Spring Boot**)
- 🤖 Machine Learning–based emission prediction (**Flask + Scikit-learn**)
- 🔗 Microservices architecture using **REST APIs**
- 🖥️ React-based frontend dashboard
- 📊 Real-time emission analysis
- 🗄️ H2 in-memory database
- 🔐 CORS-enabled secure communication

---

## 🏗️ System Architecture

React Frontend (UI)
↓
Spring Boot Backend (Rule Engine + Database)
↓
Flask ML Service (Prediction Engine)


---

## 🛠️ Technology Stack

### Frontend
- React.js
- JavaScript
- HTML, CSS

### Backend
- Java Spring Boot
- Spring Data JPA
- REST APIs
- H2 Database

### Machine Learning
- Python
- Flask
- Scikit-learn
- Pandas
- NumPy
- Linear Regression

---

## 📁 Project Structure

```bash
CarbonOS/
│
├── carbonos-backend/
│   ├── src/
│   └── pom.xml
│
├── carbonos-ai/
│   ├── app.py
│   ├── train_model.py
│   ├── model.pkl
│   └── requirements.txt
│
├── carbonos-frontend/
│   ├── src/
│   ├── public/
│   └── package.json
│
└── README.md
```


---

## ⚙️ How to Run the Project

### 1️⃣ Start Spring Boot Backend
```bash
cd carbonos-backend
./mvnw spring-boot:run
📍 Runs on http://localhost:8081
```

### 2️⃣ Start Flask ML Service
```bash
cd carbonos-ai
python app.py

📍 Runs on http://localhost:5000
```

### 3️⃣ Start React Frontend
```bash
cd carbonos-frontend
npm install
npm start

📍 Runs on http://localhost:3000
```
### 🔄 Application Flow

- User enters activity value in UI

- React calls Spring Boot API

- Spring Boot calculates actual emission (rule-based)

- Spring Boot calls Flask ML API

- Flask returns predicted emission (ML)

- UI displays both results

## 📊 Sample Output

- Actual Emission (Rule-based)

- Predicted Emission (ML)

- Displayed together for comparison.
 
## 🌱 Why This Project Matters

✔️ Real-world AI + Backend + Frontend integration

✔️ Clean microservices architecture

✔️ Climate-tech & ESG domain relevance

✔️ Enterprise-ready system design

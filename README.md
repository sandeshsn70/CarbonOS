🌍 CarbonOS 🌱
AI-based Carbon Emission Intelligence Platform

CarbonOS is a full-stack AI-powered Carbon Intelligence Platform that calculates, predicts, and analyzes carbon emissions using rule-based logic and machine learning models.
It follows a microservices architecture built with React, Spring Boot, and Flask ML services.

🚀 Key Features

✅ Rule-based carbon emission calculation (Spring Boot)

🤖 Machine Learning–based emission prediction (Flask + Scikit-learn)

🔗 Microservices architecture using REST APIs

🖥️ React-based frontend dashboard

📊 Real-time emission analysis

🗄️ In-memory H2 database

🔐 CORS-enabled secure communication

🏗️ System Architecture
React Frontend (UI)
        ↓
Spring Boot Backend (Rule Engine + DB)
        ↓
Flask ML Service (Prediction Engine)

🛠️ Technology Stack
Frontend

React.js

JavaScript

HTML, CSS

Fetch API

Backend

Java Spring Boot

Spring Data JPA

REST APIs

H2 Database

AI / ML

Python

Flask

Scikit-learn

Pandas

NumPy

Linear Regression

Tools

Maven

Node.js & npm

Git & GitHub

📁 Project Folder Structure
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

⚙️ How to Run the Project
1️⃣ Start Spring Boot Backend
cd carbonos-backend
./mvnw spring-boot:run


📍 Runs on http://localhost:8081

2️⃣ Start Flask ML Service
cd carbonos-ai
python app.py


📍 Runs on http://localhost:5000

3️⃣ Start React Frontend
cd carbonos-frontend
npm install
npm start


📍 Runs on http://localhost:3000

🔄 Application Flow

User enters activity data in the UI

React sends request to Spring Boot backend

Spring Boot calculates rule-based emission

Spring Boot calls Flask ML service

Flask returns predicted emission

UI displays both results

📤 Sample Output

Actual Emission (Rule-based) – Calculated using emission factors

Predicted Emission (ML) – Generated using trained ML model

🌱 Industry Relevance

Microservices Architecture

AI served via REST APIs

Full Stack + ML integration

Climate-Tech / ESG domain

Scalable enterprise-ready design

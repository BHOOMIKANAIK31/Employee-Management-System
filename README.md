Employee Management System
<img width="1024" height="559" alt="0fc70033-9f2b-4bda-9cc6-48a78bbcf788" src="https://github.com/user-attachments/assets/dd8141d4-eb9e-4589-81ee-b3bc4fd3f644" />


A Spring Boot MVC CRUD application built using:

- Spring Boot
- Spring MVC
- Spring Data JPA
- MySQL
- Thymeleaf
- Maven

 Features	
- Add Employee
- View Employees
- Update Employee
- Delete Employee
- Flash messages
- MVC architecture

 Tech Stack
•	Backend: Spring Boot (Java 17)
•	Frontend: Thymeleaf
•	Database: MySQL
•	Build Tool: Maven

How to Run

1. Clone the repository
2. Configure MySQL in application.properties
3. Run as Spring Boot application


# Employee Management System - Spring Boot Deployment on Kubernetes 🚀

## 📌 Project Overview

This project demonstrates the complete deployment of a Spring Boot Employee Management System using modern DevOps practices.

The application is containerized using Docker and deployed on a Kubernetes cluster with MySQL database integration. Jenkins is used to automate the deployment process through CI/CD pipelines.

---

# 🏗️ Architecture


Developer
|
|
v
GitHub Repository
|
|
v
Jenkins CI/CD Pipeline
|
|---- Build Spring Boot Application
|
|---- Build Docker Image
|
|---- Push Image to Docker Hub
|
v
Kubernetes Cluster

    Control Plane
          |
          |
   -----------------
   |               |

Worker Node 1 Worker Node 2

   |
   |

Kubernetes Services

   |
   |

Spring Boot Pods
|
|
NodePort Service
|
|
MySQL ClusterIP Service
|
|
MySQL StatefulSet
|
|
Persistent Volume


---

# 🛠️ Technologies Used

## Application
- Java 21
- Spring Boot 3
- Spring MVC
- Spring Data JPA
- Thymeleaf
- MySQL

## DevOps Tools
- Linux Ubuntu
- Git & GitHub
- Maven
- Docker
- Jenkins
- Kubernetes
- Nginx Reverse Proxy

---

# ☁️ Infrastructure Setup

## Kubernetes Cluster

### Control Plane


CPU : 2 Core
RAM : 4 GB
Storage : 15 GB


### Worker Node


CPU : 2 Core
RAM : 4 GB
Storage : 15 GB


### Jenkins Server


CPU : 2 Core
RAM : 8 GB
Storage : 30 GB


---

# 🐳 Docker Implementation

Created Docker image for Spring Boot application.

Docker workflow:


Spring Boot Application
|
|
Maven Build
|
|
app.jar
|
|
Docker Image
|
|
Docker Hub


---

# ☸️ Kubernetes Deployment

## Kubernetes Resources Created

### Namespace

Created isolated environment:


production


---

### Spring Boot Deployment

Features:

- Multiple replicas
- Container image deployment
- Self-healing using Kubernetes Deployment


File:


app-deployment.yaml


---

### Spring Boot Service

Created NodePort service:


Service Type: NodePort

Port:
8080 -> 30080


Application accessible through:


Worker Node IP:30080


---

### MySQL StatefulSet

Created MySQL database deployment using StatefulSet.

Features:

- Stable network identity
- Persistent storage
- Database pod management


File:


mysql-statefulset.yaml


---

### MySQL Service

Created internal ClusterIP service.


Service Type: ClusterIP

Port:
3306


Spring Boot communicates with MySQL using:


mysql-service:3306


---

# 💾 Storage Configuration

Implemented Kubernetes storage:


Persistent Volume (PV)
|
|
Persistent Volume Claim (PVC)
|
|
MySQL StatefulSet


Database data remains persistent even after pod restart.

---

# 🔄 Jenkins CI/CD Pipeline

Created two Jenkins pipelines:

## Pipeline 1 - Build

Responsibilities:


Git Checkout
|
|
Maven Build
|
|
Create JAR
|
|
Docker Build
|
|
Docker Push


---

## Pipeline 2 - Kubernetes Deployment

Supports:


Deploy Application

Deploy Database

Remove Application

Remove Database


Deployment flow:


Jenkins
|
|
kubectl apply
|
|
Kubernetes Cluster
|
|
Application Running


---

# 🌐 Nginx Reverse Proxy

Configured Nginx as reverse proxy.

Flow:


User Browser

  |
  v

Nginx (Port 80)

  |
  v

Kubernetes NodePort Service

  |
  v

Spring Boot Application


---

# 🔍 Verification Commands

Check nodes:

```bash
kubectl get nodes

Check namespaces:

kubectl get ns

Check pods:

kubectl get pods -n production

Check services:

kubectl get svc -n production

Check logs:

kubectl logs <pod-name> -n production
🧠 Learning Outcomes

Through this project I learned:

✅ Containerizing Spring Boot applications using Docker

✅ Creating Kubernetes deployments and services

✅ Managing application and database workloads using Kubernetes

✅ Implementing StatefulSet with Persistent Volume storage

✅ Automating deployment using Jenkins pipelines

✅ Understanding CI/CD workflow

✅ Troubleshooting real deployment issues

🚧 Challenges Faced & Solutions
Issue 1: Kubernetes authentication for Jenkins

Problem:

Jenkins user could not access Kubernetes cluster.

Solution:

Configured kubeconfig access for Jenkins user.

Issue 2: MySQL Pod stuck in Pending state

Problem:

pod has unbound PersistentVolumeClaims

Solution:

Configured Persistent Volume and Persistent Volume Claim.

Issue 3: Application unable to connect with database

Problem:

Database service communication issue.

Solution:

Configured Kubernetes ClusterIP service:

mysql-service:3306
 Author:
Bhoomika Naik


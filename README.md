# Task Management System

A Spring Boot 3 based Task Management System with Role-Based Access Control, Session Authentication using Redis, MongoDB persistence, Activity Logging, and Admin Dashboard.

## Tech Stack

### Backend
- Java 17
- Spring Boot 3
- Spring Security
- Spring Session Redis
- MongoDB
- Spring Data MongoDB
- Lombok
- MapStruct

### Infrastructure
- Docker
- Redis
- MongoDB

---

## Features

### Authentication
- Session Based Authentication
- Login / Logout
- Redis-backed Session Management
- Role-Based Authorization

### User Management
- Register User
- View Users
- Update User Status
- Delete User

### Task Management
- Create Task
- Update Task
- Delete Task
- View Own Tasks
- Admin View All Tasks

### Activity Logging
Tracks:
- Login Activity
- Logout Activity
- Task Creation
- Task Updates
- Task Deletion

### Dashboard Analytics
- Total Users
- Active Users
- Inactive Users
- Total Tasks
- Completed Tasks
- Pending Tasks

---

## Roles

### ADMIN
- View All Users
- Manage Users
- View All Tasks
- Delete Any Task
- Access Dashboard
- View Activity Logs

### USER
- Create Own Tasks
- View Own Tasks
- Update Own Tasks
- Delete Own Tasks

---

## Project Structure

```text
src/main/java
│
├── controller
├── service
├── repository
├── entity
├── dto
├── security
├── exception
└── config
```

---

## Security Flow

```text
User Login
      ↓
AuthenticationManager
      ↓
CustomUserDetailsService
      ↓
MongoDB User Validation
      ↓
SecurityContext Creation
      ↓
Session Stored In Redis
      ↓
JSESSIONID Cookie Returned
      ↓
Subsequent Requests Authenticated Automatically
```

---

## API Endpoints

### Authentication

| Method | Endpoint |
|----------|------------|
| POST | /auth/register |
| POST | /auth/login |
| POST | /auth/logout |

### User Management (Admin)

| Method | Endpoint |
|----------|------------|
| GET | /admin/users |
| GET | /admin/users/{id} |
| PUT | /admin/users/{id}/status |
| DELETE | /admin/users/{id} |

### Tasks

| Method | Endpoint |
|----------|------------|
| POST | /tasks |
| GET | /tasks/my |
| GET | /tasks/{id} |
| PUT | /tasks/{id} |
| DELETE | /tasks/{id} |
| GET | /tasks |

### Dashboard

| Method | Endpoint |
|----------|------------|
| GET | /admin/dashboard |

### Activity Logs

| Method | Endpoint |
|----------|------------|
| GET | /admin/activity-logs |

---

## Local Setup

### Clone Repository

```bash
git clone <repository-url>
cd taskManagement
```

### Start MongoDB

```bash
docker run -d \
--name mongodb \
-p 27017:27017 \
mongo:7
```

### Start Redis

```bash
docker run -d \
--name redis \
-p 6379:6379 \
redis:7-alpine
```

### Run Application

```bash
mvn clean install

mvn spring-boot:run
```

---

## Docker Build

### Build Image

```bash
docker build -t task-management .
```

### Run Container

```bash
docker run -p 8080:8080 task-management
```

---

## Default Session Configuration

```properties
server.servlet.session.timeout=30m
```

Sessions automatically expire after 30 minutes of inactivity.

---

## Activity Logging

Implemented using Spring AOP.

Logged Events:
- LOGIN
- LOGOUT
- TASK_CREATED
- TASK_UPDATED
- TASK_DELETED

---

## Author

Rajnish Kumar

Java | Spring Boot | MongoDB | Redis | Microservices

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
# TaskManagementUi

This project was generated using [Angular CLI](https://github.com/angular/angular-cli) version 19.2.1.

## Development server

To start a local development server, run:

```bash
ng serve
```

Once the server is running, open your browser and navigate to `http://localhost:4200/`. The application will automatically reload whenever you modify any of the source files.

## Code scaffolding

Angular CLI includes powerful code scaffolding tools. To generate a new component, run:

```bash
ng generate component component-name
```

For a complete list of available schematics (such as `components`, `directives`, or `pipes`), run:

```bash
ng generate --help
```

## Building

To build the project run:

```bash
ng build
```

This will compile your project and store the build artifacts in the `dist/` directory. By default, the production build optimizes your application for performance and speed.

## Running unit tests

To execute unit tests with the [Karma](https://karma-runner.github.io) test runner, use the following command:

```bash
ng test
```

## Running end-to-end tests

For end-to-end (e2e) testing, run:

```bash
ng e2e
```

Angular CLI does not come with an end-to-end testing framework by default. You can choose one that suits your needs.

## Additional Resources

For more information on using the Angular CLI, including detailed command references, visit the [Angular CLI Overview and Command Reference](https://angular.dev/tools/cli) page.

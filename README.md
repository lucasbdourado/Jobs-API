# Jobs API

A REST API for managing job postings, built with **Java**, **JAX-RS (Jersey)**, **JDBC** and **MySQL**.

The project provides CRUD operations for job listings and follows a layered architecture separating API resources, business logic and database access.

## Tech Stack

* Java 8
* JAX-RS
* Jersey
* JDBC
* MySQL
* Maven
* Tomcat
* Docker

## Architecture

```text
HTTP Request
     ↓
Resource
     ↓
Service
     ↓
DAO
     ↓
JDBC
     ↓
MySQL
```

### Resource

Handles REST endpoints, HTTP requests and responses.

### Service

Contains the application logic and connects the Resource and DAO layers.

### DAO

Handles database operations using JDBC.

### Domain

Contains the application models.

## API

Base path:

```text
/api/v1
```

### Get all jobs

```http
GET /api/v1/jobs/all
```

### Get job by ID

```http
GET /api/v1/jobs?id={id}
```

### Create job

```http
POST /api/v1/jobs/create
```

### Update job

```http
PUT /api/v1/jobs?id={id}
```

### Delete job

```http
DELETE /api/v1/jobs?id={id}
```

## Build

```bash
./mvnw clean package
```

On Windows:

```bash
mvnw.cmd clean package
```

The application is packaged as a WAR and can be deployed to Tomcat.

## Docker

Build the application first:

```bash
./mvnw clean package
```

Then build the Docker image:

```bash
docker build -t jobs-api .
```

The application runs on Tomcat using port `8080`.

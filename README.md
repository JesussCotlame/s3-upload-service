# S3 Upload Service

Spring Boot REST API to upload files to Amazon S3, supporting both AWS and LocalStack environments.

---

## 🚀 Features

- Upload files via `/s3/upload`
- Support for AWS S3 (production) and LocalStack (development)
- Environment selection via Spring profiles
- Docker-based setup for local S3 simulation
- Makefile helpers to manage environment and app lifecycle

---

## 🛠️ Requirements

- Java 17+
- Maven Wrapper (`./mvnw`)
- Docker (for LocalStack)
- AWS CLI (for managing test buckets)

---

## 🔧 Setup

### 1. Start LocalStack (from project root)

```bash
make start-localstack
```

### 2. Create the bucket

```bash
make create-bucket
```

### 3. Run the application

#### Development (LocalStack)
```bash
make run-app-localstack
```

#### Production (AWS)
```bash
make run-app-prod
```

---

## 📤 Upload a file

### Using cURL

```bash
curl -F "file=@/absolute/path/to/file.txt" http://localhost:8080/s3/upload
```

### Using Postman

- Method: `POST`
- URL: `http://localhost:8080/s3/upload`
- Body: `form-data`
  - Key: `file` (type: File)
  - Value: Select a file

---

## 📁 List files in the bucket

```bash
make list-objects
```
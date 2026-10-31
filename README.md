# NOVA Medical — Distributed Hospital Patient Monitoring

A premium React + Spring Boot demonstration for the assigned concept:
**Real-Time Distributed Computing** and application:
**Distributed Hospital Patient Monitoring Application**.

## Stack

- React + Vite
- Spring Boot 3.5
- Spring Web / REST
- Spring WebSocket + STOMP
- Spring Data JPA
- H2 file database
- Recharts-ready frontend

## Run backend

Requirements: Java 17+ and Maven.

```bash
cd backend
mvn spring-boot:run
```

Backend: http://localhost:8080

## Run frontend

Requirements: Node.js 18+.

```bash
cd frontend
npm install
npm run dev
```

Frontend: http://localhost:5173

## Real-time demonstration

POST a vital reading to:
`POST http://localhost:8080/api/vitals`
Example:

```json
{
  "patientId": 3,
  "heartRate": 132,
  "spo2": 85,
  "temperature": 39.1,
  "respiratoryRate": 24,
  "bloodPressure": "145/92"
}
```

The backend evaluates the status, stores the reading, creates a critical alert when thresholds are exceeded, and broadcasts the update over WebSocket to the React dashboard.

## Notes

The included H2 database is intentionally zero-configuration for a college demonstration. For production, replace it with PostgreSQL/MySQL and add authentication, authorization, encryption, audit logging, and clinical validation.

# ⚡ Hackathon EV Charging Platform

This is a monorepo containing the full stack EV charging slot booking system:

- Backend: Spring Boot (Java 21)
- Frontend: React (JavaScript)
- Database: PostgreSQL (Neon Cloud)

---

# 📁 Project Structure
hackathonEV/
├── ev-charging-api/ # Spring Boot backend
├── ev-charging-webapp/ # React frontend
└── README.md


---

# 🚀 Quick Start (For All Developers)

## 1. Clone the repository

```bash
git clone <YOUR_REPO_URL>
cd hackathonEV
```


🖥️ Backend Setup (Spring Boot API)
Requirements
Java 21 installed
Maven (or use included wrapper mvnw)
Run backend
```bash
cd ev-charging-api
./mvnw spring-boot:run
```
Backend runs at:
http://localhost:8080
API base path:
http://localhost:8080/api
⚠️ Important Backend Notes
Database (Neon PostgreSQL)

Make sure your application.properties has:

spring.datasource.url=jdbc:postgresql://<NEON_HOST>/neondb?sslmode=require
spring.datasource.username=<USERNAME>
spring.datasource.password=<PASSWORD>

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
Default endpoints (WIP)
GET /api/stations
POST /api/bookings
GET /api/availability
🌐 Frontend Setup (React Web App)
Requirements
Node.js (LTS recommended)
npm
Install & run
cd ev-charging-webapp
npm install
npm start
Frontend runs at:
http://localhost:3000
⚠️ Important Frontend Notes

Update API base URL in:

src/api/client.js

Example:

import axios from "axios";

export const api = axios.create({
  baseURL: "http://localhost:8080/api",
});

If testing on mobile network, replace localhost with your machine IP.

🔌 Database (Neon)

We use Neon cloud PostgreSQL.

No local DB required
Shared cloud database for all developers
Supports multiple connections safely
👥 Team Git Workflow
Branching Strategy
main → stable production/demo branch
dev → integration branch
feature/* → individual feature development
Example branches:
feature/station-list-ui
feature/booking-system
feature/auth-integration
feature/backend-booking-api
Git workflow
git checkout -b feature/your-feature
git add .
git commit -m "feat: add booking UI"
git push origin feature/your-feature

Then open a Pull Request → dev

⚡ Hackathon Goal

Build a working prototype that allows:

Viewing EV charging stations
Checking available slots
Booking a charging slot
Preventing double bookings
🧠 Tech Stack Summary
Backend
Spring Boot
Spring Data JPA
PostgreSQL (Neon)
Flyway (optional migrations)
Frontend
React (JavaScript)
Axios
React Router
🚨 Common Issues
❌ Backend won't start
Check Java version (must be 21)
Check application.properties DB config
❌ Frontend API errors
Ensure backend is running
Check correct IP instead of localhost
🎯 Notes for Judges

This system demonstrates:

Cloud database integration
Scalable backend architecture
Clean separation of frontend/backend
Real-world EV infrastructure use case

# 🏢 Enterprise-Grade Test Automation Framework

An end-to-end **Test Automation Framework** built for enterprise-grade testing of:
- 🌐 Web (Selenium WebDriver)
- 🔌 API (REST Assured)
- 📱 Mobile (Appium for Android & iOS)
- ☁️ CI/CD: GitHub Actions + Docker
- 📊 Observability: Allure, InfluxDB, Grafana, ReportPortal
- 📬 Email Reports with Logs & Screenshots

---

## 📁 Project Structure
root/
│
├── src/
│ ├── main/
│ │ └── java/
│ │ ├── base/ # Base classes for UI/API/Mobile
│ │ ├── config/ # Environment & execution configs
│ │ ├── drivers/ # Driver setups for Web/Mobile
│ │ ├── utils/ # Logging, Reporting, Email, CLI
│ │ └── listeners/ # ITestListener for reporting
│ │
│ └── test/
│ ├── resources/
│ │ └── testng.xml, feature files, properties
│ ├── ui/ # Web test cases & steps
│ ├── api/ # API test cases & assertions
│ └── mobile/ # Appium test cases
│
├── reports/ # Allure, Logs, Screenshots
├── .github/workflows/ # GitHub Actions YAML files
├── docker/ # Docker Compose: Selenium Grid, InfluxDB, Grafana
├── influxdb-grafana-dashboard/ # Dashboards and provisioning
├── Jenkinsfile # Optional Jenkins support
├── pom.xml # Single Maven project
└── README.md


---

## 🚀 Execution Modes

### 🔹 Local Mode (Sequential Execution)
- UI → API → Mobile (Android)
- Browser: Chrome
- Platform: Local emulator or connected device
- Reports: Allure, Email (Gmail), Logs, Screenshots
- Publish to: Grafana (InfluxDB)

-bash
mvn clean test -Dexec_mode=local -Dbrowser=chrome -Dmobile_device=android
---
### 🔹GitHub Actions Mode (Parallel Execution)
- Web: Chrome, Firefox, Safari

- API: Parallel execution

- Mobile: Android + iOS (via BrowserStack)

- Reports: Allure, ReportPortal, Logs zipped & emailed

Publish to: Grafana (InfluxDB)

mvn clean test -Dexec_mode=remote -Dbrowser=all -Dmobile_device=all

🛠️ Key Features
Feature	Description
✅ UI Tests	Selenium WebDriver, Page Object Model
✅ API Tests	REST Assured, JSON Schema Validation
✅ Mobile Tests	Appium (Android/iOS), supports BrowserStack
🧪 BDD Support	Cucumber + TestNG (UI, API, Mobile)
🐳 Docker Support	InfluxDB, Grafana, Selenium Grid
☁️ GitHub Actions	Full CI/CD pipeline
📈 Grafana Dashboards	Live execution metrics from InfluxDB
📨 Email Reporter	Emails logs, screenshots, Allure report zip
📊 ReportPortal	Centralized test report tracking


🔧 Configuration
Edit src/main/resources/config.properties:

properties
Copy
Edit
execution.mode=local
browser=chrome
mobile.device=android
report.email.enabled=true
grafana.enabled=true
reportportal.enabled=true

📦 Commands
Run All Tests (Local)
bash
Copy
Edit
mvn clean test -Dexec_mode=local
Run Selected Tests by Tag (BDD)
bash
Copy
Edit
mvn clean verify -Dcucumber.filter.tags="@smoke"

Run on GitHub Actions (parallel)
Triggered via push to main.

📤 Email Reports
Configured using Gmail SMTP

Sends: Allure Report (zipped) + Execution Logs + Screenshots (failures)

📊 Grafana + InfluxDB Setup
1. Start Services
docker-compose -f docker/influxdb-grafana-compose.yaml up -d

2. Import Dashboard
   Open Grafana at http://localhost:3000

Login: admin/admin

Import dashboard JSON from /influxdb-grafana-dashboard/automation-dashboard.json

🔍 ReportPortal Integration
Hosted version or Docker setup

Token and endpoint stored in reportportal.properties

Automatically triggers for GitHub Actions runs

👥 Contributors
QA Automation Engineer (you!)

Powered by Java 17, TestNG, Maven

📃 License
MIT License
---


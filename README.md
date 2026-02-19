# Newsletter Automation Test Suite

Automated Selenium test suite for testing the newsletter application. This project implements end-to-end testing with a complete CI/CD pipeline using GitHub Actions.

## 🎯 Project Overview

This repository contains automated tests for a Newsletter Sign-Up Application. The tests ensure the application's core functionality, reliability, and stability throughout the development lifecycle.

## 📋 Prerequisites

- **Java 21+** (Temurin JDK recommended)
- **Maven 3.8+**
- **Chrome Browser** (for local testing)
- **ChromeDriver** (auto-managed by WebDriver Manager)

## 🚀 Quick Start

### Clone the Repository
```bash
git clone https://github.com/nksarps/newsletter-test.git
cd newsletter-test
```

### Run Tests Locally

**With visible browser (GUI mode):**
```bash
mvn clean test
```

**Headless mode (without GUI):**
```bash
mvn clean test -Dheadless=true
```

## 🏗️ Project Structure

```
newsletter-test/
├── src/
│   ├── main/java/com/automation/
│   │   └── pages/
│   │       ├── BasePage.java          # Base class for page objects
│   │       └── NewsletterPage.java    # Newsletter page object
│   └── test/java/com/automation/
│       ├── base/
│       │   └── SetUp.java             # WebDriver configuration
│       └── tests/
│           └── NewsletterTest.java    # Test cases
├── .github/workflows/
│   └── ci.yml                         # GitHub Actions CI pipeline
├── pom.xml                            # Maven configuration
└── README.md                          # This file
```

## 🧪 Test Cases

**NewsletterTest** — Validates newsletter subscription and core functionality:
- Page load verification
- Element visibility checks
- Form interactions
- Subscription workflow

## 🔄 CI/CD Pipeline

### GitHub Actions Workflow
Tests automatically run on:
- ✅ Every push to any branch
- ✅ Every pull request

**CI Configuration:** `.github/workflows/ci.yml`

### Pipeline Steps
1. **Checkout** code from repository
2. **Setup Java 21** (Temurin distribution)
3. **Cache Maven** dependencies for faster builds
4. **Verify Chrome** availability
5. **Run Tests** in headless mode
6. **Send Notifications** (Slack + Email)

### Build Status Badge
```markdown
![CI](https://github.com/nksarps/newsletter-test/actions/workflows/ci.yml/badge.svg)
```

## ⚙️ Configuration

### Local Setup
No configuration required. Tests run with default settings pointing to:
- **URL:** `https://danewsletter.netlify.app/`
- **Browser:** Chrome (automatic driver management)

### CI/CD Secrets
To enable notifications, add these GitHub repository secrets:

**Slack Notifications:**
- `SLACK_WEBHOOK_URL` — Incoming webhook URL from Slack

**Email Notifications (Gmail SMTP):**
- `SMTP_SERVER` — `smtp.gmail.com`
- `SMTP_PORT` — `587`
- `SMTP_USERNAME` — Your Gmail address
- `SMTP_PASSWORD` — Gmail app password (generate at [myaccount.google.com/apppasswords](https://myaccount.google.com/apppasswords))
- `NOTIFY_EMAIL_FROM` — Sender email (same as `SMTP_USERNAME`)
- `NOTIFY_EMAIL_TO` — Recipient email(s)

## 🛠️ Technologies

| Tool | Version | Purpose |
|------|---------|---------|
| Java | 21 | Programming language |
| Selenium | 4.40.0 | Browser automation |
| JUnit 5 | 6.1.0-M1 | Testing framework |
| Maven | 3.x | Build automation |
| Chrome | Latest | Web browser |

## 🤝 Contributing

1. Create feature branch: `git checkout -b feature/your-feature`
2. Make changes and add tests
3. Run tests locally: `mvn clean test`
4. Commit with descriptive message
5. Push and create pull request

## 📞 Support

For issues or questions:
- Check GitHub Actions logs for CI failures
- Review test output in the console
- Examine Selenium error messages for debugging

## 📄 License

This project is licensed under the MIT License.

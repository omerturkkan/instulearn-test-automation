# InstuLearn Test Automation

A BDD test automation framework for [InstuLearn](https://qa.instulearn.com/), a learning management system (LMS) with Student and Teacher roles. The framework covers UI and API tests and is built the way a product team would build it: user stories, pull requests, CI/CD and reporting.

## Tech Stack

| Area | Tool | Status |
|---|---|---|
| Language / Build | Java 21, Maven | In use |
| UI automation | Selenium 4 | In use |
| BDD | Cucumber 7, JUnit 5 Platform | Planned |
| API testing | REST Assured | Planned |
| Assertions | AssertJ | Planned |
| Reporting | Allure | Planned |
| Logging | SLF4J, Log4j2 | Planned |
| CI/CD | Jenkins | Planned |

## Prerequisites

- JDK 21
- Maven 3.9+
- Git

## Status

Work in progress. Planned milestones:

- [x] Maven project setup
- [x] Configuration handling and WebDriver management
- [ ] First page object and login scenario
- [ ] Hooks: screenshots on failure, logging, Allure attachments
- [ ] User stories implemented as test scenarios
- [ ] API tests with REST Assured
- [ ] Parallel and cross-browser execution
- [ ] Jenkins pipeline with Allure report publishing
- [ ] Scheduled nightly regression

# InstuLearn Test Automation

A BDD test automation framework for [InstuLearn](https://qa.instulearn.com/), a learning management system (LMS) with Student and Teacher roles. The framework covers UI and API tests and is built the way a product team would build it: user stories, pull requests, CI/CD and reporting.

## Tech Stack

| Area | Tool | Status |
|---|---|---|
| Language / Build | Java 21, Maven | In use |
| UI automation | Selenium 4 | In use |
| BDD | Cucumber 7, JUnit 5 Platform | In use |
| API testing | REST Assured | Planned |
| Assertions | AssertJ | In use |
| Reporting | Allure | In use |
| Logging | SLF4J, Log4j2 | In use |
| CI/CD | Jenkins (Pipeline as Code) | In use |
| Containers | Docker Compose, Selenium Grid | In use |

## Prerequisites

- JDK 21
- Git
- Google Chrome (for local runs)
- Docker Desktop (for Selenium Grid and Jenkins)

Maven does not need to be installed. The project includes the Maven Wrapper (`mvnw`), which downloads the right Maven version on the first run.

## How to Run

1. Copy `.env.example` to `.env` and fill in the test account credentials.
2. Run the tests:

   ```
   ./mvnw test
   ```

   On Windows (PowerShell or cmd), use `mvnw.cmd test`.

To run without opening a browser window: `./mvnw test -Dheadless=true`

To view the Allure report after a run:

```
./mvnw io.qameta.allure:allure-maven:serve
```

### Run on Selenium Grid (Docker)

Start the containers defined in `docker-compose.yml`:

```
docker compose up -d
```

| Service | URL | Purpose |
|---|---|---|
| Jenkins | http://localhost:8080 | CI server |
| Selenium Grid | http://localhost:4444 | Remote Chrome |
| Live browser view | http://localhost:7900 (password: `secret`) | Watch the test run |

Run the tests against the Grid instead of the local Chrome:

```
./mvnw test -Dremote=true
```

### Run in Jenkins

The pipeline is defined in the `Jenkinsfile`. It runs all tests on the Selenium Grid container.

1. Open Jenkins at http://localhost:8080 and finish the setup wizard.
2. Add two credentials of type **Username with password**: `instulearn-student` and `instulearn-teacher`. The pipeline passes them to the tests as environment variables, so no secrets are stored in the repository.
3. Create a **Pipeline** job with **Pipeline script from SCM**, pointing to this repository.
4. Click **Build Now**.

To start a build automatically on every push, the pipeline uses a GitHub webhook (`githubPush()` trigger). Because Jenkins runs on `localhost`, GitHub reaches it through an [ngrok](https://ngrok.com/) tunnel:

1. Start the tunnel: `ngrok http 8080`
2. In the GitHub repository, go to **Settings → Webhooks** and add `https://<your-ngrok-domain>/github-webhook/` with content type `application/json` and the **push** event.
3. Run one build manually so that Jenkins registers the trigger. After that, every push starts a build.

## Status

Work in progress. Planned milestones:

- [x] Maven project setup
- [x] Configuration handling and WebDriver management
- [x] First page object and login scenario
- [x] Hooks: screenshots on failure, logging, Allure attachments
- [ ] User stories implemented as test scenarios
- [x] Jenkins pipeline running the tests on Selenium Grid (Docker)
- [ ] Allure report publishing in Jenkins
- [ ] API tests with REST Assured
- [ ] Parallel and cross-browser execution
- [ ] Scheduled nightly regression

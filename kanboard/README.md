E2E Web Testing benchmark
=========================

Test suites for Kanboard
----------------------

This directory contains test suites and Gherkin speficiations for Kanboard.

# Deployment instructions
The Docker container for the application under test can be created using the following command:

```bash
docker run -d --name kanboard -p 8080:80 -t kanboard/kanboard:v1.2.15

```

The web application will be exposed on `localhost:8080`. The application is ready to use when the container is started, no post-installation steps are required. To use the test suite with the RemoteWebDriver, the acutal IP address/domain name where the application resides must be used instead of `localhost`. The URL must be changed in the class `tests.BaseTest.app_url`.

This test suite has been executed 50 times on Google Chrome version 137 without failures. To deploy the browser in a Docker container, use the following command:

```bash
docker run -d -p 4444:4444 -p 7900:7900 --shm-size="2g" --name=browser selenium/standalone-chrome:137.0-chromedriver-137.0
```


E2E Web Testing benchmark
=========================

Test suites for Bludit
----------------------

This directory contains test suites and Gherkin speficiations for Bludit. The Gherkin files refer to Bludit 2.3.4.

# Deployment instructions
The Docker container for the application under test can be created using the following commands:

```bash
#for version 2.3.4
docker run --name bludit -p 8080:80 -d bludit/docker:2.3.4
#for version 3.13.1
docker run --name bludit -p 8080:80 -d bludit/docker:3.13.1
```

The web application will be exposed on `localhost:8080`. 

This test suite has been executed 50 times on Google Chrome version 137 without failures. To deploy the browser in a Docker container, use the following command:

```bash
docker run -d -p 4444:4444 -p 7900:7900 --shm-size="2g" --name=browser selenium/standalone-chrome:137.0-chromedriver-137.0
```

# Installation instructions

Once the container is deployed, the user must connect to `/install.php` and follow the installation wizard. The required language is English, the required password is `e2eW3Bt3s71nGB3nchM4rK`. An automated installer is provided in the class `tests.Installer`
To use the test suite with the RemoteWebDriver, the acutal IP address/domain name where the application resides must be used instead of `localhost`. The URL must be changed in the class `tests.BaseTest.app_url`.


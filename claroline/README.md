E2E Web Testing benchmark
=========================

Test suites for Claroline
----------------------

This directory contains test suites and Gherkin speficiations for Claroline.

# Deployment instructions
The Docker container for the application under test can be created using the following commands:

```bash
docker run -it --workdir=/home/claroline --name=claroline --expose 80 --expose 3306 -p 3000:80 -p 3306:3306 -d --entrypoint ./run-services-docker.sh olianasd/claroline-strongpsw bash
```

The web application will be exposed on `http://localhost:3000/claroline11110/index.php`. The application is ready to use when the container is started, no post-installation steps are required.
To use the test suite with the RemoteWebDriver, the acutal IP address/domain name where the application resides must be used instead of `localhost`. The URL must be changed in the classes `test.BaseTest.app_url` and `po.ClarolinePage.app_url`.

This test suite has been executed 50 times on Google Chrome version 138 without failures. To deploy the browser in a Docker container, use the following command:

```bash
docker run -d -p 4444:4444 -p 7900:7900 --shm-size="2g" --name=browser selenium/standalone-chrome:138.0-chromedriver-138.0
```


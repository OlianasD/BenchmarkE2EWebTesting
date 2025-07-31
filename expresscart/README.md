E2E Web Testing benchmark
=========================

Test suites for ExpressCart
----------------------

This directory contains test suites and Gherkin speficiations for ExpressCart.

# Deployment instructions
The Docker container for the application under test can be created using the following command:

```bash
docker run -i -t  --name=expresscart -p "3000:1111" -d olianasd/expresscart-strongpsw
```

The web application will be exposed on `localhost:3000`. The application is ready to use when the container is started, no post-installation steps are required. To use the test suite with the RemoteWebDriver, the acutal IP address/domain name where the application resides must be used instead of `localhost`. The URL must be changed in the class `test.BaseTest.app_url`.

This test suite has been executed 50 times on Google Chrome version 137 without failures. To deploy the browser in a Docker container, use the following command:

```bash
docker run -d -p 4444:4444 -p 7900:7900 --shm-size="2g" --name=browser selenium/standalone-chrome:137.0-chromedriver-137.0
```


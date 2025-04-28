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

The web application will be exposed on `localhost:8080`. The application is ready to use when the container is started, no post-installation steps are required.


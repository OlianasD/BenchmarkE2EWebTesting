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


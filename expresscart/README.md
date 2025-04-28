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

The web application will be exposed on `localhost:3000`. The application is ready to use when the container is started, no post-installation steps are required.


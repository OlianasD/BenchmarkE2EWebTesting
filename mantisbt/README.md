E2E Web Testing benchmark
=========================

Test suites for MantisBT
----------------------

This directory contains test suites and Gherkin speficiations for MantisBT. The Gherkin specifications refer to MantisBT 1.2.0.

# Deployment instructions
A Docker image is available for both versions of the application (1.2.0 and 2.25.4).

## Deployment instructions for MantisBT 1.2.0
The Docker container for the application under test can be created using the following command:

```bash
docker run -it --workdir=/home --name=mantisbt --expose 80 --expose 3306 -p 3000:80 -p 3306:3306 -d --entrypoint ./run-services-docker.sh dockercontainervm/mantisbt:1.2.0 bash
```
The web application will be exposed on `localhost:3000`. The application is ready to use when the container is started, no post-installation steps are required.


## Deployment instructions for MantisBT 2.25.4
The Docker containers for MantisBT 2.25.4 can be created using the `docker-compose.yml` file contained in `mantisbt/baseline/mantisbt-2.25.4/docker-compose.yml`. Just move into the directory using a terminal and type:

```bash
docker compose up
```

The web application will be exposed on `localhost:8989`. After the containers are deployed, an installation wizard must be followed. Please refer to the further section **Installation instructions (only for MantisBT 2.25.4)**

# Installation instructions (only for MantisBT 2.25.4)

To finalize the installation of MantisBT 2.25.4, go to http://localhost:8989/admin/install.php and perform the following steps:

1. Fill the form **Installation options** with the following values:

    * Hostname (for Database server): `mysql`
    * Username (for Database): `mantisbt`
    * Password (for Database): `mantisbt`
    * Database name (for Database): `bugtracker`
    * Admin Username (to create Database if required): `root`
    * Admin Password (to create Database if required): `root`

2. If the checklist shows that everything is ok, the application is ready. Otherwise, if an error about the impossibility to write the configuration is displayed, you need to copy the PHP code contained in the **Write configuration files** section and save it in a file named `config_inc.php`
    * Copy the file into the container under `/var/www/html/config` with the command `docker cp config_inc.php mantisbt-2254-mantisbt-1:/var/www/html/config`

3.  After the installation, change the administrator password to `e2eW3Bt3s71nGB3nchM4rK`

    


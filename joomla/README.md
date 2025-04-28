E2E Web Testing benchmark
=========================

Test suites for Joomla
----------------------

This directory contains test suites and Gherkin speficiations for Joomla. The Gherkin specifications refer to Joomla 3.10.11.

# Deployment instructions
A Docker image is available for both versions of the application (3.10.11 and 4.2.0).

## Deployment instructions for Joomla 3.10.11
The Docker containers for Joomla 3.10.11 can be created using the `docker-compose.yml` file contained in `joomla/baseline/joomla-3.10.11/docker-compose.yml`. Just move into the directory using a terminal and type:

```bash
docker compose up
```
The web application will be exposed on `localhost:8080`. After the containers are deployed, an installation wizard must be followed. Please refer to the further section **Installation instructions (only for Joomla 3.10.11)**

## Deployment instructions for Joomla 4.2.0
The Docker container for the application under test can be created using the following command:

```bash
docker run -i -t  --name=joomla -p "3000:80" -d olianasd/joomla4stile
```

The web application will be exposed on `localhost:3000`. 

# Installation instructions (only for Joomla 3.10.11)

The installation wizard can be executed automatically by running `utils.Installer` as a JUnit test. If, for any reason, the automatic installation fails, these are the parameters that you should set in the installation wizard:

*	Language: English (United States)
*	Site name: TestRigor joomla test
*	Email: saul@fake.com
*	Username: administrator
*	Password: e2eW3Bt3s71nGB3nchM4rK
* 	Database type: MySQLi
*	Host Name: joomladb
*	Username (database): root
* 	Password (database): example
*	Database name: joomla310
*	Install sample data: Blog English (GB) Sample Data
*	E-mail configuration: No
* 	Remove installation folder

After completing the installation wizard (either manually or automatically), you need to access to the administration area of the application (http://localhost:8080/administrator), login and close some notifications, that otherwise would change the expected layout of the page and make test scripts fail. In detail, you have to answer "Never" to the permission to collect statistics, and read all post installation messages. 


![First step](https://i.imgur.com/1e2D90G.png "Answer Never to the permission to collect statistics")

![Second step](https://i.imgur.com/wNhU1jN.png "Click Read messages")

![Third step](https://i.imgur.com/KtPDmyw.png "Click Hide all messages")
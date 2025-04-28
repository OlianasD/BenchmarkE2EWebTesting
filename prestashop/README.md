E2E Web Testing benchmark
=========================

Test suites for Prestashop
----------------------

This directory contains test suites and Gherkin speficiations for Prestashop. The Gherkin specifications refer to Prestashop 1.6.1.23.

# Deployment instructions
The Docker containers for the application under test can be created using the following commands:


```bash
#Prestashop 1.6.1.23
docker network create prestashop-net 
docker run -ti --name some-mysql --network prestashop-net -e MYSQL_ROOT_PASSWORD=admin -p 3307:3306 -d mysql:5.7
docker run -ti --name some-prestashop --network prestashop-net -e DB_SERVER=some-mysql -p 8080:80 -d prestashop/prestashop:1.6.1.23

#Prestashop 1.7.8.5
docker network create prestashop-net
docker run -ti --name some-mysql --network prestashop-net -e MYSQL_ROOT_PASSWORD=admin -p 3307:3306 -d mysql:5.7
docker run -ti --name some-prestashop --network prestashop-net -e DB_SERVER=some-mysql -p 8080:80 -d prestashop/prestashop:1.7.8.5
```


The web application will be exposed on `localhost:8080`. After the containers are deployed, an installation wizard must be followed

# Installation instructions (for both versions)
The installation wizard can be executed automatically by running `utils.Installer` as a JUnit test. If, for any reason, the automatic installation fails, these are the parameters that you should set in the installation wizard:

* Language: English (English)
* Shop name: E2E Web Testing store
* Main activity: Computer Hardware and Software
* First name: Dario
* Second name: Olianas
* E-mail address: admin@prestashop.com
* Password: e2eW3Bt3s71nGB3nchM4rK
* Database server address: some-mysql
* Database password: admin
* Click "Test your database connection now!", then "Attempt to create the database automatically"

After the installation is complete, you need to perform some manual post-installation steps from the command line. 
Open a shell to the container with the command

```bash
docker exec -it some-prestashop bash
```

then remove the `install` directory and rename the `admin` directory to `administrator`

```bash
rm -rf install
mv admin administrator
```

## Post-installation instructions (Prestashop 1.7.8.5 only)
After completing the installation wizard (either manually or automatically), you need to access to the administration area of the application (http://localhost:8080/administrator), login and close the onboarding tutorial, that otherwise would change the expected layout of the page and make test scripts fail. In detail, you have to follow the steps illustrated in the following screenshots.

![First step](https://i.imgur.com/Y6pWNCD.png "Click START")

![Second step](https://i.imgur.com/brMQLSo.png "Click Skip this tutorial")

![Third step](https://i.imgur.com/niqIwQA.png "Click Stop the onboarding")

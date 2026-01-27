E2E Web Testing benchmark
=========================

This repository contains a collection of 12 end-to-end (E2E) test suites for Web applications. All the test suites:

* are written in Java language
* use the Selenium WebDriver framework to interact with the Web application
* use JUnit as testing framework
* contain one test per class

We developed the test suites for 8 target applications, namely Bludit, Claroline, Expresscart, Joomla, Kanboard, MantisBT, Mediawiki and Prestashop. All the applications can be deployed in Docker containers: the installation instructions for each application are contained in its folder. For Bludit, Joomla, MantisBT and Prestashop the directory also contains the test suite for the second version of the application. The version of both applications is specified in the directory's name.

All test suites rely on the Selenium RemoteWebDriver, to allow the user to choose different versions of Web browsers with [docker-selenium](https://github.com/SeleniumHQ/docker-selenium). All the test suites have been checked for flakiness by running them 50 times, and are guaranteed to be free of flakiness if executed using Google Chrome 138. The browser container can be deployed using the command

```bash
docker run -d -p 4444:4444 -p 7900:7900 --shm-size="2g" --name=browser selenium/standalone-chrome:138.0-chromedriver-138.0
```

If you use this repository in your research work, please cite the following paper:

Dario Olianas, Maurizio Leotta, Filippo Ricca.
**BEWT: A Benchmark for End-to-End Web Testing.**
*Proceedings of 51st Euromicro Conference Series on Software Engineering and Advanced Applications* (**SEAA 2025**), 10-12 September 2025, Salerno, Italy, LNCS, Springer, 2025.

https://doi.org/10.1007/978-3-032-04207-1_20
E2E Web Testing benchmark
=========================

This repository contains a collection of 28 end-to-end (E2E) test suites for Web applications. All the test suites:

* are written in Java language
* use the Selenium WebDriver framework to interact with the Web application
* use JUnit as testing framework
* contain one test per class

We developed the test suites for 8 target applications, namely Bludit, Claroline, Expresscart, Joomla, Kanboard, MantisBT, Mediawiki and Prestashop. All the applications can be deployed in Docker containers: the installation instructions for each application are contained in its folder. For Bludit, Joomla, MantisBT and Prestashop the directory also contains the test suite for the second version of the application. The version of both applications is specified in the directory's name.
# RESTful API Automation Framework

This repository contains a Java-based RESTful API automation framework implemented using Java 11, TestNG, Maven, and Allure for reporting.

## Features

- Java-based framework for testing RESTful APIs.
- Utilizes TestNG for test case management and execution.
- Maven for dependency management and build automation.
- Allure for generating comprehensive and interactive test reports.

## Requirements

- Java Development Kit (JDK) 11 or higher
- Maven
- TestNG
- Allure Command Line Interface (CLI)

## Setup Instructions

1. Clone the repository to your local machine:
   ```bash
   git clone https://github.com/12345nagendra/restFulApiAutomationFramework.git
2. Checkout to master branch.
3. Install JDK 11 or higher if not already installed.
3. Install Maven if not already installed.
4. Install TestNG if not already installed (usually comes with popular IDEs like IntelliJ IDEA or Eclipse).
5. Install Allure Command Line Interface (CLI) for generating test reports

## Running Tests

To run the tests, navigate to the project directory and execute the following command:
```bash
  mvn clean test
```
This will execute all the test cases in the project.

## Viewing Test Reports

After running the tests, you can generate and view Allure test reports by executing the following command:
```bash
allure serve target/allure-results
```
This will start a local web server and open the Allure report in your default web browser.

## Project Structure

The project follows a standard Maven project structure:

```bash
restful-api-automation/
│
├── src/
│   ├── main/
│   │   └── java/
│   │       └── (main source code)
│   │
│   └── test/
│       └── java/
│           └── (test source code)
│
├── pom.xml
└── README.md
```
- src/main/java: Contains the main source code.
- src/test/java: Contains the test source code.
- pom.xml: Maven project configuration file.
- README.md: This file, containing project documentation.

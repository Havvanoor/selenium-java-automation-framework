# Selenium Java Automation Framework

## Overview

This project is a UI test automation framework built using Java, Selenium WebDriver, Maven, and TestNG.

The framework follows the Page Object Model (POM) design pattern and uses reusable methods, explicit waits, test data management, and assertions.

## Technologies

- Java
- Selenium WebDriver
- Maven
- TestNG
- Page Object Model (POM)
- Explicit Wait
- Git
- GitHub

## Project Structure

```text
src
├── main
│   └── java
│       ├── pages
│       └── utilities
│
└── test
    ├── java
    │   ├── base
    │   └── tests
    │
    └── resources


## Test Scenarios

### Login Tests

- Verify valid user can login successfully
- Verify locked user cannot login
- Verify error message is displayed for invalid login

### Cart Tests

- Add a product to the cart
- Verify product name
- Verify product quantity
- Verify product price

### Inventory Tests

- Verify products are displayed
- Verify expected product count
- Verify a specific product is available

## Framework Features

- Page Object Model
- Reusable page methods
- Explicit waits
- Test data management
- Assertions
- Maven test execution
- Independent test cases

## How to Run

Clone the repository and run the tests using Maven:

```bash
mvn test

## Future Improvements

- Add screenshot capture on test failure
- Add test reporting
- Add TestNG XML suite
- Add API testing
- Add AI-assisted test generation
- Add AI-powered test failure analysis
- Add AI-based visual testing
- Add CI/CD integration with GitHub Actions

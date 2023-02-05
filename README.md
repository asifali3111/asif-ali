# Sky Technical Test – API Automation

The aim of this test is to showcase your knowledge of working on an existing automation project.

We have recently built a Ruby-based API that needs testing.
The API is containerised within a Docker image and available at <https://reference-tryout-api.herokuapp.com/>. *Please contact immediately if you're not able to access this.*

Your mission is to test the API, find bugs and fix the Gauge automated tests so you could report back with your findings and the team will be aware of any issues.

Please try to complete as much as you can within `2-3 hours`, we're not looking for everything to be fully done.

The more interesting thing is seeing how you approach this, what your thought process is, how well you can interpret code.

## Setup

### Pre-requisites

Please make sure you have the following dependencies setup:

- Maven
- Java 8+
- Gauge - <https://docs.gauge.org/getting_started/installing-gauge.html>
  - Once Gauge is installed, the `java` and `html-report` plugins will also need to be installed. 
  - From cmd line/terminal run: `gauge install html-report java`

## Tasks

### `Part 1` - Explore the API documentation

Our developers have created a documentation for the API which can be accessed at `https://reference-tryout-api.herokuapp.com/` however, there are some issues with it.

- Create a new file `FINDINGS.md`.
- Explore the documentation for each available route, spot any issues and document what will need to be amended with a severity order.

### `Part 2` - Explore the API endpoints

Explore the API using your favourite API tool, be it `Postman`, `cURL` or `Insomnia`.

- Document your findings in the same file created earlier.

### `Part 3` - Setup Gauge Environment

If you haven't used Gauge before, we recommend reading the official documentation at `https://docs.gauge.org`.

- The project is built using Maven. Once you have `Gauge` and `Maven` installed on your machine, import the project into your favourite IDE `(IntelliJ/Eclipse)`.


To learn more about the `gauge-maven-plugin` refer to `https://github.com/getgauge-contrib/gauge-maven-plugin/blob/master/README.md`

#### How to Run the Tests

```sh
mvn clean test # will run all of the tests.
mvn gauge:execute -DspecsDir=specs -Dtags=made_up # will run tests with a tag `made_up`.
```

### `Part 4.1` - Gauge Tests

The testers have merged in some changes to the project and it's now failing to compile.

- Spot the issue and fix the compilation error

### `Part 4.2` - Implement incomplete step

The step `Assert against last updated time` in `InternalServerError.spec` doesn't have an implementation.
The step has been added to the assertions class but needs to be implemented, your task is to make this assert the time
from /last against the time a POST request was made.

You can run the command below so see the Scenario that needs to be completed.

```sh
mvn gauge:execute -DspecsDir=specs -Dtags=last # will run tests with a tag `last`.
```

### `Part 4.3` - Fix failing tests

The testers have worked on some API tests in Gauge Java however, they haven’t yet finished them and some are failing.
The scenarios are written in Gauge's spec files under the `specs/` directory.

Go through the specifications and help the testers by fixing broken tests.

* Is there anything that can be improved in the tests? Now is the time to make the tests shine! 

### `Part 5` - Improvements

How else would you test this API? Document your findings in the same file as above.

## Submission

Read the `SUBMISSION.md` file for instructions.

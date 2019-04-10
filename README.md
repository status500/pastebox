[![Build Status](https://travis-ci.com/status500/pastebox.svg?branch=master)](https://travis-ci.com/status500/pastebox) [![Coverage Status](https://coveralls.io/repos/github/status500/pastebox/badge.svg?branch=master)](https://coveralls.io/github/status500/pastebox?branch=master)

## Pastebox

Pastebox is Work-in-Progress web application for pasting and sharing code with syntax highlighting.

## Prerequisites

To build and run the project you will need:

  - [OpenJDK 8](https://adoptopenjdk.net/index.html "OpenJDK 8")
  - [Apache Maven 3.6.x](https://maven.apache.org/download.cgi "Apache Maven")

## Deployment

  - Execute ```mvn clean package``` from the root directory
  - Execute ```java -jar .\target\pastebox.jar```
  - Open http://localhost:8081/ in your browser
  - Press ```Ctrl + C``` to terminate it

## Development setup
  - Import the project in your preferred IDE as Maven project
  - Execute ```mvn spring-boot:run``` to start it with [spring-boot-devtools](https://docs.spring.io/spring-boot/docs/current/reference/html/using-boot-devtools.html "Spring Boot Devtools")  enabled to speed up the development work-flow

## Built With

* [Spring Boot](https://spring.io/projects/spring-boot) - The web framework
* [Maven](https://maven.apache.org/) - Dependency Management

## Contributing

The project is open for contributions

## License

This project is licensed under the BSD 3-clause Clear license

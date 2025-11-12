the-genealogy-api
=================

### The Genealogy Project application's backend.

<p>
  <img
    src="./images/logo.png"
    alt="The Genealogy Project logo"
    title="The Genealogy Project logo"
    width="200"
    height="170"
  />
</p>

[![Continuous integration](https://github.com/the-genealogy-project/the-genealogy-api/actions/workflows/build.yaml/badge.svg)](https://github.com/the-genealogy-project/the-genealogy-api/actions/workflows/build.yaml)

Prerequisites
-------------

To avoid any unexpected application behavior, make sure you have installed the following tools with the proper version
numbers:

- [Eclipse Temurin JDK 21](https://adoptium.net/temurin/releases/?version=21)
- [Maven 3.9.6](https://maven.apache.org/download.cgi)

Run project locally
-------------------

Be sure to copy `.env.example` to `.env` and update it with your local database connection parameters before running the
application.

### Build application

```bash
mvn clean install
```

### Starting application with Spring Boot Maven plugin

```bash
mvn spring-boot:run -Dspring-boot.run.profiles=dev
```

#### To view GraphQL queries and mutations, open [GraphiQL](http://localhost:8080/graphiql) in your web browser.

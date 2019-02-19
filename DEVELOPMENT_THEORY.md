# Development Theory

## Clean Architecture

Clean architecture is an application programming style intended to reduce the application's dependency on infrastructurural objects.

The purpose of this style is to reduce the coupling between the core business domain, the application layer, and finally the infrastructural layer(web server, script, lambda).

#### General rules:
- Reduce the direct dependency of our business code from the infrastructural code (logging, http, database clients, etc.).
- Design general classes with the API you want to consume. Write instances of these API that use either your hand-rolled solution, framework utility classes, or third-party libraries.

#### Links of interest:
- [Medium: PHP Software Architecture Part 2: The Alternatives](https://hackernoon.com/php-software-architecture-part-2-the-alternatives-1bd54e7f7b6d)
- [Medium: Clean Architecture with Java 11](https://medium.com/slalom-engineering/clean-architecture-with-java-11-f78bba431041)

## Domain Driven Design

Domain driven design is an opinionated application development theory and philopsophy which addresses the humanistic and technical aspects of program development and iteration.

DDD preaches

#### Domain:
- Data Transmission object
  - Read
  - Write
- Domain Service
- Aggregate object
- Value objects
- Application Service
- Event
  - Command
  - Query


#### Links of interest:
- [Medium: DDD 101 — The 5-Minute Tour](https://medium.com/the-coding-matrix/ddd-101-the-5-minute-tour-7a3037cf53b8ps://medium.com/slalom-engineering/clean-architecture-with-java-11-f78bba431041)

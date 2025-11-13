# Spring Data JDBC Immutables Sample

Small Spring Boot 3.3 project that demonstrates how to persist immutable aggregates with Spring Data JDBC.  
The domain models (`Order` and `OrderItem`) use final fields and value-type constructors, while Spring Data handles table creation via the supplied `schema.sql`.

## Features
- Immutable aggregate root (`Order`) backed by Spring Data JDBC repositories.
- Embedded collection (`OrderItem`) mapped with `@MappedCollection` to show one-to-many relationships.
- H2 in-memory database bootstrapped through `schema.sql`, so the application is ready to run with zero setup.
- Simple `CommandLineRunner` that writes a sample order and prints everything found in the repository at startup.

## Prerequisites
- Java 17+
- Maven 3.9+

## Running the app
```bash
mvn spring-boot:run
```
Expected output includes:
```
Saved order 1 for Alice
Order 1 for Alice
```
Spring stops automatically after the `CommandLineRunner` finishes.

## Useful Maven commands
- `mvn clean test` &mdash; run the unit tests (none are defined yet, but this ensures the build is sound).
- `mvn package` &mdash; build the executable JAR in `target/`.

## Project structure
```
src/main/java/com/example/immutables
 ├─ Application.java        # boots the demo runner
 ├─ domain/
 │   ├─ Order.java          # immutable aggregate root
 │   └─ OrderItem.java      # immutable owned entity
 └─ repository/
     └─ OrderRepository.java
src/main/resources/
 ├─ application.properties  # Spring Boot defaults
 └─ schema.sql              # H2 schema for orders + items
```

Feel free to expand the domain, add REST endpoints, or plug in a persistent database; the aggregate mapping already handles immutable entities, so the infrastructure work is minimal.

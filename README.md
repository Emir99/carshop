# SpringBoot-Hotel-REST-API
This is a REST API build with Spring Boot. For Db it uses Postgres. 
Its about making different car markets that sell different kind of cars.

# Tools
- For running it is required you to have:

- Maven as your build tool

- JDK 1.8+

- MySql


# Dependencies

- It is required you to have these dependencies:

- Spring Data JPA

- Postgres Drivers

- Spring WEB

# Configure the Database

- Create a database in Postgres
- Add credentials to `/src/main/resources/application.properties`.

```
spring.datasource.url=jdbc:postgresql://localhost:5432/postgres
spring.datasource.username= postgres
spring.datasource.password= 

spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.PostgreSQLDialect


spring.jpa.hibernate.ddl-auto = update
```

- Install the dependencies and run the application

# Endpoints

-For CarShop Entity

`http://localhost:9091/carshops` (GET) get all the shops.

`http://localhost:8080/carshop/{id}` (GET) to get a shop by id.

`http://localhost:8080/carshop (POST)` to create a new shop.

`http://localhost:8080/carshop/{id}` (DELETE) to delete an existing shop.

-For Car Entity

`http://localhost:9091/cars` (GET) get all the cars.

`http://localhost:8080/car/{id}` (GET) to get a car by id.

`http://localhost:8080/car/{carshop_id} (POST)` to create a new car and by giving the id you join it to the shop you want.

`http://localhost:8080/car/{id}` (DELETE) to delete an existing car.


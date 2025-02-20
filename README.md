# JAVA Request 2021
Send messages to Cassandra database.

## Table of contents
* [General info](#general-info)
* [Technologies](#technologies)
* [Swagger documentation](#swagger-documentation)
* [Setup](#setup)
* [Status](#status)
* [Contact](#contact)

## General info
App will allow all users to send messages to Cassandra database.
Messages can be found by entering email.
Messages can be deleted entering magic number.

## Technologies
* Spring Boot 2.4.2
* JAVA 13
* Apache Cassandra 3.11.10
* Swagger 3.0.0

## Swagger documentation
For Swagger documentation [see](http://localhost:8080/swagger-ui/)

## Setup 
You have to have Apache Cassandra installed on your computer.
Start Cassandra database and cqlsh.
Create keyspace named 'technicaltask'.
Create table named 'messages' and add columns as below

```
    CREATE TABLE messages(
        id text,
        email text,
        title text,
        content text,
        magicNumber int,
        PRIMARY KEY(id),
    );
```

Than run application using 

```
    mvn clean install
    java -jar target/slmarta-0.0.1-SNAPSHOT.jar
```

## Status
It works! :rocket:

## Contact
Created by [Marta Słysz](https://martaslysz.github.io/) for the purpose of recruitment process.
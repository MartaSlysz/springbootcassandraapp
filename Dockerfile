FROM openjdk:13-alpine
ARG JAR_FILE
ADD target/${JAR_FILE} app.jar
ENTRYPOINT docker-compose build && docker-compose up["java", "-jar", "app.jar"]
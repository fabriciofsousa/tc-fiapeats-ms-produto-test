FROM maven:3.9.8-eclipse-temurin-17 AS builder
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean install

FROM openjdk:17-jdk
WORKDIR /app
COPY --from=builder /app/target/fiapeats-0.0.1-SNAPSHOT.jar app.jar
CMD ["java", "-jar", "app.jar"]

FROM maven:3.9.8-eclipse-temurin-17 AS builder

WORKDIR /app

COPY pom.xml .

COPY src ./src

RUN VERSION=$(mvn help:evaluate -Dexpression=project.version -q -DforceStdout) && \
    echo "VERSION=$VERSION" > /app/version.txt && \
    mvn clean install

FROM openjdk:17-jdk

WORKDIR /app

ARG VERSION

COPY --from=builder /app/target/fiapeats-${VERSION}.jar app.jar

CMD ["java", "-jar", "app.jar"]

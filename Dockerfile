# Estágio de construção
FROM maven:3.9.8-eclipse-temurin-17 AS builder
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN VERSION=$(mvn help:evaluate -Dexpression=project.version -q -DforceStdout) && \
    echo "VERSION=$VERSION" > /app/version.txt && \
    mvn clean install

# Estágio final
FROM openjdk:17-jdk
WORKDIR /app
# Definir a variável de versão como argumento
ARG VERSION
# Copiar o JAR gerado para o container final
COPY --from=builder /app/target/fiapeats-${VERSION}.jar app.jar

CMD ["java", "-jar", "app.jar"]

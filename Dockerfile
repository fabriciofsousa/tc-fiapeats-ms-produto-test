# Estágio de construção
FROM maven:3.9.8-eclipse-temurin-17 AS builder
WORKDIR /app

# Copiar pom.xml e src para o container
COPY pom.xml .
COPY src ./src

# Obter a versão do pom.xml usando o Maven e configurar como variável de ambiente
RUN VERSION=$(mvn help:evaluate -Dexpression=project.version -q -DforceStdout) && \
    echo "VERSION=$VERSION" > /app/version.txt && \
    mvn clean install

# Estágio final
FROM openjdk:17-jdk
WORKDIR /app

# Definir argumento para a versão
ARG VERSION

# Copiar o JAR gerado para o container final
COPY --from=builder /app/target/fiapeats-${VERSION}.jar app.jar

# Comando para rodar o aplicativo
CMD ["java", "-jar", "app.jar"]

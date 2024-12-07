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
# Copiar a versão do arquivo version.txt
COPY --from=builder /app/version.txt /app/version.txt
# Usar o valor de VERSION extraído do arquivo version.txt
RUN VERSION=$(cat /app/version.txt)
# Copiar o JAR gerado para o container final, utilizando a variável de versão
COPY --from=builder /app/target/fiapeats-${VERSION}.jar app.jar

CMD ["java", "-jar", "app.jar"]

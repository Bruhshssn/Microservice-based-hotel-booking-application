FROM eclipse-temurin:21-jdk-ubi9-minimal

WORKDIR /app

COPY target/gateway-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 9090

ENTRYPOINT ["java", "-jar", "app.jar"]
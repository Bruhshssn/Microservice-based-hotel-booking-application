FROM eclipse-temurin:21-jdk-ubi9-minimal

WORKDIR /app

COPY target/hotelservice-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8082

ENTRYPOINT ["java", "-jar", "app.jar"]
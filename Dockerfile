FROM eclipse-temurin:21-jre
WORKDIR /app
COPY target/cat-service-2-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
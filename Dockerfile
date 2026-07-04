FROM eclipse-temurin:17
LABEL maintainer="ricardo_kohler@gmail.com"
WORKDIR /app
EXPOSE 8080
COPY target/locaveics-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]

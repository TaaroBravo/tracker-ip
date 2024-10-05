FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app

COPY target/tracipapi-0.0.2.jar /app/trackerapi.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "trackerapi.jar"]
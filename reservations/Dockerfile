#
# Build
#
FROM maven:3.6.0-jdk-11-slim AS build
COPY src /reservations/src
COPY pom.xml /reservations
RUN mvn -f /reservations/pom.xml clean package
#
# Package stage
#
FROM openjdk:11-jre-slim
COPY --from=build /reservations/target/reservations-0.0.1-SNAPSHOT.jar /usr/local/lib/reservations.jar
ENTRYPOINT ["java","-jar","/usr/local/lib/reservations.jar"]
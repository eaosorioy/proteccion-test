# Dockerfile
# Stage 1: Build the JAR using Gradle with JDK 21
FROM gradle:8.4.0-jdk21 AS builder

WORKDIR /app
COPY --chown=gradle:gradle . .

RUN gradle bootJar --no-daemon

# Stage 2: Run with OpenJDK 21 image
FROM openjdk:21-slim

WORKDIR /app
COPY --from=builder /app/build/libs/*.jar app.jar

ENTRYPOINT ["java","-jar","/app/app.jar"]

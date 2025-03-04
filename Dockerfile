# Use an official Maven image to build the project
FROM eclipse-temurin:21-jdk AS build

# Set working directory
WORKDIR /app

# Copy project files
COPY . .

# Build the application (skip tests for faster build)
RUN mvn clean package -DskipTests

# Use a lightweight JDK image for running the app
FROM openjdk:17-jdk-slim

# Set working directory
WORKDIR /app

# Copy the JAR file from the build stage
COPY --from=build /app/target/*.jar app.jar

# Expose the default Spring Boot port
EXPOSE 8080

# Run the Spring Boot application
CMD ["java", "-jar", "app.jar"]

# Use OpenJDK 21 as base image
FROM eclipse-temurin:21-jdk-jammy AS build

# Install Maven manually
RUN apt-get update && apt-get install -y maven

# Set working directory
WORKDIR /app

# Copy project files
COPY . .

# Verify Maven installation
RUN mvn -version

# Build the application
RUN mvn clean package -DskipTests

# Use a runtime image with Java 21
FROM eclipse-temurin:21-jdk-jammy

WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]

# Stage 1: Build the application
FROM maven:3.8.1-openjdk-11-slim AS build

# Set the working directory in the container
WORKDIR /app

# Copy the Maven configuration files
COPY pom.xml .

# Download dependencies and plugins, but do not run the build process yet
RUN mvn dependency:go-offline

# Copy the source code into the container
COPY src ./src

# Build the application
RUN mvn package -DskipTests

# Stage 2: Create the Docker image with the built application
FROM openjdk:11-jre-slim

# Set the working directory in the container
WORKDIR /app

# Copy the built JAR file from the first stage
COPY --from=build /app/target/ViraCamBackEnd-1.0-SNAPSHOT.jar ./app.jar

# Expose the port that the application runs on
EXPOSE 8080

# Command to run the application
CMD ["java", "-jar", "app.jar"]

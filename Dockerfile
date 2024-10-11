
# Stage 1: Build the application
FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app

# Copy the pom.xml and the source code into the Docker image
COPY pom.xml .
COPY src ./src

# Package the application
RUN mvn clean package -DskipTests

# Stage 2: Run the application
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app

# Copy the jar file from the previous stage
COPY --from=build /app/target/uploadvideo-1.jar uploadvideo-1.jar

# Expose port 8080 (or whatever port your application uses)
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "uploadvideo-1.jar"]

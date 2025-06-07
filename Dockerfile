# Use OpenJDK 17 as base image
FROM openjdk:17-jdk-slim

# Set working directory inside container
WORKDIR /app

# Copy jar file into container
COPY target/bookbase-0.0.1-SNAPSHOT.jar app.jar

# Expose the port (Render will dynamically inject PORT)
EXPOSE 8080

# Run the jar
ENTRYPOINT ["java", "-jar", "app.jar"]

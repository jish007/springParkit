# Use OpenJDK 16 as the base image
FROM openjdk:16

# Set the working directory inside the container
WORKDIR /carparkingadmin

# Copy the JAR file into the container (Make sure the JAR file exists in the target folder)
COPY target/fitness.project-0.0.1-SNAPSHOT.jar app.jar

# Expose port 9000
EXPOSE 9000

# Run the Spring Boot application
CMD ["java", "-jar", "app.jar"]
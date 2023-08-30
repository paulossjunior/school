# Use an official Maven image as the base image
FROM maven:3.8.4-openjdk-17-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the Maven project file and download dependencies
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy the application source code
COPY src ./src

# Build the application
RUN mvn package

# Expose the port that the application will run on
EXPOSE 8080

# Specify the command to run your application
CMD ["mvn", "spring-boot:run"]


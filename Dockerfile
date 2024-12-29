# Use Maven image to build the project
FROM maven:3.8.6-openjdk-17 AS build

# Set the working directory
WORKDIR /app

# Copy the pom.xml and download dependencies
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy the entire project
COPY . .

# Build the project and package it into a WAR file
RUN mvn clean install

# Use Tomcat image to run the application
FROM tomcat:10.1-jdk17-corretto

# Set the working directory for Tomcat
WORKDIR /usr/local/tomcat/webapps/

# Copy the WAR file from the previous build stage
COPY --from=build /app/target/prepquest-0.0.1-SNAPSHOT.war ./ROOT.war

# Expose the port on which the Tomcat server will run
EXPOSE 8080

# Run the Tomcat server
CMD ["catalina.sh", "run"]

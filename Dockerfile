# Use an official Tomcat base image
FROM tomcat:10.1-jdk17-corretto

# Set the working directory inside the container
WORKDIR /usr/local/tomcat/webapps/

# Copy the WAR file from the target folder into the Tomcat webapps directory
COPY target/prepquest-0.0.1-SNAPSHOT.war ./ROOT.war

# Expose the port on which the Tomcat server will run
EXPOSE 8080

# Start the Tomcat server
CMD ["catalina.sh", "run"]

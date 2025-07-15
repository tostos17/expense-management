# Use official Tomcat base image
FROM tomcat:10-jdk17-temurin

# Remove default webapps
RUN rm -rf /usr/local/tomcat/webapps/*

# Copy your WAR file into Tomcat webapps directory
COPY target/*.war /usr/local/tomcat/webapps/ROOT.war

# Expose port 8080
EXPOSE 8080

# Start Tomcat
CMD ["catalina.sh", "run"]
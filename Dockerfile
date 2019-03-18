#Dockerfile 
# Start with a base image containing Java runtime
FROM openjdk:8-jdk-alpine

# Add a volume pointing to /tmp
VOLUME /tmp

# The application's jar file
ARG JAR_FILE=target/springboot-demo-1.war

# Add the application's jar to the container
ADD ${JAR_FILE} springboot-demo-1.war

# Run the jar file 
ENTRYPOINT ["java","-jar","/springboot-demo-1.war"]


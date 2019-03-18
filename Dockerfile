#Dockerfile 
# Start with a base image containing Java runtime
FROM openjdk:8-jdk-alpine

# Add a volume pointing to /tmp
VOLUME /tmp

# The application's jar file
ARG JAR_FILE=target/springboot-demo.war

# Add the application's jar to the container
ADD ${JAR_FILE} springboot-demo.war

# Run the jar file 
ENTRYPOINT ["java","-jar","/springboot-demo.war"]


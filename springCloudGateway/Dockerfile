FROM openjdk:17
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} springcloudgateway.jar
ENTRYPOINT ["java","-jar","/springcloudgateway.jar"]
EXPOSE 8086

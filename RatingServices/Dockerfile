FROM openjdk:17
LABEL authors="utkarsh.agrawal"
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} userservice.jar
ENTRYPOINT ["java","-jar","/userservice.jar"]
EXPOSE 8084
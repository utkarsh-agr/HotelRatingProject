FROM openjdk:17
LABEL authors="utkarsh.agrawal"
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} configserver.jar
ENTRYPOINT ["java","-jar","/configserver.jar"]
EXPOSE 8087
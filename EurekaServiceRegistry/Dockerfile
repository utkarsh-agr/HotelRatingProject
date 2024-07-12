FROM openjdk:17-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ./target/EurekaServiceRegistry-0.0.1-SNAPSHOT.jar ServiceRegistry.jar
ENTRYPOINT ["java","-jar","/ServiceRegistry.jar"]
EXPOSE 8761

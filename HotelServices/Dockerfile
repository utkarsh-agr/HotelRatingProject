FROM openjdk:17
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} hotelservice.jar
ENTRYPOINT ["java","-jar","/hotelservice.jar"]
EXPOSE 8083

FROM openjdk:17-jdk-alpine
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} premier-scheduler.jar
ENTRYPOINT ["java","-jar","/premier-scheduler.jar"]

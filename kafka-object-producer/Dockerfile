FROM openjdk:21
LABEL authors="drodrigues17"

ARG JAR_FILE=build/libs/*jar
COPY ${JAR_FILE} app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
FROM openjdk:8-jdk-alpine
ADD target/*.jar card-service.jar
EXPOSE 10001
ENTRYPOINT ["java", "-jar", "card-service.jar"]
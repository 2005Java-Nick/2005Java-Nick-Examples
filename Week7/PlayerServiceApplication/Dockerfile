FROM openjdk:8-jdk-alpine
ADD target/*.jar player-service.jar
EXPOSE 10007
ENTRYPOINT ["java", "-jar", "player-service.jar"]
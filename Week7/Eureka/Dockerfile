FROM openjdk:8-jdk-alpine
ADD target/*.jar eureka.jar
EXPOSE 8761
ENTRYPOINT ["java", "-jar", "eureka.jar"]
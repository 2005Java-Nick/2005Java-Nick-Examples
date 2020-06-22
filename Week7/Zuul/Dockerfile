FROM openjdk:8-jdk-alpine
ADD target/*.jar zuul.jar
EXPOSE 10001
ENTRYPOINT ["java", "-jar", "zuul.jar"]
FROM eclipse-temurin:17-jdk-alpine
ADD target/spring-boot-test-0.0.1-SNAPSHOT.jar spring-boot-docker.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "spring-boot-docker.jar"]
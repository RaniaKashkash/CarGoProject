FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
ENV PORT 8082
EXPOSE 8082
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} car-microservice.jar
ENTRYPOINT ["java","-jar","/car-microservice.jar"]

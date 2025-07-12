FROM amazoncorretto:21
LABEL authors="akashchaudhary"

RUN mkdir app

COPY target/*.jar app/

EXPOSE 8080

ENTRYPOINT [ "java", "-jar", "app/greet-service.jar"]
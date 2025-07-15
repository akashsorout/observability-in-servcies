FROM amazoncorretto:21
LABEL authors="akashchaudhary"

RUN mkdir app

COPY target/*.jar app/

RUN curl -L "https://dtdg.co/latest-java-tracer" -o app/dd-java-agent.jar
RUN chmod a+r app/dd-java-agent.jar
ENV JAVA_TOOL_OPTIONS=-javaagent:app/dd-java-agent.jar


EXPOSE 8080

ENTRYPOINT [ "java", "-jar", "app/sample-service.jar"]
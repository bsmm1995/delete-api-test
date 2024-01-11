FROM openjdk:17
EXPOSE 8080
RUN mkdir -p /app/
ADD build/libs/*.jar /app/app.jar
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
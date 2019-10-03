FROM java:8-jre

ADD ["target/vts-vehicle-service-0.0.1.jar", "app.jar"]
EXPOSE 9091
RUN sh -c 'touch /app.jar'
HEALTHCHECK CMD curl -f http://localhost:9091/actuator/health || exit 1
ENTRYPOINT [ "sh", "-c", "java -Dspring.profiles.active=development -jar /app.jar" ]
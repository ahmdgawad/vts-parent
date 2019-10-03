FROM java:8-jre

ADD ["target/vts-configuration-server-0.0.1.jar", "app.jar"]
EXPOSE 5055
RUN sh -c 'touch /app.jar'
HEALTHCHECK CMD curl -f http://localhost:5055/actuator/health || exit 1
ENTRYPOINT [ "sh", "-c", "java -Dspring.profiles.active=development -jar /app.jar" ]
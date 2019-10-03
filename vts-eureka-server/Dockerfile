FROM java:8-jre

ADD ["target/vts-eureka-server-0.0.1.jar", "app.jar"]
EXPOSE 8761
RUN sh -c 'touch /app.jar'
HEALTHCHECK CMD curl -f http://localhost:8761/actuator/health || exit 1
ENTRYPOINT [ "sh", "-c", "java -Dspring.profiles.active=development -jar /app.jar" ]
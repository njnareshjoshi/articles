FROM java:8
VOLUME /tmp
ADD target/microservices-with-docker-0.0.1.jar app.jar
EXPOSE 8080
ENTRYPOINT exec java -Djava.security.egd=file:/dev/./urandom -jar /app.jar
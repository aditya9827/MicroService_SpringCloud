FROM openjdk:8
ADD target/docker_hello_world.jar docker_hello_world.jar
EXPOSE 8086
ENTRYPOINT ["java", "-jar", "docker_hello_world.jar"]
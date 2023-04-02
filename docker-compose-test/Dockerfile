FROM openjdk:11

COPY ./build/libs/docker-compose-test-0.0.1-SNAPSHOT.jar app.jar

ENV TZ=Asia/Seoul

CMD ["java", "-jar", "/app.jar"]

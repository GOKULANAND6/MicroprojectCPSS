FROM openjdk:18
WORKDIR /app
COPY ./target/store-0.0.1-SNAPSHOT.jar /app
EXPOSE 8030
CMD ["java", "-jar", "store-0.0.1-SNAPSHOT.jar"]
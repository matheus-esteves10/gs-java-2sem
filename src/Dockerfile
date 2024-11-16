FROM ubuntu:latest as BUILD

RUN apt-get update
RUN apt-get install openjdk-21-jdk -y

COPY . .

RUN apt-get install maven -y

RUN mvn clean install

FROM openjdk:21-jdk-slim

EXPOSE 8080

COPY --from=BUILD /target/gs-2sem-1.0-SNAPSHOT.war gs-2sem-1.0-SNAPSHOT.war

ENTRYPOINT ["java", "-jar", "gs-2sem-1.0-SNAPSHOT.war"]


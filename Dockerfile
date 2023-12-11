FROM maven:3-eclipse-temurin-17 as BUILD

COPY . /usr/src/app
RUN mvn --batch-mode -f /usr/src/app/pom.xml clean package

FROM eclipse-temurin:17-jre
ENV PORT 8087
EXPOSE 8087
COPY --from=BUILD /usr/src/app/target /opt/target
WORKDIR /opt/target

CMD ["/bin/bash", "-c", "find -type f -name '*-SNAPSHOT.jar' | xargs java -jar"]

##base image
##build
#FROM openjdk:8-jdk-alpine
#COPY src /home/app/src
#COPY pom.xml /home/app

#
#
#
#COPY --from=build /home/app/target/moonblog-server-0.0.1-SNAPSHOT.jar /usr/local/lib/demo.jar
#EXPOSE 8081
#ENTRYPOINT ["java", "-jar", "/app.jar"]
#

FROM openjdk:8-jdk-alpine
RUN mvn -f /home/app/pom.xml clean package
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
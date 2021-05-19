FROM openjdk:15
ENV JAR_FILE=/target/*.jar
COPY ${JAR_FILE} /myjar/app.jar
WORKDIR /myjar
ENTRYPOINT ["java","-jar","app.jar"]
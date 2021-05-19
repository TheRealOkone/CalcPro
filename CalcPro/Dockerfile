FROM openjdk:15
ENV JAR_FILE=*.jar
WORKDIR /myjar
COPY ${JAR_FILE} app.jar
ADD *.jar .
EXPOSE 8080
CMD ["ls", "-la"]
CMD ["java","-jar","app.jar"]


FROM openjdk:17
COPY target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["sh" ,"-c", "java -jar /app.jar"]
LABEL maintainer="Hardik Singh Behl" email="behl.hardiksingh@gmail.com"
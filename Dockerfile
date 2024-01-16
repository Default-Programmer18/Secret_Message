FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
COPY target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
EXPOSE 8080
ENV MONGODB_URI=mongodb+srv://sanghita1818:r0GNSqNfvAngvn5C@cluster0.dbwrmyw.mongodb.net/secmsgDb


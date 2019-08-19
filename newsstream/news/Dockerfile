FROM openjdk:11-jdk-slim
COPY target/news.jar /opt/news.jar
ENTRYPOINT ["java",  "-Djava.net.preferIPv4Stack=true",  "-jar","/opt/news.jar"]
EXPOSE 2025

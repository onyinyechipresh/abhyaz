#FROM maven:3.8.5-openjdk-17 AS build
#COPY . .
#RUN mvn clean package -DskipTests
#
#FROM openjdk:17.0.1-jdk-slim
#COPY --from=build /target/abhyaz-0.0.1-SNAPSHOT.jar abhyaz.jar
#EXPOSE 8080
#ENTRYPOINT ["java", "-jar", "abhyaz.jar"]

# Use the official PostgreSQL image as the base image
FROM postgres:latest AS postgres

# Create a custom PostgreSQL user and database
ENV POSTGRES_DB=mydb
ENV POSTGRES_USER=myuser
ENV POSTGRES_PASSWORD=mypassword

# Optionally, you can initialize the database with data by copying a SQL dump file
# COPY init.sql /docker-entrypoint-initdb.d/

# Build your Java application using Maven
FROM maven:3.8.5-openjdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests

# Use the OpenJDK image as the final base image
FROM openjdk:17.0.1-jdk-slim

# Copy the built JAR file from the build stage
COPY --from=build /target/abhyaz-0.0.1-SNAPSHOT.jar abhyaz.jar

# Expose the port your Java application will run on
EXPOSE 8080

# Define the command to run your Java application
ENTRYPOINT ["java", "-jar", "abhyaz.jar"]


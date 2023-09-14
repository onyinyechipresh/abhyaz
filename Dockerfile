#FROM maven:3.8.5-openjdk-17 AS build
#COPY . .
#RUN mvn clean package -DskipTests
#
#FROM openjdk:17.0.1-jdk-slim
#COPY --from=build /target/abhyaz-0.0.1-SNAPSHOT.jar abhyaz.jar
#EXPOSE 8080
#ENTRYPOINT ["java", "-jar", "abhyaz.jar"]

# Use Maven to build your application
FROM maven:3.8.5-openjdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests

# Use the official PostgreSQL Docker image
FROM postgres:13

# Create a Docker network for your containers to communicate
# This step is optional but recommended
# Create a Docker network for your containers to communicate
# This step is optional but recommended
RUN mkdir -p /docker-entrypoint-initdb.d
COPY init.sql /docker-entrypoint-initdb.d/

# Expose the PostgreSQL port (default is 5432)
EXPOSE 5432

# Specify environment variables for PostgreSQL (optional)
ENV POSTGRES_DB=mydatabase
ENV POSTGRES_USER=myuser
ENV POSTGRES_PASSWORD=mypassword

# Copy your built JAR file from the build stage
COPY --from=build /target/abhyaz-0.0.1-SNAPSHOT.jar /app/abhyaz.jar

# Expose the port your application listens on (8080 in your case)
EXPOSE 8080

# Set the entry point to run your application
ENTRYPOINT ["java", "-jar", "/app/abhyaz.jar"]

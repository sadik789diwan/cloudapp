# Stage 1: Build the application
FROM maven:3.9-eclipse-temurin-17 AS build
WORKDIR /cloudapp
# Copy pom.xml and source code
COPY pom.xml .
COPY src ./src
# Build the jar file
RUN mvn clean package -DskipTests

# Stage 2: Create the final lightweight image
FROM eclipse-temurin:17-jre
WORKDIR /cloudapp
# Copy only the built jar from the build stage
COPY --from=build /cloudapp/target/*.jar cloudapp.jar
# Expose the port your app runs on (usually 8080)
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "cloudapp.jar"]
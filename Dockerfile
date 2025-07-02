# ---------- STAGE 1: Build ----------
FROM maven:3.9.6-eclipse-temurin-17 AS build

WORKDIR /app
COPY pom.xml .
COPY src ./src

RUN mvn clean package -DskipTests

# ---------- STAGE 2: Runtime ----------
FROM eclipse-temurin:17-jre AS final

WORKDIR /app

# Copy only the final jar from stage 1
COPY --from=build /app/target/*.jar app.jar

# Default file type argument
ENTRYPOINT ["java", "-jar", "app.jar"]

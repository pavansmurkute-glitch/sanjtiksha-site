# Stage 1: build the jar with Maven
FROM maven:3.8.8-openjdk-17 AS builder
WORKDIR /app

# copy everything and build
COPY . /app
RUN mvn -B -DskipTests package

# Stage 2: runtime image (smaller)
FROM eclipse-temurin:17-jre-jammy
WORKDIR /app

# copy built jar from builder stage (first jar found in target)
COPY --from=builder /app/target/*.jar /app/app.jar

EXPOSE 8080
ENTRYPOINT ["java","-jar","/app/app.jar"]

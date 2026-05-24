FROM maven:3.9.9-eclipse-temurin-17 AS builder

WORKDIR /app

COPY ../ ./

RUN mvn clean package -DskipTests

FROM eclipse-temurin:17-jdk-jammy

WORKDIR /app

COPY --from=builder /app/target/*.jar app.jar

COPY docker/elastic-apm-agent.jar elastic-apm-agent.jar

EXPOSE 8080

ENV JAVA_OPTS="\
-Xms256m \
-Xmx512m \
-javaagent:/app/elastic-apm-agent.jar \
-Delastic.apm.service_name=springboot-observability-demo \
-Delastic.apm.server_urls=http://apm:8200 \
-Delastic.apm.environment=dev \
-Delastic.apm.application_packages=com.asps.graphqlcatalog \
"

ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]
# ==========================================================
# BUILD
# ==========================================================

FROM eclipse-temurin:21-jdk AS build

WORKDIR /app

COPY pom.xml .

COPY .mvn .mvn
COPY mvnw .
COPY mvnw.cmd .

RUN ./mvnw dependency:go-offline

COPY src src

RUN ./mvnw clean package -DskipTests


# ==========================================================
# EXTRAÇÃO DAS LAYERS
# ==========================================================

FROM eclipse-temurin:21-jre AS extracted

WORKDIR /app

COPY --from=build /app/target/*.jar application.jar

RUN java -Djarmode=tools -jar application.jar extract \
    --layers \
    --destination extracted


# ==========================================================
# IMAGEM FINAL
# ==========================================================

FROM eclipse-temurin:21-jre

WORKDIR /app

COPY --from=extracted /app/extracted/dependencies/ ./
COPY --from=extracted /app/extracted/spring-boot-loader/ ./
COPY --from=extracted /app/extracted/snapshot-dependencies/ ./
COPY --from=extracted /app/extracted/application/ ./

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "application.jar"]
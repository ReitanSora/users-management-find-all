FROM gradle:8.7-jdk17 AS build

WORKDIR /home/gradle/src

COPY . .

RUN gradle assemble --no-daemon -x test

FROM eclipse-temurin:17-jre-alpine

WORKDIR /app

RUN addgroup -S appgroup && adduser -S appuser -G appgroup
USER appuser

EXPOSE 8080

COPY --from=build /home/gradle/src/build/libs/users-management-find-all-0.0.1-SNAPSHOT.jar ./users-management-find-all.jar

HEALTHCHECK --interval=30s --timeout=5s --start-period=30s \
  CMD wget --quiet --tries=1 --spider http://localhost:8080/actuator/health || exit 1

ENTRYPOINT ["java", "-Xms256m","-Xmx512m", "-jar", "/app/users-management-find-all.jar"]

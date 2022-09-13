ARG JDK_VERSION=17.0.4.1_1

FROM eclipse-temurin:${JDK_VERSION}-jdk-alpine AS faculties-service-builder

WORKDIR /home/src

COPY --chown=user:user faculties /home/src

RUN ./gradlew --warning-mode all build
RUN ./gradlew --warning-mode all jar

FROM eclipse-temurin:${JDK_VERSION}-jre-alpine AS faculties-service-image

COPY --from=faculties-service-builder --chown=user:user \
        /home/src/build/libs/faculties-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java","-jar","app.jar"]

FROM adoptopenjdk:11-jre-hotspot as builder
WORKDIR extracted
ADD ./target/*.jar app.jar
RUN java -Djarmode=layertools -jar app.jar extract

FROM adoptopenjdk:11-jre-hotspot
WORKDIR application
COPY --from=builder extracted/dependencies/ ./
COPY --from=builder extracted/spring-boot-loader/ ./
COPY --from=builder extracted/snapshot-dependencies/ ./
COPY --from=builder extracted/application/ ./
VOLUME /tmp
EXPOSE 8080
ENV TZ America/Santiago
ENTRYPOINT ["java", "org.springframework.boot.loader.JarLauncher"]
FROM amazoncorretto:21 AS builder

# Setup required env variables
ENV JAVA_HOME=/usr/lib/jvm/java-21-amazon-corretto \
    PATH=$PATH:$JAVA_HOME/bin

WORKDIR /app

# Copy only the jar file from the build context
COPY target/fluxnova-springboot-example-*.jar fluxnova.jar

# Final minimal image
FROM amazoncorretto:21

WORKDIR /fluxnova

# Create user and provide access to fluxnova folder
RUN groupadd -g 4001 fluxnova_group && adduser -G fluxnova_group -u 4001 -m -d /fluxnova fluxnova_user

# Copy jar and script
COPY --from=builder /app/fluxnova.jar fluxnova.jar
COPY fluxnova-springboot-example/docker-script.sh docker-script.sh

RUN chown -R fluxnova_user:fluxnova_group /fluxnova

EXPOSE 8080

USER 4001

ENTRYPOINT ["sh", "docker-script.sh"]

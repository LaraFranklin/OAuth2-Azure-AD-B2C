FROM openjdk:11.0

WORKDIR /app

COPY ./.mvn ./.mvn
COPY ./mvnw .
COPY ./pom.xml .

RUN ./mvnw clean package -Dmaven.test.skip -Dmaven.main.skip -Dspring-boot.repackage.skip

COPY ./src ./src

RUN ./mvnw clean package

ENTRYPOINT ["java", "-jar", "app.jar"]
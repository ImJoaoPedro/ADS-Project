FROM adoptopenjdk/openjdk15:ubi
COPY ./out/artifacts/Factory/ADS-Project.jar /usr/app/
WORKDIR /usr/app
EXPOSE 4445
CMD ["java", "-jar", "ADS-Project.jar"]

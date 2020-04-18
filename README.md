# Weather API

Simple weather API written using Java 11 and Spring Boot.

## Instructions

Add your [OpenWeather](https://openweathermap.org/api) api key to `src/main/resources/application.properties`.

Start the application:

```bash
mvn spring-boot:run
```

By default the application runs on port 8080.

```bash
curl http://localhost:8080/api/weather/current\?location\=frankfurt

curl http://localhost:8080/api/weather/forecast\?location\=frankfurt
```
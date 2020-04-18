package com.inheaden.weatherforecast.models;

import java.util.List;
import lombok.Data;

@Data
public class OpenWeatherCurrent {
    private Main main;
    private List<Weather> weather;

    @Data
    public static class Main {
        private float temp;
        private float pressure;
    }

    @Data
    public static class Weather {
        private String main;
        private String description;
    }
}

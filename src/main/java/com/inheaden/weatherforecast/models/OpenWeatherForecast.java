package com.inheaden.weatherforecast.models;

import java.util.List;
import lombok.Data;

@Data
public class OpenWeatherForecast {
    private List<OpenWeatherCurrent> list;
}

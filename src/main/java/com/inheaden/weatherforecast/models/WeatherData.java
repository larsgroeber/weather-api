package com.inheaden.weatherforecast.models;

import lombok.Data;

@Data
public class WeatherData {
    private float temperature;
    private String weatherInfo;

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public String getWeatherInfo() {
        return weatherInfo;
    }

    public void setWeatherInfo(String weatherInfo) {
        this.weatherInfo = weatherInfo;
    }
}

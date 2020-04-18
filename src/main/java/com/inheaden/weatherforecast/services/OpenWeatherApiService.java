package com.inheaden.weatherforecast.services;

import com.inheaden.weatherforecast.models.OpenWeatherCurrent;
import com.inheaden.weatherforecast.models.OpenWeatherForecast;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OpenWeatherApiService {

    private final RestTemplate restTemplate;

    private final String apiUrl = "http://api.openweathermap.org/data/2.5";
    @Value("${openweather.apiKey}")
    private String apiKey;

    public OpenWeatherApiService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public OpenWeatherCurrent getCurrentWeather(String location) {
        var weather = restTemplate
                .getForEntity(String.format("%s/weather?q=%s&appid=%s", apiUrl, location, apiKey),
                        OpenWeatherCurrent.class);

        return weather.getBody();
    }

    public List<OpenWeatherCurrent> getWeatherForecast(String location) {
        var weather = restTemplate
                .getForEntity(String.format("%s/forecast/daily?q=%s&cnt=6&appid=%s", apiUrl, location, apiKey),
                        OpenWeatherForecast.class);

        return weather.getBody().getList();
    }
}

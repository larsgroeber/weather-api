package com.inheaden.weatherforecast.api;

import com.inheaden.weatherforecast.models.OpenWeatherCurrent;
import com.inheaden.weatherforecast.models.WeatherData;
import com.inheaden.weatherforecast.services.OpenWeatherApiService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/weather")
public class WeatherApiController {
    private final OpenWeatherApiService openWeatherApiService;

    public WeatherApiController(
            OpenWeatherApiService openWeatherApiService) {
        this.openWeatherApiService = openWeatherApiService;
    }

    @GetMapping("current")
    public ResponseEntity<WeatherData> getCurrentWeather(@RequestParam String location) {
        var currentWeather = openWeatherApiService.getCurrentWeather(location);

        WeatherData weather = convert(currentWeather);

        return ResponseEntity.ok(weather);
    }

    private WeatherData convert(OpenWeatherCurrent currentWeather) {
        var weather = new WeatherData();
        weather.setTemperature(currentWeather.getMain().getTemp());
        weather.setWeatherInfo(currentWeather.getWeather().get(0).getDescription());
        return weather;
    }

    @GetMapping("forecast")
    public ResponseEntity<List<WeatherData>> getWeatherForecast(@RequestParam String location) {
        var currentWeather = openWeatherApiService.getWeatherForecast(location);

        var result = currentWeather.stream().map(this::convert).collect(Collectors.toList());

        return ResponseEntity.ok(result);
    }
}

package com.example.weather.controller;

import com.example.weather.model.Main;
import com.example.weather.model.Root;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class WeatherController {
    private static final Logger logger = LoggerFactory.getLogger(WeatherController.class);
    @Autowired
    private RestTemplate restTemplate;
    @Value("${appid}")
    private String appId;
    @Value("${url.weather}")
    private String urlWeather;

    @GetMapping("/weather")
    @Cacheable(value = "weather", key = "#lat + ',' + #lon")
    public Root getWeather(@RequestParam String lat, @RequestParam String lon) {
        logger.info("Получение данных через API для lat={}, lon={}", lat, lon);
        String request = String.format("%s?lat=%s&lon=%s&units=metric&appid=%s", urlWeather, lat, lon, appId);
        return restTemplate.getForObject(request, Root.class);
    }
}

package com.example.weather.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class WeatherController {
    private static String API_key = "a6fe32336cb0d5da788e58f9f5a4d146";
    private static String API_url = "https://api.openweathermap.org/data/3.0/onecall";

    @GetMapping("/weather")
    public String getWeather(@RequestParam("lat") double latitude, @RequestParam("lon") double longitude) {
        String url = API_url + "?lat=" + latitude + "&lon=" + longitude + "&appid=" + API_key;

        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(url, String.class);

        return response;
    }

}

package com.example.location.controller;

import com.example.location.model.Geodata;
import com.example.location.model.Weather;
import com.example.location.repository.GeodataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@RestController("/location")
public class LocationController {

    @Autowired
    private GeodataRepository repository;
    private RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/location")
    public Iterable<Geodata> getAllLocations() {
        return repository.findAll();
    }

    @GetMapping("/location/")
    public Optional<Geodata> getLocation(@RequestParam("name") String location) {
        return repository.findByName(location);
    }

    @PostMapping("/location")
    public Geodata save(@RequestBody Geodata geodata) {
        return repository.save(geodata);
    }

    @PutMapping("/location/")
    public Geodata updateLocation(@RequestParam("name") String location, @RequestBody Geodata updatedData) {
        Geodata geodata = repository.findByName(location).orElseThrow(() -> new RuntimeException("Location not found"));
        geodata.setName(updatedData.getName());
        geodata.setLatitude(updatedData.getLatitude());
        geodata.setLongitude(updatedData.getLongitude());
        return repository.save(geodata);
    }

    @DeleteMapping("/location/")
    public void deleteLocation(@RequestParam("name") String location) {
        Geodata geodata = repository.findByName(location).orElseThrow(() -> new RuntimeException("Location not found"));
        repository.delete(geodata);
    }

    @GetMapping("/location/weather")
    public Weather redirectRequestWeather(@RequestParam("name") String location) {
        Geodata geodata = repository.findByName(location).orElseThrow(() -> new RuntimeException("Location not found"));
        String url = String.format("http://localhost:8082/weather?lat=%s&lon=%s", geodata.getLatitude(), geodata.getLongitude());
        return restTemplate.getForObject(url, Weather.class);
    }




}

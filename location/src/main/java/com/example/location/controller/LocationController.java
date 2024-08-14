package com.example.location.controller;

import com.example.location.model.Geodata;
import com.example.location.model.Weather;
import com.example.location.repository.GeodataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@RestController("/location")
public class LocationController {

    @Autowired
    private GeodataRepository repository;
    @Autowired
    private RestTemplate restTemplate;
    @Value("${weather.url}")
    String weatherUrl;

    @GetMapping("/location/weather")
    public ResponseEntity<Weather> redirectRequestWeather(@RequestParam("name") String location) {
        Optional<Geodata> optGeodata = repository.findByName(location);
        if (optGeodata.isPresent()) {
            Geodata geodata = optGeodata.get();
            String url = String.format(weatherUrl + "weather?lat=%s&lon=%s", geodata.getLatitude(), geodata.getLongitude());

            ResponseEntity<Weather> response = restTemplate.getForEntity(url, Weather.class);

            if (response.getBody() != null) {
                return response;
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/location")
    public Iterable<Geodata> getAllLocations() {
        return repository.findAll();
    }

    @GetMapping("/location/")
    public Optional<Geodata> getLocation(@RequestParam("name") String location) {
        return repository.findByName(location);
    }

    @PostMapping("/location")
    public ResponseEntity<Geodata> save(@RequestBody Geodata geodata) {
        return repository.findByName(geodata.getName()).isPresent()
                ? new ResponseEntity<>(repository.findByName(geodata.getName()).get(), HttpStatus.BAD_REQUEST)
                : new ResponseEntity<>(repository.save(geodata), HttpStatus.CREATED);
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


}

package com.example.location.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Location {
    @Id @GeneratedValue
    private int id;
    @NonNull private double longitude;
    @NonNull private double latitude;
    @NonNull private String name;

    public Location(@NonNull double longitude, @NonNull double latitude, @NonNull String name) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.name = name;
    }
}

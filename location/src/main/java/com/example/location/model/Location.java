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
    @NonNull private String locationName;
    @NonNull private double latitude;
    @NonNull private double longitude;

    public Location(@NonNull String locationName, @NonNull double latitude, @NonNull double longitude) {
        this.locationName = locationName;
        this.latitude = latitude;
        this.longitude = longitude;
    }
}

package com.carbonos.backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "carbon_activity")
public class CarbonActivity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String activityType;
    private String fuelType;

    @Column(name = "activity_value")
    private double activityValue;

    private double emission;

    public Long getId() {
        return id;
    }

    public String getActivityType() {
        return activityType;
    }

    public void setActivityType(String activityType) {
        this.activityType = activityType;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public double getActivityValue() {
        return activityValue;
    }

    public void setActivityValue(double activityValue) {
        this.activityValue = activityValue;
    }

    public double getEmission() {
        return emission;
    }

    public void setEmission(double emission) {
        this.emission = emission;
    }
}

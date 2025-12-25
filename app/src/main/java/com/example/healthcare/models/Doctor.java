package com.example.healthcare.models;

public class Doctor {
    private String name;
    private String specialty;
    private String rating;
    private String distance;

    public Doctor() {
        // Пустой конструктор
    }

    // Конструктор для String
    public Doctor(String name, String specialty, String rating, String distance) {
        this.name = name;
        this.specialty = specialty;
        this.rating = rating;
        this.distance = distance;
    }

    // Геттеры с проверкой на null
    public String getName() {
        return name != null ? name : "";
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialty() {
        return specialty != null ? specialty : "";
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getRating() {
        return rating != null ? rating : "";
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getDistance() {
        return distance != null ? distance : "";
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }
}
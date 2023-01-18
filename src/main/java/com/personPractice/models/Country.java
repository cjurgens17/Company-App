package com.personPractice.models;

import jakarta.persistence.*;

@Entity
@Table(name = "countries")
public class Country extends BaseEntity {


    private String countryName;
    @OneToOne
    private Location location;

    @OneToOne
    private Region region;

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }
}

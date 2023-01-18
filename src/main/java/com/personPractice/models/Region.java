package com.personPractice.models;

import jakarta.persistence.*;

@Entity
@Table(name = "regions")
public class Region extends BaseEntity{

    private String regionName;

    @OneToOne
    private Country country;

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}

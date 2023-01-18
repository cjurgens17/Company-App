package com.personPractice.models;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "countries")
public class Country extends BaseEntity {

    @Column(name = "country_name")
    private String countryName;

    @OneToOne
    private Location location;

    @OneToOne
    private Region region;
}

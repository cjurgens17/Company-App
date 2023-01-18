package com.personPractice.models;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "regions")
public class Region extends BaseEntity{

    @Column(name = "region_name")
    private String regionName;

    @OneToOne
    private Country country;
}

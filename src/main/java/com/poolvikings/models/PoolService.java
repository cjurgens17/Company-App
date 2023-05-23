package com.poolvikings.models;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="services")
public class PoolService extends BaseEntity{

    @Column(name="image")
    private String image;

    @Column(name="description")
    @Lob
    private String description;

    @Column(name="title")
    private String title;

    @Column(name="contact")
    @Lob
    private String contact;


}

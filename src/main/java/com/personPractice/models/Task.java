package com.personPractice.models;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "tasks")
public class Task extends BaseEntity{

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    @Lob
    private String description;
}

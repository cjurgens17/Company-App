package com.personPractice.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "jobs")
public class Job extends BaseEntity{

    @Column(name = "job_title")
    private String jobTitle;

    @Column(name = "min_salary")
    private Long minSalary;

    @Column(name = "max_salary")
    private Long maxSalary;


    @OneToMany(cascade = CascadeType.ALL)
    private Set<Task> tasks = new HashSet<>();

    @OneToOne
    private Employee employee;
}

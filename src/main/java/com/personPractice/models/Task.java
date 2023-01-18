package com.personPractice.models;

import jakarta.persistence.*;

@Entity
@Table(name = "tasks")
public class Task extends BaseEntity{

    private String title;

    @Lob
    private String description;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

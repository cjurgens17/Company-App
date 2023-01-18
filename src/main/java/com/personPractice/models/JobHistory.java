package com.personPractice.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Embeddable
public class JobHistory {

    private Date startDate;
    private Date endDate;
}

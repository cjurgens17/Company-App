package com.personPractice.models;

import jakarta.persistence.*;

import java.util.Date;
@Embeddable
public class JobHistory {

    private Date startDate;
    private Date endDate;



    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

}

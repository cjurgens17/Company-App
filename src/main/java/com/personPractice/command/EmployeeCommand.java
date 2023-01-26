package com.personPractice.command;

import com.personPractice.models.Department;
import com.personPractice.models.Job;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class EmployeeCommand extends BaseEntityCommand{
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private Date hireDate;
    private Long salary;
    private Long commissionPct;
    private Department department;
    private Job job;
}

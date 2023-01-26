package com.personPractice.command;


import com.personPractice.models.Employee;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class JobCommand {
    private String jobTitle;
    private Long minSalary;
    private Long maxSalary;
    private Set<TaskCommand> tasks = new HashSet<>();
    private Employee employee;
}

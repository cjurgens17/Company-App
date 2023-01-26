package com.personPractice.command;


import com.personPractice.models.Location;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class DepartmentCommand {
    private String departmentName;
    private Set<EmployeeCommand> employees = new HashSet<>();
    private Location location;
}

package com.personPractice.services;


import com.personPractice.models.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;


public interface EmployeeService {

    List<Employee> getEmployees();
}

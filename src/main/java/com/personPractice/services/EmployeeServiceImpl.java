package com.personPractice.services;

import com.personPractice.models.Employee;
import com.personPractice.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeServiceImpl  implements EmployeeService{

   private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> getEmployees() {

        List<Employee> employeeList = new ArrayList<>();

        employeeRepository.findAll().iterator().forEachRemaining(employeeList::add);
        employeeList.sort(Comparator.comparing(Employee::getId));

        return employeeList;
    }

}

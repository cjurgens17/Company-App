package com.personPractice.services;

import com.personPractice.exceptions.NotFoundException;
import com.personPractice.models.Employee;
import com.personPractice.models.Job;
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

    @Override
    public Set<Employee> findAll() {

        Set<Employee> employees = new HashSet<>();

        employeeRepository.findAll().forEach(employees::add);

        return employees;
    }

    @Override
    public Employee findById(Long aLong) {

        if(employeeRepository.findById(aLong).isEmpty()){
            throw new NotFoundException("Employee Not Found For ID value: " + aLong);
        }
        return employeeRepository.findById(aLong).orElse(null);
    }

    @Override
    public Employee save(Employee object) {
        return employeeRepository.save(object);
    }

    @Override
    public void delete(Employee object) {
        employeeRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        employeeRepository.deleteById(aLong);
    }


}

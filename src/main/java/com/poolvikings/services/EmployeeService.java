package com.poolvikings.services;


import com.poolvikings.models.Employee;

import java.util.List;


public interface EmployeeService extends CrudService<Employee,Long>{

    List<Employee> getEmployees();

}

package com.personPractice.services;

import com.personPractice.models.Department;

import java.util.List;

public interface DepartmentService extends CrudService<Department, Long>{

    List<Department> getDepartments();
}

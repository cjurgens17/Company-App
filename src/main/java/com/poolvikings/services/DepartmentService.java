package com.poolvikings.services;

import com.poolvikings.models.Department;

import java.util.List;

public interface DepartmentService extends CrudService<Department, Long>{

    List<Department> getDepartments();
}

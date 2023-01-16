package com.personPractice.services;

import com.personPractice.models.Department;
import com.personPractice.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    private final DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public List<Department> getDepartments() {

        List<Department> departments = new ArrayList<>();

        departmentRepository.findAll().iterator().forEachRemaining(departments::add);
        departments.sort(Comparator.comparing(Department::getId));

        return departments;

    }
}

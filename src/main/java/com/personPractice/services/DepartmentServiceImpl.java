package com.personPractice.services;

import com.personPractice.models.Department;
import com.personPractice.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.*;

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

    @Override
    public Set<Department> findAll() {

        Set<Department> departments = new HashSet<>();

        departmentRepository.findAll().forEach(departments::add);

        return departments;
    }

    @Override
    public Department findById(Long aLong) {
        return departmentRepository.findById(aLong).orElse(null);
    }

    @Override
    public Department save(Department object) {
        return departmentRepository.save(object);
    }

    @Override
    public void delete(Department object) {
            departmentRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        departmentRepository.deleteById(aLong);
    }
}

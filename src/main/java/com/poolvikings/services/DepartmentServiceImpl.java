package com.poolvikings.services;

import com.poolvikings.exceptions.NotFoundException;
import com.poolvikings.models.Department;
import com.poolvikings.repository.DepartmentRepository;
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
        if(departmentRepository.findById(aLong).isEmpty()){
            throw new NotFoundException("Department Not Found For ID value: " + aLong);
        }
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

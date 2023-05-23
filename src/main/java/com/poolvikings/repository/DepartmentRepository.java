package com.poolvikings.repository;

import com.poolvikings.models.Department;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface DepartmentRepository extends CrudRepository<Department,Long> {

    Optional<Department> findByDepartmentName(String departmentName);
}

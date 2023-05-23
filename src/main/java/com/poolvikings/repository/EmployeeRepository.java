package com.poolvikings.repository;

import com.poolvikings.models.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

    Optional<Employee> findByFirstName(String firstName);
}

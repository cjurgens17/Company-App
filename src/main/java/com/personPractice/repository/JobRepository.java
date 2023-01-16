package com.personPractice.repository;

import com.personPractice.models.Job;
import org.springframework.data.repository.CrudRepository;

public interface JobRepository extends CrudRepository<Job,Long> {

}

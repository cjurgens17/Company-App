package com.poolvikings.repository;

import com.poolvikings.models.Job;
import org.springframework.data.repository.CrudRepository;

public interface JobRepository extends CrudRepository<Job,Long> {

}

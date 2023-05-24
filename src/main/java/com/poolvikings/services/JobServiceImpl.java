package com.poolvikings.services;

import com.poolvikings.exceptions.NotFoundException;
import com.poolvikings.models.Job;
import com.poolvikings.repository.JobRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class JobServiceImpl implements JobService{

    private final JobRepository jobRepository;

    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public Set<Job> findAll() {
        Set<Job> jobs = new HashSet<>();

        jobRepository.findAll().forEach(jobs::add);

        return jobs;
    }

    @Override
    public Job findById(Long aLong) {
        jobRepository.findById(aLong);
        return jobRepository.findById(aLong).orElse(null);
    }

    @Override
    public Job save(Job object) {
        return jobRepository.save(object);
    }

    @Override
    public void delete(Job object) {
    jobRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
    jobRepository.deleteById(aLong);
    }
}

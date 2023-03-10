package com.personPractice.services;

import com.personPractice.exceptions.NotFoundException;
import com.personPractice.models.Job;
import com.personPractice.repository.JobRepository;
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
        if(jobRepository.findById(aLong).isEmpty()){
            throw new NotFoundException("Job Not Found For ID value: " + aLong);
        }
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

package com.personPractice.services;

import com.personPractice.exceptions.NotFoundException;
import com.personPractice.models.PoolService;
import com.personPractice.repository.PoolServiceRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class PoolServiceServiceImpl implements PoolServiceService {

    private final PoolServiceRepository poolServiceRepository;

    public PoolServiceServiceImpl(PoolServiceRepository serviceRepository) {
        this.poolServiceRepository = serviceRepository;
    }



    @Override
    public Set<PoolService> findAll() {
        Set<PoolService> services = new HashSet<>();
        poolServiceRepository.findAll().forEach(services::add);
        return services;
    }

    @Override
    public PoolService findById(Long aLong) {
        if(poolServiceRepository.findById(aLong).isEmpty()){
            throw new NotFoundException("Service Not Found For ID value: " + aLong);
        }
        return poolServiceRepository.findById(aLong).orElse(null);
    }

    @Override
    public PoolService save(PoolService object) {
        return poolServiceRepository.save(object);
    }

    @Override
    public void delete(PoolService object) {
        poolServiceRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        poolServiceRepository.deleteById(aLong);
    }
}

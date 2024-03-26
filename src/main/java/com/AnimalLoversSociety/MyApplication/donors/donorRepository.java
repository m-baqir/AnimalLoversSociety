package com.AnimalLoversSociety.MyApplication.donors;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface donorRepository extends CrudRepository<donor, Integer> {
}

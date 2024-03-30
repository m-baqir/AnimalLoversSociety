package com.AnimalLoversSociety.MyApplication.donors;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface donorRepository extends JpaRepository<donor, Integer>  {
}

package com.AnimalLoversSociety.MyApplication.donors;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface donorRepository extends JpaRepository<donor, Integer>  {
    @Query
    List<donor> findByName(String name);
}

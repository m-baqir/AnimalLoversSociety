package com.AnimalLoversSociety.MyApplication.seminars;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeminarRepository extends JpaRepository<Seminar, Integer> {
    @Query
    List<Seminar> findByTitle(String title);
}

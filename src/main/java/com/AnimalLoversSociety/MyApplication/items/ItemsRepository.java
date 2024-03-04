package com.AnimalLoversSociety.MyApplication.items;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * not really sure exactly what this does, but it's important
 */

@Repository
@Transactional
public interface ItemsRepository extends CrudRepository<Items, Long> {
}

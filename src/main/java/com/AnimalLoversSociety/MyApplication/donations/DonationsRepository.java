package com.AnimalLoversSociety.MyApplication.donations;

import com.AnimalLoversSociety.MyApplication.items.Items;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public interface DonationsRepository extends CrudRepository<Donations, Long> {
}

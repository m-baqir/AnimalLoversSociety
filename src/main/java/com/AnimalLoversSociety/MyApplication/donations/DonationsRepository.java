package com.AnimalLoversSociety.MyApplication.donations;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface DonationsRepository extends JpaRepository<Donations, Integer>  {
    @Query
    List<Donations> findByDonationID(long id);
}

package com.soa_.ManageFootballStadium.repository;

import com.soa_.ManageFootballStadium.model.Stadium;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StadiumRepository extends CrudRepository<Stadium, Long> {
    List<Stadium> findByNameContaining(String name);
}

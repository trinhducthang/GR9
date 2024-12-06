package com.soa_.ManageFootballStadium.repository;

import com.soa_.ManageFootballStadium.model.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    Page<Review> findByStadiumId(Long stadiumId, Pageable pageable);
    Review findByStadiumId(Long stadiumId);
}

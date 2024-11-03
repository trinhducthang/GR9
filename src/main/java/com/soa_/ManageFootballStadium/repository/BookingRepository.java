package com.soa_.ManageFootballStadium.repository;

import com.soa_.ManageFootballStadium.model.Booking;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface BookingRepository extends CrudRepository<Booking, Long> {
    Optional<Booking> findByIdAndUserId(Long bookingId, Long userId);
}

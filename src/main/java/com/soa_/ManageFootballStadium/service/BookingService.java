package com.soa_.ManageFootballStadium.service;


import com.soa_.ManageFootballStadium.model.Booking;
import com.soa_.ManageFootballStadium.model.Stadium;
import com.soa_.ManageFootballStadium.model.User;
import com.soa_.ManageFootballStadium.model._enum.Status;
import com.soa_.ManageFootballStadium.repository.BookingRepository;
import com.soa_.ManageFootballStadium.repository.StadiumRepository;
import com.soa_.ManageFootballStadium.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class BookingService {
    private final BookingRepository bookingRepository;
    private final StadiumRepository stadiumRepository;
    private final UserRepository userRepository;

    public Booking createBooking(Long stadiumId, Long userId, LocalDateTime startTime, LocalDateTime endTime) {
        Stadium stadium = stadiumRepository.findById(stadiumId).orElse(null);
        if (stadium != null) {
            // Kiểm tra xem có booking nào trùng với thời gian không
            if (isTimeSlotBooked(stadiumId, startTime, endTime)) {
                throw new RuntimeException("Thời gian đã được đặt cho sân này.");
            }

            Booking booking = new Booking();
            booking.setStadium(stadium);
            booking.setUser(userRepository.getById(userId));
            booking.setStartTime(startTime);
            booking.setEndTime(endTime);
            booking.setStatus(Status.COMPLETED);
            return bookingRepository.save(booking);
        }


        return null;
    }

    private boolean isTimeSlotBooked(Long stadiumId, LocalDateTime startTime, LocalDateTime endTime) {
        // Kiểm tra xem có booking nào cho sân này trong khoảng thời gian đã cho

        Iterable<Booking> iterableStadiums = bookingRepository.findAll();
        List<Booking> bookings = StreamSupport.stream(iterableStadiums.spliterator(), false)
                .toList();

        return bookings.stream().anyMatch(booking ->
                booking.getStadium().getId().equals(stadiumId) &&
                        booking.getStartTime().isBefore(endTime) &&
                        booking.getEndTime().isAfter(startTime));
    }

    public List<Booking> getBookings() {
        Iterable<Booking> iterableBookings = bookingRepository.findAll();
        return (List<Booking>) iterableBookings;
    }
}

package com.soa_.ManageFootballStadium.controller;

import com.soa_.ManageFootballStadium.model.Booking;
import com.soa_.ManageFootballStadium.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/bookings")
@RequiredArgsConstructor
public class BookingController {
    private final BookingService bookingService;

    @PostMapping
    public ResponseEntity<Booking> createBooking(@RequestParam Long stadiumId,
                                                 @RequestParam Long userId,
                                                 @RequestParam LocalDateTime startTime,
                                                 @RequestParam LocalDateTime endTime) {
        Booking booking = bookingService.createBooking(stadiumId, userId, startTime, endTime);
        if (booking != null) {
            return ResponseEntity.ok(booking);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Booking>> getAllBookings() {
        return ResponseEntity.ok(bookingService.getBookings());
    }
}

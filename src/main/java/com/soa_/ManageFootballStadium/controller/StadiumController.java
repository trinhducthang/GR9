package com.soa_.ManageFootballStadium.controller;

import com.soa_.ManageFootballStadium.model.Review;
import com.soa_.ManageFootballStadium.model.Stadium;
import com.soa_.ManageFootballStadium.service.StadiumService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stadiums")
@RequiredArgsConstructor
public class StadiumController {
    private final StadiumService stadiumService;

    @GetMapping("/all")
    public ResponseEntity<List<Stadium>> getAll() {
        return ResponseEntity.ok(stadiumService.getStadiums());
    }

    @GetMapping
    public ResponseEntity<List<Stadium>> filterStadiums(
                                                        @RequestParam(required = false) Double minPrice,
                                                        @RequestParam(required = false) Double maxPrice,
                                                        @RequestParam(required = false) Double minRating) {
        List<Stadium> stadiums = stadiumService.filterStadiums( minPrice, maxPrice, minRating);
        return ResponseEntity.ok(stadiums);
    }

    @GetMapping("/{stadiumId}")
    public ResponseEntity<Stadium> getStadiumDetails(@PathVariable Long stadiumId) {
        Stadium stadium = stadiumService.getStadiumDetails(stadiumId);
        return stadium != null ? ResponseEntity.ok(stadium) : ResponseEntity.notFound().build();
    }

    @PostMapping("/{stadiumId}/reviews")
    public void addReview(@PathVariable Long stadiumId, @RequestBody Review review) {
        stadiumService.addReview(stadiumId, review);
    }
}

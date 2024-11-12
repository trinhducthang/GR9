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

    // Lấy danh sách tất cả sân bóng
    @GetMapping("/all")
    public ResponseEntity<List<Stadium>> getAllStadiums() {
        List<Stadium> stadiums = stadiumService.getStadiums();
        return ResponseEntity.ok(stadiums);
    }

    // Lọc sân bóng theo các tiêu chí giá và đánh giá
    @GetMapping
    public ResponseEntity<List<Stadium>> filterStadiums(
            @RequestParam(required = false) Double minPrice,
            @RequestParam(required = false) Double maxPrice,
            @RequestParam(required = false) Double minRating) {

        List<Stadium> stadiums = stadiumService.filterStadiums(minPrice, maxPrice, minRating);
        return ResponseEntity.ok(stadiums);
    }

    // Lấy chi tiết sân bóng
    @GetMapping("/{stadiumId}")
    public ResponseEntity<Stadium> getStadiumDetails(@PathVariable Long stadiumId) {
        Stadium stadium = stadiumService.getStadiumDetails(stadiumId);
        return stadium != null ? ResponseEntity.ok(stadium) : ResponseEntity.notFound().build();
    }

    // Thêm sân bóng mới
    @PostMapping
    public ResponseEntity<Stadium> addStadium(@RequestBody Stadium stadium) {
        Stadium newStadium = stadiumService.addStadium(stadium);
        return ResponseEntity.ok(newStadium);
    }

    // Cập nhật sân bóng
    @PutMapping("/{stadiumId}")
    public ResponseEntity<Stadium> updateStadium(
            @PathVariable Long stadiumId, @RequestBody Stadium updatedStadium) {

        Stadium stadium = stadiumService.updateStadium(stadiumId, updatedStadium);
        return stadium != null ? ResponseEntity.ok(stadium) : ResponseEntity.notFound().build();
    }

    // Xóa sân bóng
    @DeleteMapping("/{stadiumId}")
    public ResponseEntity<Void> deleteStadium(@PathVariable Long stadiumId) {
        boolean isDeleted = stadiumService.deleteStadium(stadiumId);
        return isDeleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    // Thêm đánh giá cho sân bóng
    @PostMapping("/{stadiumId}/reviews")
    public ResponseEntity<Void> addReview(@PathVariable Long stadiumId, @RequestBody Review review) {
        stadiumService.addReview(stadiumId, review);
        return ResponseEntity.ok().build();
    }
}

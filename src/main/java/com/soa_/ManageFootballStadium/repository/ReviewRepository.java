package com.soa_.ManageFootballStadium.repository;

import com.soa_.ManageFootballStadium.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    // Có thể tạo thêm các phương thức tìm kiếm, lọc nếu cần
}

package com.soa.manageLaptop.repository;

import com.soa.manageLaptop.model.Order;
import com.soa.manageLaptop.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByUser(User user);

    @Query("SELECT COUNT(o), SUM(o.totalPrice) FROM Order o WHERE o.status = :status")
    Object[] findOrderCountAndTotalPriceByStatus(@Param("status") String status);

    List<Order> findByStatus(String status);
}

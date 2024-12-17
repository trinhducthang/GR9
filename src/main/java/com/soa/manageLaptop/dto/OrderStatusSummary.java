package com.soa.manageLaptop.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderStatusSummary {
    // Getters and setters
    private Long orderCount;
    private Double totalPrice;

    public OrderStatusSummary(Long orderCount, Double totalPrice) {
        this.orderCount = orderCount;
        this.totalPrice = totalPrice;
    }
}


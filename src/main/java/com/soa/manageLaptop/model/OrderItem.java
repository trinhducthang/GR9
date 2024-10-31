package com.soa.manageLaptop.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Product product;

    private Integer quantity;

    @ManyToOne
    private Order order;

    // Getters and Setters
}

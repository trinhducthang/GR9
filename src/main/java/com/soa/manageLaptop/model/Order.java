package com.soa.manageLaptop.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Table
@Entity
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    private LocalDateTime orderDate;
    private String status;
    private Double totalPrice;

    @OneToMany(mappedBy = "order")
    private List<OrderItem> items;
}

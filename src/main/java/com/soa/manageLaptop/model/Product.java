package com.soa.manageLaptop.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String model;
    private Double price;
    private String description;
    private String imageUrl;
    private String brand;
    private String specifications;
}

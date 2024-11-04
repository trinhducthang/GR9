package com.soa.manageLaptop.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String model;
    private String description;
    private double price;
    private String imageUrl;

    @ManyToOne
    private Category category;

    @ManyToMany(mappedBy = "applicableProducts")
    private List<Promotion> promotions;

    public Product(String laptopA, String laptopA1, String brandA, String descriptionA, int i, String image) {
    }
}

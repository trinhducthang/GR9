package com.soa.manageLaptop.model;

import lombok.Data;

import java.util.List;

@Data
public class Cart {
    private int userId;
    private List<Integer> productIds;
}

package com.soa.manageLaptop.request;

import lombok.Data;

import java.util.List;

@Data
public class OrderRequest {
    private Long userId;
    private List<Long> productIds; // Danh sách ID sản phẩm
    private String phoneNumber;
    private String address;

}

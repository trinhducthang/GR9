package com.soa.manageLaptop.controller;

import com.soa.manageLaptop.model.Order;
import com.soa.manageLaptop.request.OrderRequest;
import com.soa.manageLaptop.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody OrderRequest orderRequest) {
        Order order = orderService.createOrder(orderRequest);
        return ResponseEntity.ok(order);
    }

    @GetMapping
    public ResponseEntity<List<Order>> getOrderByUser(@RequestParam Long id) {
        return ResponseEntity.ok(orderService.getOrdersByUser(id));
    }
}

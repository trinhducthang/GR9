package com.soa.manageLaptop.service;

import com.soa.manageLaptop.model.Order;
import com.soa.manageLaptop.model.Product;
import com.soa.manageLaptop.model.User;
import com.soa.manageLaptop.repository.OrderRepository;
import com.soa.manageLaptop.repository.ProductRepository;
import com.soa.manageLaptop.repository.UserRepository;
import com.soa.manageLaptop.request.OrderRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository; // Repository để truy cập thông tin sản phẩm

    public Order createOrder(OrderRequest orderRequest) {
        User user = userRepository.findById(orderRequest.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Order order = new Order();
        order.setUser(user); // This sets the user, which should link to the user_id in the database
        order.setOrderDate(LocalDateTime.now());
        order.setStatus("PENDING");

        double totalPrice = 0;

        for (Long productId : orderRequest.getProductIds()) {
            Product product = productRepository.findById(productId)
                    .orElseThrow(() -> new RuntimeException("Product not found"));
            order.getProductIds().add(productId);
            totalPrice += product.getPrice();
        }

        order.setTotalPrice(totalPrice);

        return orderRepository.save(order);
    }


    public List<Order> getOrdersByUser(Long id) {
        User user = userRepository.getById(id);
        return orderRepository.findByUser(user);
    }
}


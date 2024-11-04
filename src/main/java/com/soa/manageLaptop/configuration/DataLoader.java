//package com.soa.manageLaptop.configuration;
//
//import com.soa.manageLaptop.model.Order;
//import com.soa.manageLaptop.model.Product;
//import com.soa.manageLaptop.model.Promotion;
//import com.soa.manageLaptop.model.User;
//import com.soa.manageLaptop.repository.OrderRepository;
//import com.soa.manageLaptop.repository.ProductRepository;
//import com.soa.manageLaptop.repository.PromotionRepository;
//import com.soa.manageLaptop.repository.UserRepository;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//import java.util.Arrays;
//import java.util.List;
//
//@Component
//public class DataLoader implements CommandLineRunner {
//
//    private final UserRepository userRepository;
//    private final ProductRepository productRepository;
//    private final OrderRepository orderRepository;
//    private final PromotionRepository promotionRepository;
//
//    public DataLoader(UserRepository userRepository, ProductRepository productRepository,
//                      OrderRepository orderRepository, PromotionRepository promotionRepository) {
//        this.userRepository = userRepository;
//        this.productRepository = productRepository;
//        this.orderRepository = orderRepository;
//        this.promotionRepository = promotionRepository;
//    }
//
//    @Override
//    public void run(String... args) throws Exception {
//        // Thêm người dùng demo
//        List<User> users = Arrays.asList(
//                new User("John Doe", "john@example.com", "1234567890", "password123"),
//                new User("Jane Smith", "jane@example.com", "0987654321", "password456"),
//                new User("Michael Johnson", "michael@example.com", "1122334455", "password789"),
//                new User("Emily Davis", "emily@example.com", "2233445566", "password101112"),
//                new User("William Brown", "william@example.com", "3344556677", "password131415")
//        );
//        userRepository.saveAll(users);
//
//        // Thêm sản phẩm demo
//        List<Product> products = Arrays.asList(
//                new Product("Laptop A", "LAPTOP_A", "Brand A", "Description A", 15000000, "link_to_image_a.jpg"),
//                new Product("Laptop B", "LAPTOP_B", "Brand B", "Description B", 20000000, "link_to_image_b.jpg"),
//                new Product("Laptop C", "LAPTOP_C", "Brand C", "Description C", 18000000, "link_to_image_c.jpg"),
//                new Product("Laptop D", "LAPTOP_D", "Brand D", "Description D", 25000000, "link_to_image_d.jpg"),
//                new Product("Laptop E", "LAPTOP_E", "Brand E", "Description E", 22000000, "link_to_image_e.jpg"),
//                new Product("Gaming Laptop F", "GAMING_LAPTOP_F", "Brand F", "Description F", 30000000, "link_to_image_f.jpg"),
//                new Product("Ultrabook G", "ULTRABOOK_G", "Brand G", "Description G", 35000000, "link_to_image_g.jpg"),
//                new Product("2-in-1 Laptop H", "2IN1_LAPTOP_H", "Brand H", "Description H", 40000000, "link_to_image_h.jpg")
//        );
//        productRepository.saveAll(products);
//
//        // Thêm khuyến mãi demo
//        List<Promotion> promotions = Arrays.asList(
//                new Promotion("20% off on orders over 20 million", 20, 20000000),
//                new Promotion("10% off on Laptop A and B", 10, 10000000),
//                new Promotion("5% off for first-time customers", 5, 5000000)
//        );
//        promotionRepository.saveAll(promotions);
//
//        // Thêm đơn hàng demo
//        List<Order> orders = Arrays.asList(
//                new Order(users.get(0), Arrays.asList(products.get(0), products.get(1)), "Processing"),
//                new Order(users.get(1), Arrays.asList(products.get(2), products.get(3)), "Shipped"),
//                new Order(users.get(2), Arrays.asList(products.get(4)), "Delivered"),
//                new Order(users.get(3), Arrays.asList(products.get(5), products.get(6)), "Canceled"),
//                new Order(users.get(4), Arrays.asList(products.get(7)), "Processing")
//        );
//        orderRepository.saveAll(orders);
//    }
//}

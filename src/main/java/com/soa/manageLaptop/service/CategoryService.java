package com.soa.manageLaptop.service;

import com.soa.manageLaptop.model.Category;
import com.soa.manageLaptop.model.Product;
import com.soa.manageLaptop.repository.CategoryRepository;
import com.soa.manageLaptop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Category saveCategory(String name, long[] ids) {
        // Tìm danh sách các sản phẩm bằng cách sử dụng findByIdIn
        List<Product> products = productRepository.findByIdIn(Arrays.stream(ids).boxed().collect(Collectors.toList()));

        // Gán danh sách sản phẩm vào category
        Category category = categoryRepository.findByName(name);

        if(category != null) {
            List<Product> newProducts = category.getProducts();
            newProducts.addAll(products);
            category.setProducts(products);
            return categoryRepository.save(category);
        }
        else {
            category = new Category();
            category.setName(name);
            category.setProducts(products);
        }

        // Lưu danh mục với các sản phẩm đã cập nhật
        return categoryRepository.save(category);
    }
}

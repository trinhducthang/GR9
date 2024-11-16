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
            for(Product product : newProducts) {
                product.setCategory(category);
                productRepository.save(product);
            }
            return categoryRepository.save(category);
        }
        else {
            category = new Category();
            category.setName(name);
            category.setProducts(products);
            for(Product product : products) {
                product.setCategory(category);
                productRepository.save(product);
            }
        }

        // Lưu danh mục với các sản phẩm đã cập nhật
        return categoryRepository.save(category);
    }

    public Category updateCategory(Long categoryId, String name, long[] ids) {
        // Tìm danh mục theo ID
        Optional<Category> optionalCategory = categoryRepository.findById(categoryId);
        if (!optionalCategory.isPresent()) {
            return null; // Nếu danh mục không tồn tại
        }

        Category category = optionalCategory.get();
        category.setName(name);

        // Tìm danh sách các sản phẩm cần gắn vào danh mục
        List<Product> products = productRepository.findByIdIn(Arrays.stream(ids).boxed().collect(Collectors.toList()));

        // Cập nhật sản phẩm trong danh mục
        category.setProducts(products);
        for (Product product : products) {
            product.setCategory(category);
            productRepository.save(product);
        }

        return categoryRepository.save(category); // Lưu lại danh mục đã cập nhật
    }

    public Category getCategoryById(Long categoryId) {
        return categoryRepository.findById(categoryId).get();
    }
}

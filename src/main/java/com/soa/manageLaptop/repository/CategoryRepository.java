package com.soa.manageLaptop.repository;

import com.soa.manageLaptop.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> { }


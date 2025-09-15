package com.sanjtiksha.site.repository;

import com.sanjtiksha.site.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {}

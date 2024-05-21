package com.efub.leadtoyproject.domain.product.repository;

import com.efub.leadtoyproject.domain.product.domain.Product;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @EntityGraph(attributePaths = {"category"})
    Product findByProductId(Long productId);
}

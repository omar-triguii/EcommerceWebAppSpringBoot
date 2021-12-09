package com.asb.example.repo;

import com.asb.example.model.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductImageRepository extends JpaRepository<ProductImage,Long> {
}

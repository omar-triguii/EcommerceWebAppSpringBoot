package com.asb.example.dto;

import com.asb.example.model.Category;
import com.asb.example.model.ProductImage;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class ProductDto {
    private Long ID;
    private String name;
    private BigDecimal prix;
    private BigDecimal TVA;
    private Integer quantity;
    private Date datefondation;
    private Set<String> paniers = new HashSet<>();
   private Long categoryId;

    private Set<ProductImage> productImages = new HashSet<>() ;
}

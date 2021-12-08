package com.asb.example.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class PanierDto {
    private Long ID;
    private BigDecimal total;
    private Integer NbProducts;
    private Date datePanier;

    private String panierName;
    private Set<String> products = new HashSet<>();
}


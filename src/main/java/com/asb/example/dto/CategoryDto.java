package com.asb.example.dto;

import com.asb.example.Enums.categoryTypeEnum;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
@Getter
@Setter
public class CategoryDto {
    private Long id;
    private String description;
    private categoryTypeEnum categorytypeEnum;
}

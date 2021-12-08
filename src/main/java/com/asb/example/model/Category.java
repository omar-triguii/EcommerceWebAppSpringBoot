package com.asb.example.model;

import com.asb.example.Enums.categoryTypeEnum;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String description;
    private categoryTypeEnum categorytypeEnum;

    public Category(Long id, String description,categoryTypeEnum categorytypeEnum) {
        this.id = id;
        this.description = description;
        this.categorytypeEnum=categorytypeEnum;
    }

    public Category() {

    }
}

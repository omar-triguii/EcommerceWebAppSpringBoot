package com.asb.example.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.crypto.Data;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "product")
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long product_ID;
    private String name;
    private BigDecimal prix;
    private BigDecimal TVA;
    private Integer quantity;
    private Date datefondation;


    @ManyToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST })
    @JoinTable(name = "Product_panier", joinColumns = { @JoinColumn(name = "product_ID") }, inverseJoinColumns = {
            @JoinColumn(name = "panier_ID") })
    private Set<Panier> paniers;

    @ManyToOne()
    @JoinColumn(name = "categoryId")
    private Category category;


    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void removePanier(Panier panier) {
        this.getPaniers().remove(panier);
        panier.getProducts().remove(this);
    }
    public void removePaniers() {
        for (Panier panier : new HashSet<>(paniers)) {
            removePanier(panier);
        }
    }
    @Override
    public String toString() {
        return "Product{" +
                "product_ID=" + product_ID +
                ", name='" + name + '\'' +
                ", prix=" + prix +
                ", TVA=" + TVA +
                ", quantity=" + quantity +
                ", datefondation=" + datefondation +
                '}';
    }
}

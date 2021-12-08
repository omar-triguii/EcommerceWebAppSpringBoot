package com.asb.example.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;
@Getter
@Setter
@Entity
@Table(name = "panier")
public class Panier {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "product_sequence", sequenceName = "product_sequence")
    private Long panier_ID;
    private BigDecimal total;
    private Integer NbProducts;
    private Date datePanier;
    private String panierName;
    @ManyToMany(mappedBy = "paniers")
    @JsonIgnore
    private Set<Product> products;

   public void addProduct(Product product) {
        this.products.add(product);
        product.getPaniers().add(this);
    }


    @Override
    public String toString() {
        return "Panier{" +
                "panier_ID=" + panier_ID +
                ", total=" + total +
                ", NbProducts=" + NbProducts +
                ", datePanier=" + datePanier +
                ", panierName='" + panierName + '\'' +

                '}';
    }
}

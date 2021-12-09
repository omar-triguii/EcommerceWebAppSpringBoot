package com.asb.example.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class ProductImage {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private Long imageId;

    private String name;

    private String contentType;

    private Long size;

    @Lob
    private byte[] data;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_Id")
    @JsonIgnore
    private Product product;

    public ProductImage(Long imageId, String name, String contentType, Long size, byte[] data, Product product) {
        this.imageId = imageId;
        this.name = name;
        this.contentType = contentType;
        this.size = size;
        this.data = data;
        this.product = product;
    }

    public ProductImage() {

    }
}

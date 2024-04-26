package com.tobiasjohansson.demooptimize.models;

import jakarta.persistence.*;

@Entity
@Table(name = "PRODUCTS", indexes = @Index(name = "price_index", columnList = "price"))
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long productId;
    @Column(nullable = false, length = 50)
    private String name;
    @Column(nullable = false, length = 100)
    private long price;


    public Product() {
    }

    public Product(long productId, String name, long price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

}

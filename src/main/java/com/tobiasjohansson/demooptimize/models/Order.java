package com.tobiasjohansson.demooptimize.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "ORDERS", indexes = @Index(columnList = "orderId")
)
public class Order {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long orderId;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date orderDate;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Product> productList = new ArrayList<>();

    private long totalPrice;

    public Order(long orderId, Date orderDate, List<Product> productList, long totalPrice) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.productList = productList;
        this.totalPrice = totalPrice;
    }

    public Order() {
    }


    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public long getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(long totalPrice) {
        this.totalPrice = totalPrice;
    }
}

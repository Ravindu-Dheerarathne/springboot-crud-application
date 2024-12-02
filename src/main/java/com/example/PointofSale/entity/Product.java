package com.example.PointofSale.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @Column(name = "product_id", length = 50)
    @GeneratedValue  (strategy = GenerationType.IDENTITY)
    private int productId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price(USD)", nullable = false)
    private double price;

    @Column(name = "stock_qty")
    private int stock_qty;

    @Column(name = "category")
    private String category;

    @OneToMany(mappedBy="product")
    private Set<SaleItem> saleItems;

    // Normal getters, setters and constructors have been used instead spring boot annotation.
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock_qty() {
        return stock_qty;
    }

    public void setStock_qty(int stock_qty) {
        this.stock_qty = stock_qty;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Product() {
    }

    public Product(int productId, String name, String description, double price, int stock_qty, String category) {
        this.productId = productId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock_qty = stock_qty;
        this.category = category;
    }
}

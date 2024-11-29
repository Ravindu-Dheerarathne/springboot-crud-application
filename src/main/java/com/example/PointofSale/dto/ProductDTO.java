package com.example.PointofSale.dto;


public class ProductDTO {

    private int productId;
    private String name;
    private String description;
    private double price;
    private int stock_qty;
    private String category;

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

    public ProductDTO() {
    }

    public ProductDTO(int productId, String name, String description, double price, int stock_qty, String category) {
        this.productId = productId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock_qty = stock_qty;
        this.category = category;
    }

}

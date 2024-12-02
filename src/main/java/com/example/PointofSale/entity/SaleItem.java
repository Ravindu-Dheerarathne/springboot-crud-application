package com.example.PointofSale.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "sale_item")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaleItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sale_item_id" , length = 50)
    private int saleItemId;

    @Column(name = "quantity" , nullable = false)
    private int quantity;

    @Column(name = "unit_price" , nullable = false)
    private double unitPrice;

    @ManyToOne
    @JoinColumn(name="product_id", nullable=false)
    private Product product;

    @ManyToOne
    @JoinColumn(name="sale_id", nullable=false)
    private Sale sale;

}

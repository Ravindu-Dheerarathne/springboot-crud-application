package com.example.PointofSale.entity;


import com.example.PointofSale.entity.enums.Payment_Status;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "sale")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sale_id" , length = 50)
    private int saleId;

    @Column(name = "sale_date" , nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss,SSS")
    private Date saleDate;

    @Column(name = "total_amount" , nullable = false)
    private Double totalAmount;

    @Enumerated(EnumType.STRING)
    @Column(name = "payment_status" , nullable = false)
    private Payment_Status paymentStatus;

    @OneToMany(mappedBy="sale")
    private Set<SaleItem> saleItems;

    public Sale(Date saleDate, Double totalAmount, Payment_Status paymentStatus) {
        this.saleDate = saleDate;
        this.totalAmount = totalAmount;
        this.paymentStatus = paymentStatus;
    }
}

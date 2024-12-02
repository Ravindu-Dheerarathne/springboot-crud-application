package com.example.PointofSale.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaleItemDTO {

    private int quantity;
    private double unitPrice;
    private int productId;
    private int saleId;

}

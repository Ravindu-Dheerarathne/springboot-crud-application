package com.example.PointofSale.dto.responsedto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class QuantityResponseDTO {
    private int productId;
    private String name;
    private int stockQty;
}

package com.example.PointofSale.dto;

import com.example.PointofSale.entity.enums.Payment_Status;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaleDTO {

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate saleDate;
    private Double totalAmount;
    private Payment_Status paymentStatus;
    private List<SaleItemDTO> saleItemDTOS;

}

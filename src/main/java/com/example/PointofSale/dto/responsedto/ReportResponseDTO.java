package com.example.PointofSale.dto.responsedto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReportResponseDTO {
    LocalDate startdate;
    LocalDate endDate;
    double totalAmount;
    String ProductName;

}

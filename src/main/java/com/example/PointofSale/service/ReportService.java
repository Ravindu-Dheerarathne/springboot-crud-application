package com.example.PointofSale.service;

import com.example.PointofSale.dto.responsedto.ReportResponseDTO;

import java.time.LocalDate;

public interface ReportService {
    ReportResponseDTO saleReport(LocalDate startDate, LocalDate endDate, Integer productId);
}

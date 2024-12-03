package com.example.PointofSale.service.impl;

import com.example.PointofSale.dto.responsedto.ReportResponseDTO;
import com.example.PointofSale.exception.NotFoundException;
import com.example.PointofSale.repository.ProductRepo;
import com.example.PointofSale.repository.SaleRepo;
import com.example.PointofSale.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ReportServiceIMPL implements ReportService {

    @Autowired
    private SaleRepo saleRepo;

    @Autowired
    private ProductRepo productRepo;

    @Override
    public ReportResponseDTO saleReport(LocalDate startDate, LocalDate endDate, Integer productId) {

        if (productId == null) {

            double totalAmount = saleRepo.getTotalSales(startDate, endDate);
            ReportResponseDTO reportResponseDTO = new ReportResponseDTO();
            reportResponseDTO.setStartdate(startDate);
            reportResponseDTO.setEndDate(endDate);
            reportResponseDTO.setTotalAmount(totalAmount);
            reportResponseDTO.setProductName("Product Not given");
            return reportResponseDTO;

        } else {
            boolean ss = productRepo.existsByProductId(productId);
            if (!ss) {
                throw new NotFoundException("Product Not Found");
            } else {

                int totalQtyBetweenDatesByProductId = saleRepo.getTotalSalesByProductId(startDate, endDate, productId);
                double totalAmountByProductId = totalQtyBetweenDatesByProductId * productRepo.getPrice(productId);

                ReportResponseDTO reportResponseDTO = new ReportResponseDTO();
                reportResponseDTO.setStartdate(startDate);
                reportResponseDTO.setEndDate(endDate);
                reportResponseDTO.setTotalAmount(totalAmountByProductId);
                reportResponseDTO.setProductName(productRepo.getProductNameByProductId(productId));
                return reportResponseDTO;

            }
        }
    }
}

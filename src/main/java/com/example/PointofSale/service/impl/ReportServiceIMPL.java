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
            boolean existsProduct = productRepo.existsByProductId(productId);
            if (!existsProduct) {
                throw new NotFoundException("Product Not Found in Product Table");
            } else {

                Long existsProductInSaleTbl = saleRepo.productIdExistsInSaleTbl(startDate,endDate,productId);
                boolean boolExistsProductInSaleTbl = existsProductInSaleTbl != 0 ;

                if(!boolExistsProductInSaleTbl){
                    throw new NotFoundException("Product Not Found in Sale Item Table Within Date Range");
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
}

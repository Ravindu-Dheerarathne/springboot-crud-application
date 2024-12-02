package com.example.PointofSale.controller;

import com.example.PointofSale.dto.responsedto.ReportResponseDTO;
import com.example.PointofSale.service.ReportService;
import com.example.PointofSale.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("api/v1/report")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @GetMapping("sale-report")
    public ResponseEntity<StandardResponse> saleReport(@RequestParam LocalDate startDate, @RequestParam LocalDate endDate, @RequestParam(required = false) Integer productId) {
        ReportResponseDTO response = reportService.saleReport(startDate,endDate,productId);
        ResponseEntity<StandardResponse> responseEntity = new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"Success",response), HttpStatus.OK
        );
        return responseEntity;
    }
}

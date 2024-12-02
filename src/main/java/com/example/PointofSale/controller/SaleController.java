package com.example.PointofSale.controller;

import com.example.PointofSale.dto.SaleDTO;
import com.example.PointofSale.service.SaleService;
import com.example.PointofSale.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/sale")
public class SaleController {

    @Autowired
    private SaleService saleService;

    @PostMapping(path="/create-sale")
    public ResponseEntity<StandardResponse> createSale(@RequestBody SaleDTO saleDTO){
//        String response = saleService.createSale(saleDTO);
//        System.out.println(saleDTO);
        SaleDTO saleDTO1 = saleService.createSale(saleDTO);
        ResponseEntity<StandardResponse> responseEntity = new ResponseEntity<StandardResponse>(
                new StandardResponse(201,"Sale Successfully Completed",saleDTO1) , HttpStatus.CREATED
        );
        return responseEntity;
    }
}

package com.example.PointofSale.service.impl;

import com.example.PointofSale.dto.SaleDTO;
import com.example.PointofSale.entity.Sale;
import com.example.PointofSale.entity.SaleItem;
import com.example.PointofSale.exception.NotFoundException;
import com.example.PointofSale.repository.ProductRepo;
import com.example.PointofSale.repository.SaleItemRepo;
import com.example.PointofSale.repository.SaleRepo;
import com.example.PointofSale.service.SaleService;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SaleServiceIMPL implements SaleService {

    @Autowired
    private SaleRepo saleRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private SaleItemRepo saleItemRepo;

    @Autowired
    private ProductRepo productRepo;

    @Override
    @Transactional
    public SaleDTO createSale(SaleDTO saleDTO) {
        for (int i=0;i<saleDTO.getSaleItemDTOS().size();i++){
            boolean existsProduct = productRepo.existsByProductId(saleDTO.getSaleItemDTOS().get(i).getProductId());
            int productQty = productRepo.getProductQtyByProductId(saleDTO.getSaleItemDTOS().get(i).getProductId());
            if(productQty<1 || !existsProduct){
                throw new NotFoundException(saleDTO.getSaleItemDTOS().get(i).getProductId() + " is out of stock.");
            }
        }

        Sale sale = new Sale(
                saleDTO.getSaleDate(),
                saleDTO.getTotalAmount(),
                saleDTO.getPaymentStatus()
               );
        saleRepo.save(sale);

        if(saleRepo.existsById(sale.getSaleId())){
            List<SaleItem> saleItemList = modelMapper.map(saleDTO.getSaleItemDTOS(), new TypeToken<List<SaleItem>>() {
            }.getType());

            for (int i=0;i<saleItemList.size();i++){
                saleItemList.get(i).setSale(sale);
                saleItemList.get(i).setProduct(productRepo.getReferenceById(saleDTO.getSaleItemDTOS().get(i).getProductId()));
                int productQuantity = productRepo.getProductQtyByProductId(saleDTO.getSaleItemDTOS().get(i).getProductId());
                productRepo.setProductQtyByProductId(productQuantity - saleDTO.getSaleItemDTOS().get(i).getQuantity(), saleDTO.getSaleItemDTOS().get(i).getProductId());
            }

            if(saleItemList.size()>0){
                saleItemRepo.saveAll(saleItemList);
            }
        }

        return saleDTO;
    }

}

package com.example.PointofSale.service.impl;

import com.example.PointofSale.dto.ProductDTO;
import com.example.PointofSale.dto.queryInterface.TrackQuantitiesInterface;
import com.example.PointofSale.dto.responsedto.QuantityResponseDTO;
import com.example.PointofSale.entity.Product;
import com.example.PointofSale.exception.NotFoundException;
import com.example.PointofSale.repository.ProductRepo;
import com.example.PointofSale.service.ProductService;
import com.example.PointofSale.util.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceIMPL implements ProductService {

    // Conversions between the entity class and the dto class is done though the constructors in some methods.

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private ProductRepo productRepo;

    @Override
    public String saveProduct(ProductDTO productDTO){
        Product product = new Product(
                productDTO.getProductId(),
                productDTO.getName(),
                productDTO.getDescription(),
                productDTO.getPrice(),
                productDTO.getStock_qty(),
                productDTO.getCategory()
        );
        productRepo.save(product);
        return productDTO.getName() + " Saved";
    }

    @Override
    public String updateProduct(ProductDTO productDTO) {

        if (productRepo.existsById(productDTO.getProductId())) {
            Product product = productRepo.getReferenceById(productDTO.getProductId());
            product.setCategory(productDTO.getCategory());
            product.setDescription(productDTO.getDescription());
            product.setName(productDTO.getName());
            product.setPrice(productDTO.getPrice());
            product.setStock_qty(productDTO.getStock_qty());
            productRepo.save(product);
            return productDTO.getName() + " Updated";
        } else return productDTO.getName() + " Not Updated";
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        List<Product> list = productRepo.findAll();
        List<ProductDTO> dtoList = new ArrayList<>();

        for (Product product:list) {
            ProductDTO productDTO = new ProductDTO(
                    product.getProductId(),
                    product.getName(),
                    product.getDescription(),
                    product.getPrice(),
                    product.getStock_qty(),
                    product.getCategory()
            );
        dtoList.add(productDTO);
        }
        return dtoList;
    }

    @Override
    public ProductDTO getProductById(int productId) {
        if (productRepo.existsById(productId)){
            Product product = productRepo.getReferenceById(productId);
            ProductDTO productDTO = new ProductDTO(
                    product.getProductId(),
                    product.getName(),
                    product.getDescription(),
                    product.getPrice(),
                    product.getStock_qty(),
                    product.getCategory()
            );
            return productDTO;
        }
        else throw new NotFoundException("Not Found");
    }

    @Override
    public String deleteProductById(int productId) {
        if (productRepo.existsById(productId)){
            productRepo.deleteById(productId);
            return productId + " Deleted";
        }
        else throw new NotFoundException("Not Found");
    }

    @Override
    public List<QuantityResponseDTO> trackQuantities(String productName) {
        List<TrackQuantitiesInterface> trackQuantitiesInterfaces = productRepo.trackQuantities(productName);
        List<QuantityResponseDTO> quantityResponseDTOList = productMapper.entityListToDTO(trackQuantitiesInterfaces);
        if(!quantityResponseDTOList.isEmpty()){
            return quantityResponseDTOList;
        } else throw new NotFoundException("No Products with the Name");
    }

}

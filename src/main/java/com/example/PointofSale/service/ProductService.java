package com.example.PointofSale.service;

import com.example.PointofSale.dto.ProductDTO;

import java.util.List;

public interface ProductService {
    String saveProduct(ProductDTO productDTO);

    String updateProduct(ProductDTO productDTO);

    List<ProductDTO> getAllProducts();

    ProductDTO getProductById(int productId);

    String deleteProductById(int productId);
}

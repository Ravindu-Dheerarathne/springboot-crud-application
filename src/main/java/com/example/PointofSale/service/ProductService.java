package com.example.PointofSale.service;

import com.example.PointofSale.dto.ProductDTO;
import com.example.PointofSale.dto.responsedto.PaginatedProductResponseDTO;
import com.example.PointofSale.dto.responsedto.QuantityResponseDTO;

import java.util.List;

public interface ProductService {
    String saveProduct(ProductDTO productDTO);

    String updateProduct(ProductDTO productDTO);

    List<ProductDTO> getAllProducts();

    ProductDTO getProductById(int productId);

    String deleteProductById(int productId);

    List<QuantityResponseDTO> trackQuantities(String productName);

    PaginatedProductResponseDTO getProductsByCategory(String category, int page, int size);

}

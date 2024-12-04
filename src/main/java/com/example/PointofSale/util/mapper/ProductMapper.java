package com.example.PointofSale.util.mapper;

import com.example.PointofSale.dto.ProductDTO;
import com.example.PointofSale.dto.queryInterface.TrackQuantitiesInterface;
import com.example.PointofSale.dto.responsedto.QuantityResponseDTO;
import com.example.PointofSale.entity.Product;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    List<QuantityResponseDTO> entityListToDTO (List<TrackQuantitiesInterface> trackQuantitiesInterfaces);

    List<ProductDTO> listToPage (Page<Product> productList);

}

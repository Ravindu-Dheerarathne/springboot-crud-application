package com.example.PointofSale.util.mapper;

import com.example.PointofSale.dto.queryInterface.TrackQuantitiesInterface;
import com.example.PointofSale.dto.responsedto.QuantityResponseDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    List<QuantityResponseDTO> entityListToDTO (List<TrackQuantitiesInterface> trackQuantitiesInterfaces);
}

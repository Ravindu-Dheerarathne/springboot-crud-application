package com.example.PointofSale.dto.responsedto;

import com.example.PointofSale.dto.ProductDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaginatedProductResponseDTO {

    List<ProductDTO> list;
    private int dataCount;
}

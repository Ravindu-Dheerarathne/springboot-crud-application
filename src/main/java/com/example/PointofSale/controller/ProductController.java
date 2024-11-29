package com.example.PointofSale.controller;

import com.example.PointofSale.dto.ProductDTO;
import com.example.PointofSale.service.ProductService;
import com.example.PointofSale.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping(path = "/add-product")
    public ResponseEntity<StandardResponse> addProduct(@RequestBody ProductDTO productDTO) {
        String response = productService.saveProduct(productDTO);
        ResponseEntity<StandardResponse> responseEntity = new ResponseEntity<StandardResponse>(
                new StandardResponse(201, "Successfully Created", response), HttpStatus.CREATED);

        return responseEntity;
    }

    @PutMapping("/update-product")
    public ResponseEntity<StandardResponse> updateProduct(@RequestBody ProductDTO productDTO){

        String response = productService.updateProduct(productDTO);
        ResponseEntity<StandardResponse> responseEntity = new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"Updated Successfully",response) , HttpStatus.OK
        );
        return responseEntity;
    }

    @GetMapping("/get-all-products")
    public ResponseEntity<StandardResponse> getAllProducts() {
        List<ProductDTO> list = productService.getAllProducts();
        ResponseEntity<StandardResponse> responseEntity = new ResponseEntity<StandardResponse>(
                new StandardResponse(200, "Successfully Retrieved Data", list) , HttpStatus.OK
        );
        return responseEntity;
    }

    @GetMapping(path = "/get-by-id/{id}")
    public ResponseEntity<StandardResponse> getById(@PathVariable(value = "id") int productId){
        ProductDTO productDTO = productService.getProductById(productId);
        ResponseEntity<StandardResponse> responseEntity = new ResponseEntity<StandardResponse>(
                new StandardResponse(200, "Successfully Retrieved Data", productDTO) , HttpStatus.OK
        );
        return responseEntity;
    }

    @DeleteMapping(path="/delete-by-id")
    public ResponseEntity<StandardResponse> deleteById(@RequestParam int productId){
        String response = productService.deleteProductById(productId);
        ResponseEntity<StandardResponse> responseEntity = new ResponseEntity<StandardResponse>(
                new StandardResponse(200, "Successfully Deleted", response) , HttpStatus.OK
        );
        return responseEntity;
    }
}

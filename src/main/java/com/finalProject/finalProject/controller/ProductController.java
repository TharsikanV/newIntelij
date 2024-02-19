package com.finalProject.finalProject.controller;

import com.finalProject.finalProject.comman.APIResponse;
import com.finalProject.finalProject.dto.ProductDTO;
import com.finalProject.finalProject.dto.SignUpRequestDTO;
import com.finalProject.finalProject.entity.Product;
import com.finalProject.finalProject.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;
    @PostMapping("/createProduct")
    public ResponseEntity<APIResponse> createProduct(@RequestBody ProductDTO productDTO){

        APIResponse apiResponse=productService.createProduct(productDTO);
        return ResponseEntity
                .status(apiResponse.getStatus())
                .body(apiResponse);

    }
}

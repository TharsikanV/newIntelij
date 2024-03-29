package com.finalProject.finalProject.controller;

import com.finalProject.finalProject.comman.APIResponse;
import com.finalProject.finalProject.dto.ProductDTO;
import com.finalProject.finalProject.dto.SignUpRequestDTO;
import com.finalProject.finalProject.entity.Product;
import com.finalProject.finalProject.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin("*")
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
    @GetMapping("/products")
    public ResponseEntity<APIResponse> getProducts()
    {
        APIResponse apiResponse=productService.getProducts();
        return ResponseEntity
                .status(apiResponse.getStatus())
                .body(apiResponse);
    }

    @GetMapping("product/{id}")
    public ResponseEntity<APIResponse> getProduct(@PathVariable("id") Long id){
        APIResponse apiResponse = productService.getProduct(id);
        return  ResponseEntity
                .status(apiResponse.getStatus())
                .body(apiResponse);
    }


    @DeleteMapping("/products/{productid}")
    //@RequestMapping(value = "/products/{productid}",method = RequestMethod.DELETE)
    public ResponseEntity<APIResponse> deleteProductById(@PathVariable Long productid){
        APIResponse apiResponse=productService.deleteByProductId(productid);
        return ResponseEntity
                .status(apiResponse.getStatus())
                .body(apiResponse);
    }

    @PutMapping("/products")
    public ResponseEntity<APIResponse> updateProduct(@RequestBody Product incomingProduct){
        APIResponse apiResponse=productService.updateProduct(incomingProduct);
        return ResponseEntity
                .status(apiResponse.getStatus())
                .body(apiResponse);
    }
}

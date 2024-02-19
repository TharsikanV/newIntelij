package com.finalProject.finalProject.service;

import com.finalProject.finalProject.comman.APIResponse;
import com.finalProject.finalProject.dto.ProductDTO;
import com.finalProject.finalProject.entity.Product;
import com.finalProject.finalProject.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    public APIResponse createProduct(ProductDTO productDTO) {
        APIResponse apiResponse=new APIResponse();

        Product product=new Product();
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setLocation(productDTO.getLocation());

        productRepository.save(product);
        apiResponse.setData(product);
        return apiResponse;

    }
}

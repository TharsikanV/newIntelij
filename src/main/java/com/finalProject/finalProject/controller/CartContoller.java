package com.finalProject.finalProject.controller;

import com.finalProject.finalProject.comman.APIResponse;
import com.finalProject.finalProject.dto.CartDto;
import com.finalProject.finalProject.entity.Cart;
import com.finalProject.finalProject.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class CartContoller {
    @Autowired
    CartService cartService;

    @PostMapping("/cart")
    public ResponseEntity<APIResponse> getCartItems(@RequestBody CartDto cartDto){
        APIResponse apiResponse = cartService.getCartItems(cartDto);
        return ResponseEntity
                .status(apiResponse.getStatus())
                .body(apiResponse);
    }

    @PostMapping("/addtoCart")
    public ResponseEntity<APIResponse> addToCart(@RequestBody CartDto cartDto){
        APIResponse apiResponse = cartService.addToCart(cartDto);
        return ResponseEntity
                .status(apiResponse.getStatus())
                .body(apiResponse);
    }

    @PutMapping("/updateCart")
    public ResponseEntity<APIResponse> updateCart(@RequestBody Cart cart){
        APIResponse apiResponse = cartService.updateCart(cart);
        return ResponseEntity
                .status(apiResponse.getStatus())
                .body(apiResponse);
    }

    @DeleteMapping("/deleteCart")
    public  ResponseEntity<APIResponse> deleteCart(@RequestBody CartDto cartDto){
        APIResponse apiResponse = cartService.deleteCart(cartDto);
        return ResponseEntity
                .status(apiResponse.getStatus())
                .body(apiResponse);
    }
}

package com.finalProject.finalProject.service;

import com.finalProject.finalProject.comman.APIResponse;
import com.finalProject.finalProject.dto.CartDto;
import com.finalProject.finalProject.entity.Cart;
import com.finalProject.finalProject.repo.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartService {
    @Autowired
    CartRepository cartRepository;

    public APIResponse getCartItems(CartDto cartDto) {
        APIResponse apiResponse = new APIResponse();
         List<Cart>  cart = cartRepository.findByUserId(cartDto.getUserId());
         apiResponse.setData(cart);
         return apiResponse;
    }

    public APIResponse addToCart(CartDto cartDto) {
        APIResponse apiResponse = new APIResponse();
        Optional<Cart> checkCart = cartRepository.findByUserIdAndProductId(cartDto.getUserId(), cartDto.getProductId());
        if(checkCart.isPresent()){
            apiResponse.setError("Already added to the cart");
            return apiResponse;
        }else{
            cartRepository.save(cartDto.getUserId(),cartDto.getProductId());
            apiResponse.setData("Item added in the cart successfully");
            return apiResponse;
        }
    }

    public APIResponse updateCart(Cart cart) {
        APIResponse apiResponse = new APIResponse();
        cartRepository.save(cart);
        apiResponse.setData("Item updated in the cart successfully");
        return  apiResponse;
    }

    public APIResponse deleteCart(CartDto cartDto) {
        APIResponse apiResponse = new APIResponse();
        cartRepository.deleteById(cartDto.getId());
        apiResponse.setData("Item deleted from cart successfully");
        return apiResponse;
    }
}

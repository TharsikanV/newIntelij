package com.finalProject.finalProject.controller;

import com.finalProject.finalProject.comman.APIResponse;
import com.finalProject.finalProject.dto.OrderDTO;
import com.finalProject.finalProject.dto.ProductDTO;
import com.finalProject.finalProject.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin("*")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @PostMapping("/createOrder")
    public ResponseEntity<APIResponse> createOrder(@RequestBody OrderDTO orderDTO){

        APIResponse apiResponse=orderService.createOrder(orderDTO);
        return ResponseEntity
                .status(apiResponse.getStatus())
                .body(apiResponse);

    }
    @DeleteMapping("/deleteOrder/{Id}")
    public ResponseEntity<APIResponse> deleteOrderById(@PathVariable Long Id){

        APIResponse apiResponse=orderService.deleteOrderById(Id);
        return ResponseEntity
                .status(apiResponse.getStatus())
                .body(apiResponse);

    }
//    public String deleteOrderById(@PathVariable Long Id)
//    {
//        return bookService.deleteBookById(bookId);
//    }


}

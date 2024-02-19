package com.finalProject.finalProject.service;

import com.finalProject.finalProject.comman.APIResponse;
import com.finalProject.finalProject.dto.OrderDTO;
import com.finalProject.finalProject.dto.RequestMeta;
import com.finalProject.finalProject.entity.Order;
import com.finalProject.finalProject.entity.Product;
import com.finalProject.finalProject.repo.OrderRepository;
import com.finalProject.finalProject.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    //new
    @Autowired
    private EmailService emailService;
    @Autowired
    private RequestMeta requestMeta;

    public APIResponse createOrder(OrderDTO orderDTO) {
        APIResponse apiResponse=new APIResponse();

        Order order=new Order();
        order.setName(orderDTO.getName());
        order.setDescription(orderDTO.getDescription());
        order.setPrice(orderDTO.getPrice());
        order.setLocation(orderDTO.getLocation());

        order=orderRepository.save(order);
        sendVerificationEmail(requestMeta.getEmailId(),order.getName(),order.getPrice());

        apiResponse.setData(order);
        return apiResponse;

    }

    public APIResponse deleteOrderById(Long id) {
        APIResponse apiResponse=new APIResponse();
        orderRepository.deleteById(id);
        apiResponse.setData("Order Deleted Successfully");

        return apiResponse;
    }

    private void sendVerificationEmail(String email,String ProductName,String price){
        String subject="Email verification for Order";
        String body="You have ordered: "+ProductName+"  Price : "+price;

        emailService.sendEmail(email,subject,body);
    }


}

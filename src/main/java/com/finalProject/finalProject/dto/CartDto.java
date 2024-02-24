package com.finalProject.finalProject.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Date;

@Data
@Component
public class CartDto {
    private Long id;
    private Long userId;
    private Long productId;
    private Integer quantity;
    private Date createdAt;
}

package com.finalProject.finalProject.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "ORDERS")
public class Order {
    @Id //primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)//hibernate check pannum table ah ithu auto genaartela irukkannu
    private Long id;
    private String name;
    private String description;
    private String price;
    private String location;

    private Date createdAt;
    private Date updatedAt;

    @PrePersist
    public void  onSave(){
        //create at and update at
        Date currentDateTime=new Date();
        this.createdAt=currentDateTime;
        this.updatedAt=currentDateTime;
    }

    @PostPersist
    public void onUpdate(){
        //update at
//        DateTime currentDateTime= new DateTime();
        Date currentDateTime=new Date();
        this.updatedAt=currentDateTime;
    }

}

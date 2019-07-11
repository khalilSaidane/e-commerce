package com.khalil.saidane.ecommerce.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

//@Entity
@Data
public class OrderDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Product product;
    @OneToOne
    private Order order;
    private float price;
    private int quantity;
    private float discount;
    private float total;
    private float size;
    private String color;
    private int isFulfilled;
    private Date shipDate;
    private Date billDate;
}

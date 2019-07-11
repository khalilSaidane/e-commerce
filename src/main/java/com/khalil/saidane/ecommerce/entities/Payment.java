package com.khalil.saidane.ecommerce.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;
     private String paymentType ;
     private int isAllowed;
     @OneToOne
     private Order order;
}

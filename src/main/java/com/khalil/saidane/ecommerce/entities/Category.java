package com.khalil.saidane.ecommerce.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private String pictureUrl;
    private  int isActive;
    @ManyToOne
    private Product product;


}

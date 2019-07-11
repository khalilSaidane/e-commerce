package com.khalil.saidane.ecommerce.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String contactName;
    private  String city;
    private String state;
    private String zipCode;
    private String country;
    private int phone;
    private String Email;
    private String paymentMethods;
    private String discountType;
    private String typeGoods;
    @OneToMany(mappedBy = "supplier")
    private List<Product> products;



}

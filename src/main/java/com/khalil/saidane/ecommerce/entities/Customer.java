package com.khalil.saidane.ecommerce.entities;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Customer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String address;
    private  String city;
    private String state;
    private String zipCode;
    private String country;
    private int phone;
    private String email;
    private String password;
    private String creditCard;
    private String creditCardTypeID;
    private Date cardExp;
    private String billingAddress;
    private String billingCity;
    private String billingRegion;
    private String billingPostalCode;
    private String billingCountry;
    private String shippingAddress;
    private String shippingCity;
    private String shippingRegion;
    private String shippingPostalCode;
    private String shippingCountry;
    @OneToMany(mappedBy = "customer")
    private List<Order_> orders;

}

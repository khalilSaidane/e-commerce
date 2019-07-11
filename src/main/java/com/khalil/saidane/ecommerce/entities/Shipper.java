package com.khalil.saidane.ecommerce.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Shipper {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String companyName;
    private String phone;
    @OneToOne
    private Order order;
}

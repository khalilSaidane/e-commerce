package com.khalil.saidane.ecommerce.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    @OneToMany(mappedBy = "product")
    private List<Category> categories;
    private int quantityPerUnit;
    private float unitPrice;
    private String availableSize;
    private String availableColors;
    private String size;
    private String color;
    private float discount;
    private float unitWeight;
    private int unitsInStock;
    private int unitOnOrder;
    @ManyToOne
    private OrderDetails orderDetails;
    @ManyToOne
    private Supplier supplier;


}

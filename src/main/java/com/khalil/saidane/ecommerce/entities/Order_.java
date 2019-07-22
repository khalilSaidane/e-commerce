package com.khalil.saidane.ecommerce.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Data
public class Order_  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JsonIgnore
    private Customer customer;
    private int orderNumber;
    @OneToOne(mappedBy = "order_")
    @JsonIgnore
    private Payment payment;
    private Date orderDate;
    private Date shipDate;
    private Date requiredDate;
    @JsonIgnore
    @OneToOne(mappedBy = "order_")
    private Shipper shipper;
    private String freight;
    private float salesTax;
    private Date timeStamp;
    private String transactStatus;
    private String errorLoc;
    private String errorMsg;
    private int isFulfilled;
    private int isDeleted;
    private int isPayed;
    private Date paymentDate;
    @OneToOne(mappedBy = "order_")
    private OrderDetails orderDetails;


}

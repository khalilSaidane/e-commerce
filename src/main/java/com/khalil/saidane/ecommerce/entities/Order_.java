package com.khalil.saidane.ecommerce.entities;


import lombok.Data;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Order {
    @Id
    private Long id;
//    @ManyToOne
//    private Customer customer;
  //  private int orderNumber;
//    @OneToOne(mappedBy = "order")
////    private Payment payment;
//    private Date orderDate;
//    private Date shipDate;
//    private Date requiredDate;
//    @OneToOne(mappedBy = "order")
//    private Shipper shipper;
//    private String freight;
//    private float salesTax;
//    private Date timeStamp;
//    private String transactStatus;
//    private String errorLoc;
//    private String errorMsg;
//    private int isFulfilled;
//    private int isDeleted;
//    private int isPayed;
//    private Date paymentDate;
//    @OneToOne(mappedBy = "order")
//    private OrderDetails orderDetails;


}

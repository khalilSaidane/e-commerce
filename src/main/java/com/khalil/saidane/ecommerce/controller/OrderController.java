package com.khalil.saidane.ecommerce.controller;

import com.khalil.saidane.ecommerce.entities.Customer;
import com.khalil.saidane.ecommerce.entities.Order_;
import com.khalil.saidane.ecommerce.entities.Shipper;
import com.khalil.saidane.ecommerce.exeption.ObjectNotFoundException;
import com.khalil.saidane.ecommerce.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("order-management")
public class OrderController {

    @Autowired
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/{id}")
    public Order_ read(@PathVariable Long id) throws ObjectNotFoundException {
        return orderService.read(id);
    }

    @PostMapping
    public Order_ create(@RequestBody Order_ order_) {

        return orderService.create(order_);

    }

    @PutMapping("{id}")
    public Order_ update(@PathVariable Long id, @RequestBody Order_ newOrder_) throws ObjectNotFoundException {
        return orderService.update(id, newOrder_);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) throws ObjectNotFoundException {
        orderService.delete(id);
    }
    @GetMapping
    public List<Order_>readAll(){return orderService.readAll();}

    @PostMapping("customer/{customer_id}/order/{order_id}")
    public Order_ affectOrderToCustomer(@PathVariable Long customer_id, @PathVariable Long order_id) throws ObjectNotFoundException {
        return orderService.affectOrderToCustomer(customer_id, order_id);
    }



}

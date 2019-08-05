package com.khalil.saidane.ecommerce.controller;

import com.khalil.saidane.ecommerce.entities.OrderDetails;
import com.khalil.saidane.ecommerce.exeption.ObjectNotFoundException;
import com.khalil.saidane.ecommerce.service.OrderDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("order-details-management")
public class OrderDetailsController {
    @Autowired
    private OrderDetailsService orderDetailsService;


    @GetMapping("{id}")
    public OrderDetails read(@PathVariable Long id) throws ObjectNotFoundException {
        return orderDetailsService.read(id);
    }

    @PostMapping
    public OrderDetails create(@RequestBody OrderDetails orderDetails) {
        return orderDetailsService.create(orderDetails);
    }

    @PutMapping("/{id}")
    public OrderDetails update(@PathVariable Long id, @RequestBody OrderDetails updatedDetails) throws ObjectNotFoundException {
        return orderDetailsService.update(id, updatedDetails);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) throws ObjectNotFoundException {
        orderDetailsService.delete(id);
    }

    @GetMapping
    public List<OrderDetails> readAll() {
        return orderDetailsService.readAll();
    }


}

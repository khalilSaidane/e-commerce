package com.khalil.saidane.ecommerce.controller;

import com.khalil.saidane.ecommerce.entities.Payment;
import com.khalil.saidane.ecommerce.exeption.ObjectNotFoundException;
import com.khalil.saidane.ecommerce.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("payment-management")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @PostMapping
    public Payment create(@RequestBody Payment payment){
        return paymentService.create(payment);
    }

    @GetMapping("{id}")
    public Payment read(@PathVariable Long id) throws ObjectNotFoundException {
        return paymentService.read(id);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) throws ObjectNotFoundException {
        paymentService.delete(id);
    }

    @PutMapping("{id}")
    public Payment update(@PathVariable Long id,@RequestBody Payment updatedPayment){
        return  paymentService.update(id,updatedPayment);
    }

    @GetMapping
    public List<Payment> readAll(){
        return paymentService.readAll();
    }

    @PostMapping("payment/{payment_id}/order/{order_id}")
    public Payment affectOrderToPayment(@PathVariable Long order_id,@PathVariable Long payment_id) throws ObjectNotFoundException {
        return paymentService.affectOrderToPayment(order_id,payment_id);
    }
}

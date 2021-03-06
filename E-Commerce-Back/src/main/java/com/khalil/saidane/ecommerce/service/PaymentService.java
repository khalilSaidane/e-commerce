package com.khalil.saidane.ecommerce.service;

import com.khalil.saidane.ecommerce.DAO.PaymentRepository;
import com.khalil.saidane.ecommerce.entities.Order_;
import com.khalil.saidane.ecommerce.entities.Payment;
import com.khalil.saidane.ecommerce.exeption.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {
    @Autowired
    private PaymentRepository repo;
    @Autowired
    private OrderService orderService;

    public Payment read(Long id) throws ObjectNotFoundException {
        return repo.findById(id).orElseThrow(()-> new ObjectNotFoundException(Payment.class.getName(),id));
    }

    public Payment create(Payment payment){
        return repo.save(payment);
    }

    public Payment update(Long id , Payment updatedPayment){
        return repo.findById(id).map(payment -> {
            updatedPayment.setId(id);
            return repo.save(updatedPayment);
        }).orElse(
                repo.save(updatedPayment)
        );
    }

    public void delete(Long id) throws ObjectNotFoundException {
        repo.delete(read(id));
    }

    public List<Payment> readAll(){
        return repo.findAll();
    }

    public Payment affectOrderToPayment(Long order_id,Long payment_id) throws ObjectNotFoundException {
        Order_ o = orderService.read(order_id);
        Payment p = read(payment_id);
        p.setOrder_(o);
        return repo.save(p);
    }

}

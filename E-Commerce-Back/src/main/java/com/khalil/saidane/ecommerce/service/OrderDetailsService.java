package com.khalil.saidane.ecommerce.service;

import com.khalil.saidane.ecommerce.DAO.OrderDetailsRepository;
import com.khalil.saidane.ecommerce.entities.OrderDetails;
import com.khalil.saidane.ecommerce.exeption.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailsService {
    @Autowired
    private OrderDetailsRepository repo;


    public OrderDetails read(Long id) throws ObjectNotFoundException {
        return repo.findById(id).orElseThrow(() -> new ObjectNotFoundException(OrderDetails.class.getName(), id));
    }

    public OrderDetails create(OrderDetails orderDetails) {
        return repo.save(orderDetails);
    }

    public OrderDetails update(Long id, OrderDetails updatedOrderDetails) {
        return repo.findById(id).map(orderDetails -> {
            updatedOrderDetails.setId(id);
            return repo.save(updatedOrderDetails);
        }).orElse(
                repo.save(updatedOrderDetails)
        );
    }

    public List<OrderDetails> readAll() {
        return repo.findAll();
    }


    public void delete(Long id) throws ObjectNotFoundException {
        OrderDetails o = read(id);
        repo.delete(o);
    }
}

package com.khalil.saidane.ecommerce.service;

import com.khalil.saidane.ecommerce.DAO.OrderDetailsRepository;
import com.khalil.saidane.ecommerce.entities.OrderDetails;
import com.khalil.saidane.ecommerce.exeption.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailsService {
    private final OrderDetailsRepository repo;

    public OrderDetailsService(OrderDetailsRepository repo) {
        this.repo = repo;
    }

    public OrderDetails read(Long id) throws ObjectNotFoundException {
        return repo.findById(id).orElseThrow(() -> new ObjectNotFoundException(OrderDetails.class.getName(),id));
    }

    public OrderDetails create(OrderDetails orderDetails) {
        return repo.save(orderDetails);
    }

    public OrderDetails update(Long id, OrderDetails newOrderDetails) {
        return repo.findById(id).map(orderDetails -> {
            newOrderDetails.setId(id);
            return repo.save(newOrderDetails);
        }).orElse(
                repo.save(newOrderDetails)
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

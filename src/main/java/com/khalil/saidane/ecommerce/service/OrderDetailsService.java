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
        return repo.findById(id).orElseThrow(() -> new ObjectNotFoundException(id));
    }

    public OrderDetails create(OrderDetails orderDetails) {
        return repo.save(orderDetails);
    }

    public OrderDetails update(Long id, OrderDetails newOrderDetails) throws ObjectNotFoundException {
        OrderDetails orderDetails = read(id);
        newOrderDetails.setId(id);
        return repo.save(newOrderDetails);
    }

    public List<OrderDetails> readAll() {
        return repo.findAll();
    }


    public void delete(Long id) throws ObjectNotFoundException {
        OrderDetails o = read(id);
        repo.delete(o);
    }
}

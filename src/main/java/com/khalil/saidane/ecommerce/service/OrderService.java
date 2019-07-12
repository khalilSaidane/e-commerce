package com.khalil.saidane.ecommerce.service;

import com.khalil.saidane.ecommerce.DAO.OrderRepository;
import com.khalil.saidane.ecommerce.entities.Order_;
import com.khalil.saidane.ecommerce.entities.Shipper;
import com.khalil.saidane.ecommerce.exeption.ObjectNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private final OrderRepository repo;

    public OrderService(OrderRepository repo) {
        this.repo = repo;
    }

    public Order_ read(Long id) throws ObjectNotFoundException {
        return repo.findById(id).orElseThrow(()->new ObjectNotFoundException(id));
    }

    public Order_ create(Order_ order_){
        return repo.save(order_);
    }

    public Order_ update(Long id,Order_ newOrder_) throws ObjectNotFoundException {
        Order_ order_ = read(id);
        newOrder_.setId(id);
        return repo.save(newOrder_);
    }

    public  void delete(Long id) throws ObjectNotFoundException {
        Order_ order_ = read(id);
        repo.delete(order_);
    }

}

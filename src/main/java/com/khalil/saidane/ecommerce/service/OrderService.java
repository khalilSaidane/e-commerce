package com.khalil.saidane.ecommerce.service;

import com.khalil.saidane.ecommerce.DAO.OrderRepository;
import com.khalil.saidane.ecommerce.entities.Customer;
import com.khalil.saidane.ecommerce.entities.Order_;
import com.khalil.saidane.ecommerce.entities.Shipper;
import com.khalil.saidane.ecommerce.exeption.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private final OrderRepository repo;
    private final CustomerService customerService;

    public OrderService(OrderRepository repo,CustomerService customerService) {
        this.repo = repo;
        this.customerService = customerService;
    }

    public Order_ read(Long id) throws ObjectNotFoundException {
        return repo.findById(id).orElseThrow(() -> new ObjectNotFoundException(Order_.class.getName(),id));
    }

    public Order_ create(Order_ order_) {
        return repo.save(order_);
    }

    public Order_ update(Long id, Order_ newOrder_) throws ObjectNotFoundException {
        return repo.findById(id).map(order_ -> {
            newOrder_.setId(id);
            return repo.save(newOrder_);
        }).orElse(
                repo.save(newOrder_)
        );
    }

    public void delete(Long id) throws ObjectNotFoundException {
        Order_ order_ = read(id);
        repo.delete(order_);
    }

    public List<Order_> readAll() {
        return repo.findAll();
    }
    public Order_ affectOrderToCustomer(Long customer_id, Long order_id) throws ObjectNotFoundException {
        Customer c = customerService.read(customer_id);
        Order_ o = read(order_id);
        o.setCustomer(c);
        return repo.save(o);
    }
}

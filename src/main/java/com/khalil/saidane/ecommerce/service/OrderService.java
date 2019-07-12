package com.khalil.saidane.ecommerce.service;

import com.khalil.saidane.ecommerce.DAO.OrderRepository;
import com.khalil.saidane.ecommerce.entities.Customer;
import com.khalil.saidane.ecommerce.entities.Order_;
import com.khalil.saidane.ecommerce.entities.Shipper;
import com.khalil.saidane.ecommerce.exeption.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private  OrderRepository repo;
    @Autowired
    private  CustomerService customerService;



    public Order_ read(Long id) throws ObjectNotFoundException {
        return repo.findById(id).orElseThrow(() -> new ObjectNotFoundException(Order_.class.getName(),id));
    }

    public Order_ create(Order_ order_) {
        return repo.save(order_);
    }

    public Order_ update(Long id, Order_ updatedOrder_) throws ObjectNotFoundException {
        return repo.findById(id).map(order_ -> {
            updatedOrder_.setId(id);
            return repo.save(updatedOrder_);
        }).orElse(
                repo.save(updatedOrder_)
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

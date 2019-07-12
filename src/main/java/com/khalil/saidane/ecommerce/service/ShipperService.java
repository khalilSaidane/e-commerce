package com.khalil.saidane.ecommerce.service;

import com.khalil.saidane.ecommerce.DAO.ShipperRepository;
import com.khalil.saidane.ecommerce.entities.Order_;
import com.khalil.saidane.ecommerce.entities.Shipper;
import com.khalil.saidane.ecommerce.exeption.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShipperService {

    private final ShipperRepository repo;
    private final OrderService orderService;

    public ShipperService(ShipperRepository repo, OrderService orderService) {
        this.repo = repo;
        this.orderService = orderService;
    }

    public Shipper read(Long id) throws ObjectNotFoundException {
        return repo.findById(id).orElseThrow(() -> new ObjectNotFoundException(Shipper.class.getName(),id));
    }

    public Shipper create(Shipper shipper) {
        return repo.save(shipper);
    }

    public Shipper update(Long id, Shipper newShipper) throws ObjectNotFoundException {
        return repo.findById(id).map(shipper -> {
            newShipper.setId(id);
            return repo.save(newShipper);
        }).orElse(
                repo.save(newShipper)
        );
    }

    public void delete(Long id) throws ObjectNotFoundException {
        Shipper shipper = read(id);
        repo.delete(shipper);
    }

    public Shipper affectOrderToShipper(Long shipper_id, Long order_id) throws ObjectNotFoundException {
        Shipper shipper = read(shipper_id);
        Order_ order_ = orderService.read(order_id);
        shipper.setOrder_(order_);
        return repo.save(shipper);
    }

    public List<Shipper> readAll(){return repo.findAll();}
}

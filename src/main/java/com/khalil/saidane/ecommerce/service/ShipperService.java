package com.khalil.saidane.ecommerce.service;

import com.khalil.saidane.ecommerce.DAO.ShipperRepository;
import com.khalil.saidane.ecommerce.entities.Shipper;
import com.khalil.saidane.ecommerce.exeption.ObjectNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Service
public class ShipperService {

    private final ShipperRepository repo;

    public ShipperService(ShipperRepository repo) {
        this.repo = repo;
    }

    public Shipper read(Long id) throws ObjectNotFoundException {
        return repo.findById(id).orElseThrow(()->new ObjectNotFoundException(id));
    }

    public Shipper create(Shipper shipper){
        return repo.save(shipper);
    }

    public Shipper update(Long id ,Shipper newShipper) throws ObjectNotFoundException {
        Shipper shipper = read(id);
        newShipper.setId(id);
        return repo.save(newShipper);
    }

    public void delete(Long id ) throws ObjectNotFoundException {
        Shipper shipper = read(id);
        repo.delete(shipper);
    }
}

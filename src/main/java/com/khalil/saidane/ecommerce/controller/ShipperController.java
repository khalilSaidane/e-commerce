package com.khalil.saidane.ecommerce.controller;

import com.khalil.saidane.ecommerce.entities.Order_;
import com.khalil.saidane.ecommerce.entities.Shipper;
import com.khalil.saidane.ecommerce.exeption.ObjectNotFoundException;
import com.khalil.saidane.ecommerce.service.ShipperService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("shipper-management")
public class ShipperController {

    private  ShipperService shipperService;


    @PostMapping
    public Shipper create(@RequestBody Shipper shipper) {
        return shipperService.create(shipper);
    }

    @GetMapping("{id}")
    public Shipper read(@PathVariable Long id) throws ObjectNotFoundException {
        return shipperService.read(id);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) throws ObjectNotFoundException {
        shipperService.delete(id);
    }

    @PutMapping("{id}")
    public Shipper update(@PathVariable Long id, @RequestBody Shipper newShipper) throws ObjectNotFoundException {
        return shipperService.update(id, newShipper);
    }

    @PostMapping("shipper/{shipper_id}/order/{order_id}")
    public Shipper affectOrderToShipper(@PathVariable Long shipper_id, @PathVariable Long order_id) throws ObjectNotFoundException {
        return shipperService.affectOrderToShipper(shipper_id, order_id);
    }

    @GetMapping
    public List<Shipper> readAll(){return shipperService.readAll();}


}

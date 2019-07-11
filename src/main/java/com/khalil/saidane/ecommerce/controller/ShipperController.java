package com.khalil.saidane.ecommerce.controller;

import com.khalil.saidane.ecommerce.entities.Shipper;
import com.khalil.saidane.ecommerce.exeption.ObjectNotFoundException;
import com.khalil.saidane.ecommerce.service.ShipperService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("shipper-management")
public class ShipperController {

    private final ShipperService shipperService;

    public ShipperController(ShipperService shipperService) {
        this.shipperService = shipperService;
    }

    @PostMapping
    public Shipper create(@RequestBody Shipper shipper){
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
    public Shipper update(@PathVariable Long id,@RequestBody Shipper newShipper ) throws ObjectNotFoundException {
        return shipperService.update(id,newShipper);
    }



}

package com.makersharks.Assignment.Controller;

import com.makersharks.Assignment.Entity.ManufacturingProcess;
import com.makersharks.Assignment.Entity.NatureOfBusiness;
import com.makersharks.Assignment.Entity.Supplier;
import com.makersharks.Assignment.Exception.SupplierNotFoundException;
import com.makersharks.Assignment.Service.SupplierService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/supplier")
public class SupplierController {

    @Autowired
    private SupplierService service;

    @PostMapping("/add")
    public Supplier addSupplier(@RequestBody Supplier newSupplier) {
        return service.addSupplier(newSupplier);
    }

    @GetMapping("/query")
    public ResponseEntity<Page<Supplier>> searchSupplier(@RequestParam String location,
                                                         @RequestParam NatureOfBusiness natureOfBusiness,
                                                         @RequestParam ManufacturingProcess process,
                                                         @RequestParam(defaultValue = "10") int size) {
        Page<Supplier> result = service.specifiedSupplier(location, natureOfBusiness, process, size);
        if (result.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(result);
        }
        return ResponseEntity.ok(result);
    }
}


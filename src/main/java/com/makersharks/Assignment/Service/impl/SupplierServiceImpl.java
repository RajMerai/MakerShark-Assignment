package com.makersharks.Assignment.Service.impl;


import com.makersharks.Assignment.Entity.ManufacturingProcess;
import com.makersharks.Assignment.Entity.NatureOfBusiness;
import com.makersharks.Assignment.Entity.Supplier;
import com.makersharks.Assignment.Exception.SupplierNotFoundException;
import com.makersharks.Assignment.Repository.SupplierRepository;
import com.makersharks.Assignment.Service.SupplierService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    private SupplierRepository repository;

    @Override
    public Supplier addSupplier(Supplier newSupplier){
        return repository.save(newSupplier);
    }
    @Override
    public Page<Supplier> specifiedSupplier(String location, NatureOfBusiness natureOfBusiness,
                                            ManufacturingProcess process, int size) {
        Pageable pageable = Pageable.ofSize(size);
        Page<Supplier> suppliers = repository.findSuppliers(location, natureOfBusiness, process, pageable);
        if(suppliers.isEmpty()) {
            throw new SupplierNotFoundException("Requested Supplier does not found");
        }
        return suppliers;
    }



}


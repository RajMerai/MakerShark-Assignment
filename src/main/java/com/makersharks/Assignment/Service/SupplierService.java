package com.makersharks.Assignment.Service;

import org.springframework.data.domain.Page;

import com.makersharks.Assignment.Entity.ManufacturingProcess;
import com.makersharks.Assignment.Entity.NatureOfBusiness;
import com.makersharks.Assignment.Entity.Supplier;

import java.util.List;

public interface SupplierService {

   Supplier addSupplier(Supplier supplier);

   Page<Supplier> specifiedSupplier(String location, NatureOfBusiness natureOfBusiness,
                                      ManufacturingProcess process, int size);
}

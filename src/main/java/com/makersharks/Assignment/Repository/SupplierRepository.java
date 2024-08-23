package com.makersharks.Assignment.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.makersharks.Assignment.Entity.ManufacturingProcess;
import com.makersharks.Assignment.Entity.NatureOfBusiness;
import com.makersharks.Assignment.Entity.Supplier;

import java.util.List;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {

    @Query("SELECT s FROM Supplier s WHERE s.location = :location AND s.natureOfBusiness = :natureOfBusiness AND :process MEMBER OF s.manufacturingProcesses")
    public Page<Supplier> findSuppliers(@Param("location") String location,
                                        @Param("natureOfBusiness") NatureOfBusiness natureOfBusiness,
                                        @Param("process") ManufacturingProcess process,
                                        Pageable pageable);

}

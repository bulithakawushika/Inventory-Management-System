package com.uok.oop.ims.service;

import com.uok.oop.ims.model.Supplier;
import com.uok.oop.ims.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SupplierService {

    @Autowired
    SupplierRepository supplierRepository;

    // Add a new supplier to the database
    public void addSupplier(Supplier supplier){
        supplierRepository.save(supplier);
    }

    // Retrieve all suppliers from the database
    public List<Supplier> getAllSuppliers(){
        return supplierRepository.findAll();
    }

    // Retrieve a supplier by its unique ID
    public Supplier getSupplierById(String id) {
        Optional<Supplier> optional = supplierRepository.findById(id);
        Supplier supplier = null;
        if (optional.isPresent()) {
            supplier = optional.get();
        } else {
            throw new RuntimeException("Supplier not found by id:: " + id);
        }
        return supplier;
    }

    // Delete a supplier from the database by its ID
    public void deleteSupplierById(String id) {
        this.supplierRepository.deleteById(id);
    }

    // Get the total number of suppliers in the database
    public long getTotalSuppliers() {
        return supplierRepository.count();
    }
}

package com.uok.oop.ims.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "supplier")
public class Supplier {
    @Id
    @Column(name = "suppliier_id")
    private String supplierId;               // Supplier ID
    @Column(name = "supplier_name")
    private String supplierName;             // Supplier name
    @Column(name = "suppliier_nic")
    private String supplierNIC;              // Supplier NIC (National Identification Card)
    @Column(name = "contact_number")
    private String supplierContactNumber;    // Supplier contact number
    @Column(name = "email")
    private String email;                    // Supplier email address
    @Column(name = "address")
    private String address;                  // Supplier address

    // Constructors
    public Supplier() {
    }

    public Supplier(String supplierId, String supplierName, String supplierNIC, String supplierContactNumber, String email, String address) {
        this.supplierId = supplierId;
        this.supplierName = supplierName;
        this.supplierNIC = supplierNIC;
        this.supplierContactNumber = supplierContactNumber;
        this.email = email;
        this.address = address;
    }

    // Getter and setter methods for each field

    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getSupplierNIC() {
        return supplierNIC;
    }

    public void setSupplierNIC(String supplierNIC) {
        this.supplierNIC = supplierNIC;
    }

    public String getSupplierContactNumber() {
        return supplierContactNumber;
    }

    public void setSupplierContactNumber(String supplierContactNumber) {
        this.supplierContactNumber = supplierContactNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

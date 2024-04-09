package com.uok.oop.ims.controller;

import com.uok.oop.ims.dto.SupplierDto;
import com.uok.oop.ims.model.Item;
import com.uok.oop.ims.model.Supplier;
import com.uok.oop.ims.repository.SupplierRepository;
import com.uok.oop.ims.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SupplierController {

    @Autowired
    SupplierService supplierService;

    // Display the form for adding a new supplier.
    @GetMapping("/add-supplier")
    public String addSuppliersForm(Model model){
        // Add a new SupplierDto object to the model for populating the form.
        model.addAttribute("supplier", new SupplierDto());
        // Add a success attribute to the model to indicate a successful operation.
        model.addAttribute("success", true);
        // Return the "add-supplier" view where the form will be displayed.
        return "add-supplier";
    }

    // Handle the submission of the supplier form.
    @RequestMapping("/submit-supplier")
    public String submitSupplierForm(@ModelAttribute Supplier supplier){
        // Create a new Supplier object from the submitted data.
        Supplier newSupplier = new Supplier(supplier.getSupplierId(), supplier.getSupplierName(), supplier.getSupplierNIC(), supplier.getSupplierContactNumber(), supplier.getEmail(), supplier.getAddress());
        // Call the addSupplier method of the SupplierService to add the new supplier.
        supplierService.addSupplier(newSupplier);
        // Redirect to the supplier list after successful submission.
        return "redirect:/supplier-list";
    }

    // Display a list of all suppliers.
    @GetMapping("/supplier-list")
    public String showSupplierList(Model model){
        // Retrieve a list of all suppliers from the SupplierService.
        model.addAttribute("supplierList", supplierService.getAllSuppliers());
        // Return the "supplier-list" view to display the list of suppliers.
        return "supplier-list";
    }

    // Display the form for updating a supplier.
    @GetMapping("/showSupplierForUpdate/{id}")
    public String showSupplierForUpdate(@PathVariable(value = "id") String id, Model model){
        // Retrieve the supplier to be updated by its ID.
        Supplier supplier = supplierService.getSupplierById(id);
        // Add the supplier object to the model to populate the form.
        model.addAttribute("supplier", supplier);
        // Return the "/add-supplier" view to display the update form.
        return "/add-supplier";
    }

    // Handle the request to delete a supplier.
    @GetMapping("/deleteSupplier/{id}")
    public String deleteSupplier(@PathVariable(value = "id") String id){
        // Call the deleteSupplierById method of the SupplierService to delete the supplier by ID.
        supplierService.deleteSupplierById(id);
        // Redirect to the supplier list after successful deletion.
        return "redirect:/supplier-list";
    }
}

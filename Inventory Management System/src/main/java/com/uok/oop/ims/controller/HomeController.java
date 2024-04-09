package com.uok.oop.ims.controller;

import com.uok.oop.ims.service.ClientService;
import com.uok.oop.ims.service.ItemService;
import com.uok.oop.ims.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    // Autowire the ItemService, SupplierService, and ClientService to access their functionality.
    @Autowired
    private ItemService itemService;
    @Autowired
    private SupplierService supplierService;
    @Autowired
    private ClientService clientService;

    // Handle the request for the home page.
    @GetMapping("/")
    public String home(Model model) {
        // Retrieve and calculate various statistics using the injected services.
        long totalItems = itemService.getTotalItems();
        long totalSuppliers = supplierService.getTotalSuppliers();
        long totalCustomers = clientService.getTotalCustomers();

        // Add these statistics as attributes to the Model for displaying in the view.
        model.addAttribute("totalItems", totalItems);
        model.addAttribute("totalSuppliers", totalSuppliers);
        model.addAttribute("totalCustomers", totalCustomers);
        model.addAttribute("totalQuantity", itemService.getTotalQuantityOfAllItems());
        model.addAttribute("totalExpenditure", itemService.getTotalExpenditureForAllItems());
        model.addAttribute("totalRevenue", itemService.getTotalRevenue());
        model.addAttribute("totalProjectedIncome", itemService.getProjectedIncome());

        // Return the "home" view to display these statistics on the home page.
        return "home";
    }

    // Handle the request for the report page.
    @GetMapping("/report")
    public String report(Model model){
        // Retrieve lists of items, suppliers, and clients using the injected services.
        model.addAttribute("itemList", itemService.getAllItems());
        model.addAttribute("supplierList", supplierService.getAllSuppliers());
        model.addAttribute("customerList", clientService.getAllClients());

        // Return the "report" view to display these lists for reporting purposes.
        return "report";
    }
}

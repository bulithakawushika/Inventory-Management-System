package com.uok.oop.ims.service;

import com.uok.oop.ims.model.Item;
import com.uok.oop.ims.model.Supplier;
import com.uok.oop.ims.repository.ItemRepository;
import com.uok.oop.ims.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ItemService {

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    SupplierRepository supplierRepository;

    // Add a new item to the database
    public void addItems(Item item) {
        itemRepository.save(item);
    }

    // Retrieve all items from the database
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    // Retrieve an item by its unique ID
    public Item getItemById(String id) {
        Optional<Item> optional = itemRepository.findById(id);
        Item item = null;
        if (optional.isPresent()) {
            item = optional.get();
        } else {
            throw new RuntimeException("Item not found by id:: " + id);
        }
        return item;
    }

    // Add a new item to the database with validation for the supplier's existence
    public void addNewItems(Item item) {
        // Check if the supplier exists in the database
        String supplierId = item.getSupplier().getSupplierId();
        if (supplierRepository.existsById(supplierId)) {
            itemRepository.save(item);
        } else {
            // Supplier does not exist, handle the error or throw an exception
            throw new RuntimeException("Supplier does not exist");
        }
    }

    // Delete an item from the database by its ID
    public void deleteItemById(String id) {
        this.itemRepository.deleteById(id);
    }

    // Get the total number of items in the database
    public long getTotalItems() {
        return itemRepository.count();
    }

    // Calculate the total quantity of all items in the database
    public int getTotalQuantityOfAllItems() {
        Integer totalQuantity = itemRepository.sumTotalQuantity();
        return totalQuantity != null ? totalQuantity : 0;
    }

    // Calculate the total expenditure for all items (buy price * quantity)
    public double getTotalExpenditureForAllItems() {
        List<Item> items = itemRepository.findAll();
        double totalExpenditure = 0.0;

        for (Item item : items) {
            double itemExpenditure = item.getBuyPrice() * item.getQuantity();
            totalExpenditure += itemExpenditure;
        }

        return totalExpenditure;
    }

    // Calculate the total revenue for all items (sell price * quantity)
    public double getTotalRevenue() {
        List<Item> items = itemRepository.findAll();
        double totalRevenue = 0.0;

        for (Item item : items) {
            double itemRevenue = item.getSellPrice() * item.getQuantity();
            totalRevenue += itemRevenue;
        }

        return totalRevenue;
    }

    // Calculate the projected income (total revenue - total expenditure)
    public double getProjectedIncome() {
        List<Item> items = itemRepository.findAll();
        double totalProjectedIncome = 0.0;

        for (Item item : items) {
            double itemIncome = (item.getSellPrice() * item.getQuantity()) - (item.getBuyPrice() * item.getQuantity());
            totalProjectedIncome += itemIncome;
        }

        return totalProjectedIncome;
    }
}

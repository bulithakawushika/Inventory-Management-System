package com.uok.oop.ims.dto;

import com.uok.oop.ims.model.Supplier;
import jakarta.persistence.Column;

public class ItemDto {
    private String itemId;       // Item ID
    private String itemName;     // Item name
    private String description;  // Item description
    private double buyPrice;    // Purchase price
    private double sellPrice;   // Selling price
    private int quantity;       // Quantity in stock
    private String imageUrl;    // URL for item image
    private Supplier supplier;  // Supplier information

    // Getter and setter methods for each field

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(double buyPrice) {
        this.buyPrice = buyPrice;
    }

    public double getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(double sellPrice) {
        this.sellPrice = sellPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }
}

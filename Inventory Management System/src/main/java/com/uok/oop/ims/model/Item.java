package com.uok.oop.ims.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Item")
public class Item {
    @Id
    @Column(name = "item_Id")
    private String itemId;         // Item ID
    @Column(name = "item_name")
    private String itemName;       // Item name
    @Column(name = "description")
    private String description;    // Item description
    @Column(name = "buy_price")
    private double buyPrice;      // Purchase price
    @Column(name = "sell_price")
    private double sellPrice;     // Selling price
    @Column(name = "quantity")
    private int quantity;         // Quantity in stock
    @Column(name = "imageUrl")
    private String imageUrl;      // URL for item image

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;    // Supplier information

    // Constructors
    public Item() {
    }

    public Item(String itemId, String itemName, String description, double buyPrice, double sellPrice, int quantity, String imageUrl, Supplier supplier) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.description = description;
        this.buyPrice = buyPrice;
        this.sellPrice = sellPrice;
        this.quantity = quantity;
        this.imageUrl = imageUrl;
        this.supplier = supplier;
    }

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

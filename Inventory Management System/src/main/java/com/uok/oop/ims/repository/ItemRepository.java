package com.uok.oop.ims.repository;

import com.uok.oop.ims.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, String> {

    // Custom query to calculate the sum of total quantity for all items
    @Query("SELECT SUM(i.quantity) FROM Item i")
    Integer sumTotalQuantity();
}

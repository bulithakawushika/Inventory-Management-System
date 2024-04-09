package com.uok.oop.ims.controller;

import com.uok.oop.ims.dto.ItemDto;
import com.uok.oop.ims.model.Item;
import com.uok.oop.ims.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ItemController {

    @Autowired
    ItemService itemService;

    // Display the form for adding a new item.
    @GetMapping("/add-item")
    public String addItemsForm(Model model) {
        model.addAttribute("item", new ItemDto());
        model.addAttribute("success", true);
        return "add-item";
    }

    // Handle the submission of the item form.
    @RequestMapping("/submit-item")
    public String submitItemForm(@ModelAttribute ItemDto item, Model model) {
        try {
            // Create a new Item object from the submitted data.
            Item newItem = new Item(item.getItemId(), item.getItemName(), item.getDescription(), item.getBuyPrice(), item.getSellPrice(), item.getQuantity(), item.getImageUrl(), item.getSupplier());

            // Call the addNewItems method of the ItemService to add the new item.
            itemService.addNewItems(newItem);

            // Redirect to the item list after successful submission.
            return "redirect:/item-list";
        } catch (RuntimeException e) {
            // Handle the error by adding an error message to the model.
            model.addAttribute("error", true);
            // Return to the add-item page with the error message.
            return "redirect:/add-item?error";
        }
    }

    // Display the details of a specific item.
    @GetMapping("/view-item/{id}")
    public String viewItem(@PathVariable(value = "id") String id, Model model) {
        // Retrieve the item to be viewed by its ID.
        Item itemShow = itemService.getItemById(id);
        // Add the item object to the model for display.
        model.addAttribute("item", itemShow);
        return "view-item";
    }

    // Display a list of all items.
    @GetMapping("/item-list")
    public String showItemList(Model model) {
        // Retrieve a list of all items from the ItemService.
        model.addAttribute("itemList", itemService.getAllItems());
        return "item-list";
    }

    // Display the form for updating an item.
    @GetMapping("/showItemForUpdate/{id}")
    public String showItemForUpdate(@PathVariable(value = "id") String id, Model model) {
        // Retrieve the item to be updated by its ID.
        Item item = itemService.getItemById(id);
        // Add the item object to the model to populate the form.
        model.addAttribute("item", item);
        return "/add-item";
    }

    // Handle the request to delete an item.
    @GetMapping("/deleteItem/{id}")
    public String deleteItem(@PathVariable(value = "id") String id) {
        // Call the deleteItemById method of the ItemService to delete the item by ID.
        itemService.deleteItemById(id);
        // Redirect to the item list after successful deletion.
        return "redirect:/item-list";
    }
}

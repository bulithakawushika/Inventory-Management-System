package com.uok.oop.ims.controller;

import com.uok.oop.ims.dto.ClientDto;
import com.uok.oop.ims.model.Client;
import com.uok.oop.ims.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Controller
public class ClientController {
    @Autowired
    ClientService clientservice;

    // Display the form for adding a new client.
    @GetMapping("/add-client")
    public String addClientForm(Model model) {
        // Add a new ClientDto object to the model for populating the form.
        model.addAttribute("client", new ClientDto());
        // Add a success attribute to the model to indicate a successful operation.
        model.addAttribute("success", true);
        // Return the "add-client" view where the form will be displayed.
        return "add-client";
    }

    // Handle the submission of the client form.
    @RequestMapping("/submit-client")
    public String submitAddClient(@ModelAttribute ClientDto client) {
        // Create a new Client object from the submitted data.
        Client newclient = new Client(client.getClient_id(), client.getClient_NIC(), client.getClient_name(), client.getClient_address(), client.getClient_contact(), client.getClient_email());
        // Call the addClient method of the ClientService to add the new client.
        clientservice.addClient(newclient);
        // Redirect to the client list after successful submission.
        return "redirect:/client-list";
    }

    // Display a list of all clients.
    @GetMapping("/client-list")
    public String getClients(Model model) {
        // Retrieve a list of all clients from the ClientService.
        List<Client> clientList = clientservice.getAllClients();
        // Add the clientList to the model to be displayed in the view.
        model.addAttribute("clientList", clientList);
        // Return the "client-list" view to display the list of clients.
        return "client-list";
    }

    // Display the form for updating a client.
    @GetMapping("/update-client/{id}")
    public String showClientForUpdate(@PathVariable(value = "id") String id, Model model){
        // Retrieve the client to be updated by its ID.
        Client client = clientservice.getClientById(id);
        // Add the client object to the model to populate the form.
        model.addAttribute("client", client);
        // Return the "/add-client" view to display the update form.
        return "/add-client";
    }

    // Handle the request to delete a client.
    @GetMapping("/delete-client/{id}")
    public String deleteClient(@PathVariable(value = "id") String id) {
        // Call the deleteClientById method of the ClientService to delete the client by ID.
        clientservice.deleteClientById(id);
        // Redirect to the client list after successful deletion.
        return "redirect:/client-list";
    }
}

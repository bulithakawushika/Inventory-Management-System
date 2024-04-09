package com.uok.oop.ims.controller;

import com.uok.oop.ims.model.Client;
import com.uok.oop.ims.model.Item;
import com.uok.oop.ims.model.Supplier;
import com.uok.oop.ims.repository.ClientRepository;
import com.uok.oop.ims.repository.ItemRepository;
import com.uok.oop.ims.repository.SupplierRepository;
import com.uok.oop.ims.service.DatabasePDFService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

@Controller
public class PDFExportController {

    @Autowired
    ItemRepository itemRepository;
    @Autowired
    ClientRepository clientRepository;
    @Autowired
    SupplierRepository supplierRepository;
    @Autowired
    DatabasePDFService databasePDFService;

    // Generate a PDF report for items and return it as a ResponseEntity.
    @GetMapping(value = "/report/item-pdf", produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> itemReport()  throws IOException {
        // Retrieve a list of items from the item repository.
        List<Item> items = (List<Item>) itemRepository.findAll();

        // Generate a PDF report for items using the DatabasePDFService.
        ByteArrayInputStream itemPDFReport = DatabasePDFService.itemPDFReport(items);

        // Set headers for the response.
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename = items.pdf");

        // Return the ResponseEntity with the PDF report content.
        return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(itemPDFReport));
    }

    // Generate a PDF report for customers and return it as a ResponseEntity.
    @GetMapping(value = "/report/customer-pdf", produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> customerReport()  throws IOException {
        // Retrieve a list of clients from the client repository.
        List<Client> clients = (List<Client>) clientRepository.findAll();

        // Generate a PDF report for clients using the DatabasePDFService.
        ByteArrayInputStream clientPDFReport = DatabasePDFService.clientPDFReport(clients);

        // Set headers for the response.
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename = customer.pdf");

        // Return the ResponseEntity with the PDF report content.
        return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(clientPDFReport));
    }

    // Generate a PDF report for suppliers and return it as a ResponseEntity.
    @GetMapping(value = "/report/supplier-pdf", produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> supplierReport()  throws IOException {
        // Retrieve a list of suppliers from the supplier repository.
        List<Supplier> suppliers = (List<Supplier>) supplierRepository.findAll();

        // Generate a PDF report for suppliers using the DatabasePDFService.
        ByteArrayInputStream supplierPDFReport = DatabasePDFService.supplierPDFReport(suppliers);

        // Set headers for the response.
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename = suppliers.pdf");

        // Return the ResponseEntity with the PDF report content.
        return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(supplierPDFReport));
    }
}

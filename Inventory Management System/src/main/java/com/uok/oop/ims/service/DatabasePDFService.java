package com.uok.oop.ims.service;

import com.lowagie.text.pdf.*;
import com.uok.oop.ims.model.Client;
import com.uok.oop.ims.model.Item;
import com.uok.oop.ims.model.Supplier;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.stream.Stream;

import java.awt.Color;
import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DatabasePDFService {

    public static ByteArrayInputStream itemPDFReport(List<Item> items) {
        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try {

            PdfWriter.getInstance(document, out);
            document.open();

            // Add Content to PDF file ->
            Font fontHeader = FontFactory.getFont(FontFactory.TIMES_BOLD, 22);
            Paragraph para = new Paragraph("Items", fontHeader);
            para.setAlignment(Element.ALIGN_CENTER);
            document.add(para);
            document.add(Chunk.NEWLINE);

            PdfPTable itemTable = new PdfPTable(6);
            // Add PDF Table Header ->
            Stream.of("ID", "Item Name","Description", "Buy Price", "Sell Price", "Quantity").forEach(headerTitle -> {
                PdfPCell header = new PdfPCell();
                Font headFont = FontFactory.getFont(FontFactory.TIMES_BOLD);
                header.setBackgroundColor(Color.WHITE);
                header.setHorizontalAlignment(Element.ALIGN_CENTER);
                header.setBorderWidth(2);
                header.setPhrase(new Phrase(headerTitle, headFont));
                itemTable.addCell(header);
            });

            for (Item item : items) {
                PdfPCell idCell = new PdfPCell(new Phrase(item.getItemId()));
                idCell.setPaddingLeft(4);
                idCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                idCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                itemTable.addCell(idCell);

                PdfPCell itemNameCell = new PdfPCell(new Phrase(item.getItemName()));
                itemNameCell.setPaddingLeft(4);
                itemNameCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                itemNameCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                itemTable.addCell(itemNameCell);

                PdfPCell descriptionCell = new PdfPCell(new Phrase(item.getDescription()));
                descriptionCell.setPaddingLeft(4);
                descriptionCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                descriptionCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                itemTable.addCell(descriptionCell);

                PdfPCell buyPriceCell = new PdfPCell(new Phrase(String.valueOf(item.getBuyPrice())));
                buyPriceCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                buyPriceCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                buyPriceCell.setPaddingRight(4);
                itemTable.addCell(buyPriceCell);

                PdfPCell sellPriceCell = new PdfPCell(new Phrase(String.valueOf(item.getSellPrice())));
                sellPriceCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                sellPriceCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                sellPriceCell.setPaddingRight(4);
                itemTable.addCell(sellPriceCell);

                PdfPCell QuantityCell = new PdfPCell(new Phrase(String.valueOf(item.getQuantity())));
                QuantityCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                QuantityCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                QuantityCell.setPaddingRight(4);
                itemTable.addCell(QuantityCell);
            }
            document.add(itemTable);

            document.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        }

        return new ByteArrayInputStream(out.toByteArray());
    }

    public static ByteArrayInputStream clientPDFReport(List<Client> clients) {
        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try {

            PdfWriter.getInstance(document, out);
            document.open();

            // Add Content to PDF file ->
            Font fontHeader = FontFactory.getFont(FontFactory.TIMES_BOLD, 22);
            Paragraph para = new Paragraph("Customers", fontHeader);
            para.setAlignment(Element.ALIGN_CENTER);
            document.add(para);
            document.add(Chunk.NEWLINE);

            PdfPTable clientTable = new PdfPTable(6);
            // Add PDF Table Header ->
            Stream.of("ID", "Client Name", "Email","NIC", "Contact No.", "Address").forEach(headerTitle -> {
                PdfPCell header = new PdfPCell();
                Font headFont = FontFactory.getFont(FontFactory.TIMES_BOLD);
                header.setBackgroundColor(Color.WHITE);
                header.setHorizontalAlignment(Element.ALIGN_CENTER);
                header.setBorderWidth(2);
                header.setPhrase(new Phrase(headerTitle, headFont));
                clientTable.addCell(header);
            });

            for (Client client : clients) {
                PdfPCell idCell = new PdfPCell(new Phrase(client.getClient_id()));
                idCell.setPaddingLeft(4);
                idCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                idCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                clientTable.addCell(idCell);

                PdfPCell NameCell = new PdfPCell(new Phrase(client.getClient_name()));
                NameCell.setPaddingLeft(4);
                NameCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                NameCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                clientTable.addCell(NameCell);

                PdfPCell emailCell = new PdfPCell(new Phrase(String.valueOf(client.getClient_email())));
                emailCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                emailCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                emailCell.setPaddingRight(4);
                clientTable.addCell(emailCell);

                PdfPCell nicCell = new PdfPCell(new Phrase(String.valueOf(client.getClient_NIC())));
                nicCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                nicCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                nicCell.setPaddingRight(4);
                clientTable.addCell(nicCell);

                PdfPCell contactCell = new PdfPCell(new Phrase(String.valueOf(client.getClient_contact())));
                contactCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                contactCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                contactCell.setPaddingRight(4);
                clientTable.addCell(contactCell);

                PdfPCell addressCell = new PdfPCell(new Phrase(String.valueOf(client.getClient_address())));
                addressCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                addressCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                addressCell.setPaddingRight(4);
                clientTable.addCell(addressCell);
            }
            document.add(clientTable);

            document.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        }

        return new ByteArrayInputStream(out.toByteArray());
    }

    public static ByteArrayInputStream supplierPDFReport(List<Supplier> suppliers) {
        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try {

            PdfWriter.getInstance(document, out);
            document.open();

            // Add Content to PDF file ->
            Font fontHeader = FontFactory.getFont(FontFactory.TIMES_BOLD, 22);
            Paragraph para = new Paragraph("Suppliers", fontHeader);
            para.setAlignment(Element.ALIGN_CENTER);
            document.add(para);
            document.add(Chunk.NEWLINE);

            PdfPTable clientTable = new PdfPTable(6);
            // Add PDF Table Header ->
            Stream.of("ID", "Supplier Name", "Email","NIC", "Contact No.", "Address").forEach(headerTitle -> {
                PdfPCell header = new PdfPCell();
                Font headFont = FontFactory.getFont(FontFactory.TIMES_BOLD);
                header.setBackgroundColor(Color.WHITE);
                header.setHorizontalAlignment(Element.ALIGN_CENTER);
                header.setBorderWidth(2);
                header.setPhrase(new Phrase(headerTitle, headFont));
                clientTable.addCell(header);
            });

            for (Supplier supplier : suppliers) {
                PdfPCell idCell = new PdfPCell(new Phrase(supplier.getSupplierId()));
                idCell.setPaddingLeft(4);
                idCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                idCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                clientTable.addCell(idCell);

                PdfPCell NameCell = new PdfPCell(new Phrase(supplier.getSupplierName()));
                NameCell.setPaddingLeft(4);
                NameCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                NameCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                clientTable.addCell(NameCell);

                PdfPCell emailCell = new PdfPCell(new Phrase(String.valueOf(supplier.getEmail())));
                emailCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                emailCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                emailCell.setPaddingRight(4);
                clientTable.addCell(emailCell);

                PdfPCell nicCell = new PdfPCell(new Phrase(String.valueOf(supplier.getSupplierNIC())));
                nicCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                nicCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                nicCell.setPaddingRight(4);
                clientTable.addCell(nicCell);

                PdfPCell contactCell = new PdfPCell(new Phrase(String.valueOf(supplier.getSupplierContactNumber())));
                contactCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                contactCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                contactCell.setPaddingRight(4);
                clientTable.addCell(contactCell);

                PdfPCell addressCell = new PdfPCell(new Phrase(String.valueOf(supplier.getAddress())));
                addressCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                addressCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                addressCell.setPaddingRight(4);
                clientTable.addCell(addressCell);
            }
            document.add(clientTable);

            document.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        }

        return new ByteArrayInputStream(out.toByteArray());
    }

}

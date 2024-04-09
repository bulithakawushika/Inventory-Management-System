package com.uok.oop.ims.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClientDto {
    private String client_id;       // Client's ID
    private String client_NIC;      // Client's NIC (National Identity Card) number
    private String client_name;     // Client's name
    private String client_address;  // Client's address
    private String client_contact;  // Client's contact information
    private String client_email;    // Client's email address
}

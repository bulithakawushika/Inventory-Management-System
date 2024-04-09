package com.uok.oop.ims.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor  // Lombok annotation to generate an all-arguments constructor
@NoArgsConstructor   // Lombok annotation to generate a no-arguments constructor
@Data                // Lombok annotation to generate getter, setter, toString, equals, and hashCode methods
@Entity              // Specifies that this class is an entity
@Table(name = "client_details")  // Specifies the name of the database table associated with this entity
public class Client {
    @Id                     // Marks this field as the primary key
    private String client_id;       // Client's ID
    private String client_NIC;      // Client's NIC (National Identity Card) number
    private String client_name;     // Client's name
    private String client_address;  // Client's address
    private String client_contact;  // Client's contact information
    private String client_email;    // Client's email address
}

package com.uok.oop.ims.model;

import jakarta.persistence.*;

@Entity
@Table(name = "role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;     // Role ID
    private String name; // Role name

    // Constructors
    public Role(String name) {
        this.name = name;
    }

    public Role() {
    }

    // Getter and setter methods for each field

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

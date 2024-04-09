package com.uok.oop.ims.repository;

import com.uok.oop.ims.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, String> {
    // Custom query to retrieve a client by client_id using native SQL query
    @Query(value = "SELECT * FROM CLIENT_DETAILS WHERE CLIENT_ID = ?1", nativeQuery = true)
    Client getClientByClient_id(String client_id);
}

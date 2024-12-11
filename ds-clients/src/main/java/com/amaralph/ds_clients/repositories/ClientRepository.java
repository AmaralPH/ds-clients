package com.amaralph.ds_clients.repositories;

import com.amaralph.ds_clients.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}

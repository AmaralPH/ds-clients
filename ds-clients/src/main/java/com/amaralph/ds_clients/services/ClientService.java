package com.amaralph.ds_clients.services;

import com.amaralph.ds_clients.dto.ClientDTO;
import com.amaralph.ds_clients.entities.Client;
import com.amaralph.ds_clients.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public Page<ClientDTO> findAll(Pageable pageable) {
        Page<Client> result = clientRepository.findAll(pageable);
        return result.map(x -> new ClientDTO(x));
    }
}

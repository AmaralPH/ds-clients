package com.amaralph.ds_clients.services;

import com.amaralph.ds_clients.dto.ClientDTO;
import com.amaralph.ds_clients.entities.Client;
import com.amaralph.ds_clients.repositories.ClientRepository;
import com.amaralph.ds_clients.services.exceptions.ResourceNotFoundException;
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

    public ClientDTO findById(Long id) {
        Client client = clientRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Recurso não encontrado"));
        return new ClientDTO(client);
    }

    public ClientDTO insert(ClientDTO dto) {
        Client entity = new Client();
        copyDtoToEntity(dto, entity);
        entity = clientRepository.save(entity);

        return new ClientDTO(entity);
    }

    private void copyDtoToEntity(ClientDTO dto, Client entity) {
        entity.setName(dto.getName());
        entity.setCpf(dto.getCpf());
        entity.setIncome(dto.getIncome());
        entity.setBirthDate(dto.getBirthDate());
        entity.setChildren(dto.getChildren());
    }
}

package com.hugovallada.orangebank.application.services;

import com.hugovallada.orangebank.domain.clients.ClientRepository;
import com.hugovallada.orangebank.domain.clients.dtos.ClientDTO;
import com.hugovallada.orangebank.domain.clients.mapper.ClientMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;

@Service
public class ClientService {

    private final ClientRepository repository;

    @Autowired
    public ClientService(ClientRepository repository) {
        this.repository = repository;
    }

    public ClientDTO insertClient(ClientDTO clientDTO) {
        checkIfExists(clientDTO.getEmail(), clientDTO.getCpf());
        ClientMapper mapper = ClientMapper.INSTANCE;

        var client = mapper.toModel(clientDTO);
        var savedClient = repository.save(client);

        return mapper.toDTO(savedClient);
    }

    private void checkIfExists(String email, String cpf) {
        var clients = repository.findAllByEmailOrCpf(email, cpf);

        if (!clients.isEmpty())
            throw new EntityExistsException("There's already a user with the same data!Please check your info");
    }

}

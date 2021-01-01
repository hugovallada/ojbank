package com.hugovallada.orangebank.controllers;

import java.time.LocalDate;


import com.hugovallada.orangebank.application.services.ClientService;
import com.hugovallada.orangebank.domain.clients.Client;

import com.hugovallada.orangebank.domain.clients.dtos.ClientDTO;
import com.hugovallada.orangebank.domain.clients.mapper.ClientMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityExistsException;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/clients")
public class ClientController {


    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService){
        this.clientService = clientService;
    }

    @PostMapping
    public ResponseEntity<Client> createClient(@RequestBody @Valid ClientDTO clientDTO) {
        if(clientDTO.getEmail().equals("emailJaExiste@example.com") || clientDTO.getCpf().equals("000000000-00")){
            throw new EntityExistsException("Already exists an account with this data");
        }

        ClientMapper mapper = ClientMapper.INSTANCE;
        var client = mapper.toModel(clientDTO);

        // TODO: Autommaper needs to do this automatic
        // Usar o mapping
        //client.setBirthDate(LocalDate.parse(String.valueOf(clientDTO.getBirthDate())));

        return ResponseEntity.status(201).body(client);
    }
    
}

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
    public ResponseEntity<ClientDTO> createClient(@RequestBody @Valid ClientDTO clientDTO) {
        var savedClientDTO = clientService.insertClient(clientDTO);
        return ResponseEntity.status(201).body(savedClientDTO);
    }
    
}

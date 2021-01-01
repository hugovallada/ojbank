package com.hugovallada.orangebank.controllers;

import com.hugovallada.orangebank.application.services.ClientService;
import com.hugovallada.orangebank.domain.clients.dtos.ClientDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/clients")
public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping
    public ResponseEntity<ClientDTO> createClient(@RequestBody @Valid ClientDTO clientDTO) {
        var savedClientDTO = clientService.insertClient(clientDTO);
        return ResponseEntity.status(201).body(savedClientDTO);
    }
}

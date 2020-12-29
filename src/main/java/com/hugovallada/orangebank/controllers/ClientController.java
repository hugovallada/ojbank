package com.hugovallada.orangebank.controllers;

import java.time.LocalDate;

import com.hugovallada.orangebank.application.services.ClientService;
import com.hugovallada.orangebank.domain.clients.Client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityExistsException;

@RestController
@RequestMapping("/api/v1/clients")
public class ClientController {

    private ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping
    public ResponseEntity<Client> createClient(@RequestBody Client client){
        if(client.getEmail().equals("emailJaExiste@example.com") || client.getCpf().equals("000000000-00")){
            throw new EntityExistsException("Already exists an account with this data");
        }

        return ResponseEntity.status(201).body(client);
    }
    
}

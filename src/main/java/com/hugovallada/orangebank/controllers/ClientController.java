package com.hugovallada.orangebank.controllers;

import java.time.LocalDate;

import com.hugovallada.orangebank.application.services.ClientService;
import com.hugovallada.orangebank.domain.clients.Client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityExistsException;

@RestController
@RequestMapping("/api/v1/clients")
public class ClientController {

    private ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/{name}")
    public ResponseEntity<?> getClientByName(@PathVariable String name){
        //TODO: Create Repositorys
        if(name.equals("Hugo")){
            throw new EntityExistsException("There is an client with this name already");
        }

        var client = new Client();
        client.setName(name);
        client.setEmail("example@gmail.com");
        client.setCpf("0000000000");
        client.setBirthDate(LocalDate.parse("1999-02-09"));
        
        return ResponseEntity.status(200).body(client);
    }
    
}

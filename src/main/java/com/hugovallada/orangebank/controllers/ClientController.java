package com.hugovallada.orangebank.controllers;

import java.time.Instant;
import java.time.LocalDate;

import com.hugovallada.orangebank.domain.clients.Client;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/clients")
public class ClientController {

    @GetMapping("/{name}")
    public ResponseEntity<?> getClientByName(@PathVariable String name){
        //TODO: Create Repositorys
        if(name.equals("Hugo")){
            return ResponseEntity.status(404).body("The client already exists");
        }

        var client = new Client();
        client.setName(name);
        client.setEmail("example@gmail.com");
        client.setCpf("0000000000");
        client.setBirthDate(LocalDate.parse("1999-02-09"));
        
        return ResponseEntity.status(200).body(client);
    }
    
}

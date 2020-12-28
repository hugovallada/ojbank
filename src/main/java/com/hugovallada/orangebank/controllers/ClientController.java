package com.hugovallada.orangebank.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/clients")
public class ClientController {

    @GetMapping
    public ResponseEntity<String> getClients(){
        return ResponseEntity.status(200).body("All Work");
    }
    
}

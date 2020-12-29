package com.hugovallada.orangebank.application.services;

import com.hugovallada.orangebank.domain.clients.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    private ClientRepository repository;

    @Autowired
    public ClientService(ClientRepository repository){
        this.repository = repository;
    }

}

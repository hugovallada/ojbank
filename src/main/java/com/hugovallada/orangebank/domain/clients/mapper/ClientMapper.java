package com.hugovallada.orangebank.domain.clients.mapper;

import com.hugovallada.orangebank.domain.clients.Client;
import com.hugovallada.orangebank.domain.clients.dtos.ClientDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public abstract class ClientMapper {

    public static ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);

    @Mapping(source = "birthDate", target = "birthDate")
    abstract public Client toModel(ClientDTO clientDTO);

    public ClientDTO toDTO(Client client) {
        var clientDTO = new ClientDTO();
        clientDTO.setName(client.getName());
        clientDTO.setCpf(client.getCpf());
        clientDTO.setBirthDate(client.getBirthDate());
        clientDTO.setEmail(client.getEmail());
        clientDTO.returnAge();

        return clientDTO;
    }
}

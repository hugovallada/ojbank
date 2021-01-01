package com.hugovallada.orangebank.domain.clients.mapper;

import com.hugovallada.orangebank.domain.clients.Client;
import com.hugovallada.orangebank.domain.clients.dtos.ClientDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ClientMapper {

    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);

    @Mapping(source = "birthDate", target = "birthDate")
    Client toModel(ClientDTO clientDTO);

    ClientDTO toDTO(Client client);
}

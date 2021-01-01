package com.hugovallada.orangebank.domain.clients;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Long> {

    List<Client> findAllByEmailOrCpf(String email, String cpf);
}

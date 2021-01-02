package com.hugovallada.orangebank.domain.clients;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Long> {

    Optional<Client> findFirstByEmailOrCpf(String email, String cpf);
}

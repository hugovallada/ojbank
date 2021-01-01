package com.hugovallada.orangebank.domain.clients.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientDTO {

    private Long id;

    @NotNull(message = "The property 'name' can't be null")
    private String name;

    @NotNull(message = "The property 'email' can't be null")
    @Email(message = "The property must follow an email pattern. Ex: example@provider.com")
    private String email;

    @NotNull(message = "The property 'cpf' can't be null")
    @CPF(message = "The property 'cpf' must follow a valid pattern")
    private String cpf;

    @NotNull(message = "The property birthDate can't be null")
    private LocalDate birthDate;
}

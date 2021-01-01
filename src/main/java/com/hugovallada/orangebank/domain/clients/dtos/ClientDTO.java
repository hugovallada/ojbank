package com.hugovallada.orangebank.domain.clients.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientDTO {

    private Long id;

    @NotEmpty(message = "The property 'name' can't be empty")
    @NotNull(message = "The property 'name' can't be null")
    @Size(min = 3, message = "The property 'name' should be at least 3 characters long")
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

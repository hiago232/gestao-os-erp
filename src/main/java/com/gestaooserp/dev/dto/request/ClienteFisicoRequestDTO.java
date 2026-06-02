package com.gestaooserp.dev.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;

public record ClienteFisicoRequestDTO(

        @NotBlank(message = "CPF obrigatório.")
        @Pattern(
                regexp = "^\\d{11}$",
                message = "CPF deve conter exatamente 11 números."
        )
        String cpf,

        @NotBlank(message = "Nome obrigatório.")
        String nome,

        @NotNull(message = "Insira a data de nascimento.")
        LocalDate nascimento,

        @NotBlank(message = "Endereço obrigatório.")
        String endereco,

        @NotBlank(message = "Cidade obrigatória.")
        String cidade,

        @NotBlank(message = "Estado obrigatório.")
        @Pattern(
                regexp = "^[A-Z]{2}$",
                message = "UF deve conter exatamente 2 letras maiúsculas"
        )
        String estado,

        @NotBlank(message = "E-mail obrigatório.")
        @Email(message = "E-mail inválido.")
        String email,

        @NotBlank(message = "CEP obrigatório")
        String cep,

        @NotBlank(message = "Celular obrigatório")
        String cel
) {
}

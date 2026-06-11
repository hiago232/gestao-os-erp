package com.gestaooserp.dev.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record ClienteJuridicoRequestDTO(

        @NotBlank(message = "CNPJ obrigatório.")
        @Pattern(
                regexp = "^\\d{14}$",
                message = "CNPJ deve conter exatamente 14 números."
        )
        String cnpj,

        @NotBlank(message = "Razão social obrigatória.")
        String razaoSocial,

        @NotBlank(message = "Nome fantasia obrigatório.")
        String nomeFantasia,

        @NotBlank(message = "Responsavel obrigatório.")
        String responsavel,

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

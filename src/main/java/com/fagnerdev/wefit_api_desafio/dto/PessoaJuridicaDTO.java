package com.fagnerdev.wefit_api_desafio.dto;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record PessoaJuridicaDTO(

        @NotBlank
        String cnpj,

        @NotBlank
        String cpfResponsavel,

        @NotBlank
        String nome,

        @NotBlank
        String celular,

        String telefone,

        @NotBlank
        @Email
        String email,

        @NotBlank
        @Email
        String confirmarEmail,

        @Pattern(regexp = "^\\d{5}-\\d{3}$", message = "CEP deve estar no formato 00000-000")
        String cep,

        @NotBlank
        String logradouro,

        @NotBlank
        String numero,

        String complemento,

        @NotBlank
        String cidade,

        @NotBlank
        String bairro,

        @NotBlank
        String estado,

        @AssertTrue(message = "Você deve aceitar os termos de uso.")
        boolean termosAceitos

) {}

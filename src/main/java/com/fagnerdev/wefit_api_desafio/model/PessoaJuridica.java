package com.fagnerdev.wefit_api_desafio.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PessoaJuridica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cnpj;
    private String cpfResponsavel;
    private String nome;
    private String celular;
    private String telefone;
    private String email;
    private boolean termosAceitos;

    // Endereço
    private String cep;
    private String logradouro;
    private String numero;
    private String complemento;
    private String cidade;
    private String bairro;
    private String estado;
}


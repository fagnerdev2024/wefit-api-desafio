package com.fagnerdev.wefit_api_desafio.config;

import com.fagnerdev.wefit_api_desafio.dto.PessoaJuridicaDTO;
import com.fagnerdev.wefit_api_desafio.model.PessoaJuridica;
import org.springframework.stereotype.Component;

@Component
public class PessoaJuridicaMapper {

    public PessoaJuridica toEntity(PessoaJuridicaDTO pessoaJuridicaDTO) {
        return PessoaJuridica.builder()
                .cnpj(pessoaJuridicaDTO.cnpj())
                .cpfResponsavel(pessoaJuridicaDTO.cpfResponsavel())
                .nome(pessoaJuridicaDTO.nome())
                .celular(pessoaJuridicaDTO.celular())
                .telefone(pessoaJuridicaDTO.telefone())
                .email(pessoaJuridicaDTO.email())
                .cep(pessoaJuridicaDTO.cep())
                .logradouro(pessoaJuridicaDTO.logradouro())
                .numero(pessoaJuridicaDTO.numero())
                .complemento(pessoaJuridicaDTO.complemento())
                .cidade(pessoaJuridicaDTO.cidade())
                .bairro(pessoaJuridicaDTO.bairro())
                .estado(pessoaJuridicaDTO.estado())
                .termosAceitos(pessoaJuridicaDTO.termosAceitos())
                .build();
    }

    public PessoaJuridicaDTO toDTO(PessoaJuridica pessoaJuridica) {
        return new PessoaJuridicaDTO(
                pessoaJuridica.getCnpj(),
                pessoaJuridica.getCpfResponsavel(),
                pessoaJuridica.getNome(),
                pessoaJuridica.getCelular(),
                pessoaJuridica.getTelefone(),
                pessoaJuridica.getEmail(),
                pessoaJuridica.getEmail(), // confirmarEmail
                pessoaJuridica.getCep(),
                pessoaJuridica.getLogradouro(),
                pessoaJuridica.getNumero(),
                pessoaJuridica.getComplemento(),
                pessoaJuridica.getCidade(),
                pessoaJuridica.getBairro(),
                pessoaJuridica.getEstado(),
                pessoaJuridica.isTermosAceitos()
        );
    }
}

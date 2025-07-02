package com.fagnerdev.wefit_api_desafio.config;

import com.fagnerdev.wefit_api_desafio.dto.PessoaJuridicaDTO;
import com.fagnerdev.wefit_api_desafio.model.PessoaJuridica;
import org.springframework.stereotype.Component;

@Component
public class PessoaJuridicaMapper {

    public PessoaJuridica toEntity(PessoaJuridicaDTO dto) {
        return PessoaJuridica.builder()
                .cnpj(dto.cnpj())
                .cpfResponsavel(dto.cpfResponsavel())
                .nome(dto.nome())
                .celular(dto.celular())
                .telefone(dto.telefone())
                .email(dto.email())
                .cep(dto.cep())
                .logradouro(dto.logradouro())
                .numero(dto.numero())
                .complemento(dto.complemento())
                .cidade(dto.cidade())
                .bairro(dto.bairro())
                .estado(dto.estado())
                .termosAceitos(dto.termosAceitos())
                .build();
    }

    public PessoaJuridicaDTO toDTO(PessoaJuridica entity) {
        return new PessoaJuridicaDTO(
                entity.getCnpj(),
                entity.getCpfResponsavel(),
                entity.getNome(),
                entity.getCelular(),
                entity.getTelefone(),
                entity.getEmail(),
                entity.getEmail(), // confirmarEmail
                entity.getCep(),
                entity.getLogradouro(),
                entity.getNumero(),
                entity.getComplemento(),
                entity.getCidade(),
                entity.getBairro(),
                entity.getEstado(),
                entity.isTermosAceitos()
        );
    }
}

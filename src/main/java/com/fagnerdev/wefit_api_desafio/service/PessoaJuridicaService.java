package com.fagnerdev.wefit_api_desafio.service;


import com.fagnerdev.wefit_api_desafio.dto.PessoaJuridicaDTO;
import com.fagnerdev.wefit_api_desafio.model.PessoaJuridica;
import com.fagnerdev.wefit_api_desafio.repository.PessoaJuridicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoaJuridicaService {

    @Autowired
    private PessoaJuridicaRepository repository;

    public PessoaJuridica salvar(PessoaJuridicaDTO dto) {
        PessoaJuridica pj = PessoaJuridica.builder()
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
        return repository.save(pj);
    }
}

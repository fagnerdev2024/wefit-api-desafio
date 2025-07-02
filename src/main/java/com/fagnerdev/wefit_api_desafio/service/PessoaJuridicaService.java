package com.fagnerdev.wefit_api_desafio.service;


import com.fagnerdev.wefit_api_desafio.dto.PessoaJuridicaDTO;
import com.fagnerdev.wefit_api_desafio.model.PessoaJuridica;
import com.fagnerdev.wefit_api_desafio.repository.PessoaJuridicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoaJuridicaService {

    @Autowired
    private PessoaJuridicaRepository pessoaJuridicaRepository;


    public PessoaJuridica salvar(PessoaJuridicaDTO pessoaJuridicaDTO) {
        PessoaJuridica pessoaJuridica = PessoaJuridica.builder()
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
        return pessoaJuridicaRepository.save(pessoaJuridica);
    }
}

package com.fagnerdev.wefit_api_desafio.service;


import com.fagnerdev.wefit_api_desafio.config.PessoaJuridicaMapper;
import com.fagnerdev.wefit_api_desafio.dto.PessoaJuridicaDTO;
import com.fagnerdev.wefit_api_desafio.model.PessoaJuridica;
import com.fagnerdev.wefit_api_desafio.repository.PessoaJuridicaRepository;
import com.fagnerdev.wefit_api_desafio.validacoes.PessoaJuridicaValidator;
import jakarta.transaction.Transactional;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaJuridicaService {

    private final PessoaJuridicaRepository pessoaJuridicaRepository;
    private final PessoaJuridicaValidator pessoaJuridicaValidator;
    private final PessoaJuridicaMapper pessoaJuridicaMapper;

    public PessoaJuridicaService(PessoaJuridicaRepository pessoaJuridicaRepository, PessoaJuridicaValidator pessoaJuridicaValidator, PessoaJuridicaMapper pessoaJuridicaMapper) {
        this.pessoaJuridicaRepository = pessoaJuridicaRepository;
        this.pessoaJuridicaValidator = pessoaJuridicaValidator;
        this.pessoaJuridicaMapper = pessoaJuridicaMapper;
    }

    @Transactional
    public PessoaJuridica salvar(PessoaJuridicaDTO pessoaJuridicaDTO) {
        pessoaJuridicaValidator.validarCadastro(pessoaJuridicaDTO);

        try {
            PessoaJuridica pessoaJuridica = toEntity(pessoaJuridicaDTO);
            return pessoaJuridicaRepository.save(pessoaJuridica);
        } catch (DataIntegrityViolationException e) {
            throw new RuntimeException("Erro ao salvar pessoa jurídica. Verifique os dados.", e);
        }
    }

    private PessoaJuridica toEntity(PessoaJuridicaDTO pessoaJuridicaDTO) {
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

    public Page<PessoaJuridicaDTO> listarTodos(Pageable pageable) {
        return pessoaJuridicaRepository.findAll(pageable).map(pessoaJuridicaMapper::toDTO);
    }
}
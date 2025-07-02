package com.fagnerdev.wefit_api_desafio.service;


import com.fagnerdev.wefit_api_desafio.dto.PessoaJuridicaDTO;
import com.fagnerdev.wefit_api_desafio.model.PessoaJuridica;
import com.fagnerdev.wefit_api_desafio.repository.PessoaJuridicaRepository;
import jakarta.transaction.Transactional;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class PessoaJuridicaService {

    private final PessoaJuridicaRepository pessoaJuridicaRepository;

    public PessoaJuridicaService(PessoaJuridicaRepository pessoaJuridicaRepository) {
        this.pessoaJuridicaRepository = pessoaJuridicaRepository;
    }

    @Transactional
    public PessoaJuridica salvar(PessoaJuridicaDTO pessoaJuridicaDTO) {
        if (pessoaJuridicaRepository.existsByCnpj(pessoaJuridicaDTO.cnpj())) {
            throw new IllegalArgumentException("CNPJ já cadastrado.");
        }

        try {
            PessoaJuridica pessoaJuridica = toEntity(pessoaJuridicaDTO);
            return pessoaJuridicaRepository.save(pessoaJuridica);
        } catch (DataIntegrityViolationException e) {
            throw new RuntimeException("Erro ao salvar pessoa jurídica. Verifique os dados.", e);
        }
    }

    private PessoaJuridica toEntity(PessoaJuridicaDTO dto) {
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
}

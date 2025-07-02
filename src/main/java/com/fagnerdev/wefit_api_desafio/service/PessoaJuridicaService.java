package com.fagnerdev.wefit_api_desafio.service;


import com.fagnerdev.wefit_api_desafio.model.PessoaJuridica;
import com.fagnerdev.wefit_api_desafio.repository.PessoaJuridicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaJuridicaService {


    private final PessoaJuridicaRepository repository;

    @Autowired
    public PessoaJuridicaService(PessoaJuridicaRepository repository) {
        this.repository = repository;
    }

    public PessoaJuridica salvar(PessoaJuridica pessoa) {
        return repository.save(pessoa);
    }

    public List<PessoaJuridica> listarTodas() {
        return repository.findAll();
    }
}

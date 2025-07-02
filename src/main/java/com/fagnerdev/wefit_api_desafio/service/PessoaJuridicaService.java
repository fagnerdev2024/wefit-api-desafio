package com.fagnerdev.wefit_api_desafio.service;


import com.fagnerdev.wefit_api_desafio.model.PessoaJuridica;
import com.fagnerdev.wefit_api_desafio.repository.PessoaJuridicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaJuridicaService {


    @Autowired
    private PessoaJuridicaRepository repository;

    public PessoaJuridica salvar(PessoaJuridica pessoa) {
        // Aqui você pode colocar regras de negócio, como validações adicionais
        return repository.save(pessoa);
    }

    public List<PessoaJuridica> listarTodas() {
        return repository.findAll();
    }
}

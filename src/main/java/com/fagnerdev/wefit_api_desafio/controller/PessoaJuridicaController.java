package com.fagnerdev.wefit_api_desafio.controller;


import com.fagnerdev.wefit_api_desafio.dto.PessoaJuridicaDTO;
import com.fagnerdev.wefit_api_desafio.model.PessoaJuridica;
import com.fagnerdev.wefit_api_desafio.service.PessoaJuridicaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pessoa-juridica")
public class PessoaJuridicaController {

    @Autowired
    private PessoaJuridicaService service;

    @PostMapping
    public ResponseEntity<PessoaJuridica> cadastrar(@RequestBody @Valid PessoaJuridicaDTO dto) {
        PessoaJuridica pessoa = service.salvar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(pessoa);
    }
}
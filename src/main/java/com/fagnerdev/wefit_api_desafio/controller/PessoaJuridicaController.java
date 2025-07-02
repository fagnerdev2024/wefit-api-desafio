package com.fagnerdev.wefit_api_desafio.controller;


import com.fagnerdev.wefit_api_desafio.model.PessoaJuridica;
import com.fagnerdev.wefit_api_desafio.service.PessoaJuridicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoas-juridicas")
public class PessoaJuridicaController {


    @Autowired
    private PessoaJuridicaService service;

    @PostMapping
    public ResponseEntity<PessoaJuridica> cadastrar(@RequestBody PessoaJuridica pessoa) {
        PessoaJuridica salva = service.salvar(pessoa);
        return ResponseEntity.status(HttpStatus.CREATED).body(salva);
    }

    @GetMapping
    public ResponseEntity<List<PessoaJuridica>> listar() {
        return ResponseEntity.ok(service.listarTodas());
    }
}

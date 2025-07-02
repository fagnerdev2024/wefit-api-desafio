package com.fagnerdev.wefit_api_desafio.controller;


import com.fagnerdev.wefit_api_desafio.config.PessoaJuridicaMapper;
import com.fagnerdev.wefit_api_desafio.dto.PessoaJuridicaDTO;
import com.fagnerdev.wefit_api_desafio.model.PessoaJuridica;
import com.fagnerdev.wefit_api_desafio.service.PessoaJuridicaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pessoa-juridica")
public class PessoaJuridicaController {


    @Autowired
    private PessoaJuridicaService service;

    @Autowired
    private PessoaJuridicaMapper mapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PessoaJuridicaDTO cadastrar(@RequestBody @Valid PessoaJuridicaDTO dto) {
        PessoaJuridica entity = service.salvar(dto);
        return mapper.toDTO(entity);
    }
}
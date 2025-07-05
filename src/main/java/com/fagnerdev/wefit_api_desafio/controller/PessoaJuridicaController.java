package com.fagnerdev.wefit_api_desafio.controller;

import com.fagnerdev.wefit_api_desafio.config.PessoaJuridicaMapper;
import com.fagnerdev.wefit_api_desafio.dto.PessoaJuridicaDTO;
import com.fagnerdev.wefit_api_desafio.model.PessoaJuridica;
import com.fagnerdev.wefit_api_desafio.service.PessoaJuridicaService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pessoa-juridica")
public class PessoaJuridicaController {

    private final PessoaJuridicaService pessoaJuridicaService;
    private final PessoaJuridicaMapper pessoaJuridicaMapper;

    public PessoaJuridicaController(PessoaJuridicaService pessoaJuridicaService, PessoaJuridicaMapper pessoaJuridicaMapper) {
        this.pessoaJuridicaService = pessoaJuridicaService;
        this.pessoaJuridicaMapper = pessoaJuridicaMapper;
    }

    @PostMapping
    public ResponseEntity<PessoaJuridicaDTO> cadastrar(@RequestBody @Valid PessoaJuridicaDTO pessoaJuridicaDTO) {
        PessoaJuridica pessoaJuridica = pessoaJuridicaService.salvar(pessoaJuridicaDTO);
        PessoaJuridicaDTO dto = pessoaJuridicaMapper.toDTO(pessoaJuridica);
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

    @GetMapping
    public ResponseEntity<Page<PessoaJuridicaDTO>> listar(Pageable pageable) {
        Page<PessoaJuridicaDTO> resultado = pessoaJuridicaService.listarTodos(pageable);
        return ResponseEntity.ok(resultado);
    }
}
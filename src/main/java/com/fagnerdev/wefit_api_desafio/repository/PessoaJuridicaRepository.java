package com.fagnerdev.wefit_api_desafio.repository;


import com.fagnerdev.wefit_api_desafio.model.PessoaJuridica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaJuridicaRepository extends JpaRepository<PessoaJuridica, Long> {


}

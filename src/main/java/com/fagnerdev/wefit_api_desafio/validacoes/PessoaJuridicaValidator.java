package com.fagnerdev.wefit_api_desafio.validacoes;

import com.fagnerdev.wefit_api_desafio.dto.PessoaJuridicaDTO;
import com.fagnerdev.wefit_api_desafio.repository.PessoaJuridicaRepository;
import org.hibernate.validator.internal.constraintvalidators.hv.br.CNPJValidator;
import org.hibernate.validator.internal.constraintvalidators.hv.br.CPFValidator;
import org.springframework.stereotype.Component;

@Component
public class PessoaJuridicaValidator {

    private final PessoaJuridicaRepository pessoaJuridicaRepository;

    public PessoaJuridicaValidator(PessoaJuridicaRepository pessoaJuridicaRepository) {
        this.pessoaJuridicaRepository = pessoaJuridicaRepository;
    }

    public void validarCadastro(PessoaJuridicaDTO pessoaJuridicaDTO) {
        validarEmailConfirmado(pessoaJuridicaDTO.email(), pessoaJuridicaDTO.confirmarEmail());
        validarDuplicidadeCnpj(pessoaJuridicaDTO.cnpj());
        validarCpf(pessoaJuridicaDTO.cpfResponsavel());
        validarCnpj(pessoaJuridicaDTO.cnpj());
        validarAceiteTermos(pessoaJuridicaDTO.termosAceitos());
    }

    private void validarEmailConfirmado(String email, String confirmarEmail) {
        if (!email.equalsIgnoreCase(confirmarEmail)) {
            throw new IllegalArgumentException("Os campos 'email' e 'confirmarEmail' devem ser iguais.");
        }
    }

    private void validarDuplicidadeCnpj(String cnpj) {
        if (pessoaJuridicaRepository.existsByCnpj(cnpj)) {
            throw new IllegalArgumentException("CNPJ já cadastrado.");
        }
    }

    private void validarCnpj(String cnpj) {
        CNPJValidator cnpjValidator = new CNPJValidator();
        cnpjValidator.initialize(null);
        if (!cnpjValidator.isValid(cnpj, null)) {
            throw new IllegalArgumentException("CNPJ inválido.");
        }
    }

    private void validarCpf(String cpf) {
        CPFValidator cpfValidator = new CPFValidator();
        cpfValidator.initialize(null);
        if (!cpfValidator.isValid(cpf, null)) {
            throw new IllegalArgumentException("CPF inválido.");
        }
    }

    private void validarAceiteTermos(Boolean aceite) {
        if (aceite == null || !aceite) {
            throw new IllegalArgumentException("É obrigatório aceitar os termos de uso.");
        }
    }
}

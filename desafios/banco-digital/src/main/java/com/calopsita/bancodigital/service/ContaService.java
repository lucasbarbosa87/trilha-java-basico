package com.calopsita.bancodigital.service;

import com.calopsita.bancodigital.dto.CriarContaDto;
import com.calopsita.bancodigital.model.Conta;
import org.springframework.stereotype.Service;

public interface ContaService {
    Conta criarConta(CriarContaDto criarContaDto);

    Iterable<Conta> buscarTodos();
}

package com.calopsita.bancodigital.service.impl;

import com.calopsita.bancodigital.dto.CriarContaDto;
import com.calopsita.bancodigital.model.ClienteRepository;
import com.calopsita.bancodigital.model.Conta;
import com.calopsita.bancodigital.model.ContaRepository;
import com.calopsita.bancodigital.service.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContaServiceImpl implements ContaService {

    private final ContaRepository contaRepository;
    private final ClienteRepository clienteRepository;

    public ContaServiceImpl(ContaRepository contaRepository, ClienteRepository clienteRepository) {
        this.contaRepository = contaRepository;
        this.clienteRepository = clienteRepository;
    }

    @Override
    public Conta criarConta(CriarContaDto criarContaDto) {
        var cliente = clienteRepository.findById(criarContaDto.contaId());
        if (cliente.isPresent()) {
            var conta = new Conta();
            conta.setCliente(cliente.get());
            conta.setSaldo(criarContaDto.saldo());
            conta.setAgencia(criarContaDto.agencia());
            contaRepository.save(conta);
            return conta;
        }
        return null;
    }

    @Override
    public Iterable<Conta> buscarTodos() {
        return contaRepository.findAll();
    }
}

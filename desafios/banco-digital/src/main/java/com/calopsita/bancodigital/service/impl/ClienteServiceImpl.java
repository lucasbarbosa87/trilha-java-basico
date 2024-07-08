package com.calopsita.bancodigital.service.impl;

import com.calopsita.bancodigital.model.Cliente;
import com.calopsita.bancodigital.model.ClienteRepository;
import com.calopsita.bancodigital.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteServiceImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }


    @Override
    public void cadastrarCliente(Cliente cliente) {
        clienteRepository.save(cliente);
    }

    @Override
    public Iterable<Cliente> buscarTodos() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente buscarCliente(Long id) {
        var cliente = clienteRepository.findById(id);
        return cliente.get();
    }

    @Override
    public void deletar(Long id) {
        var cliente = clienteRepository.findById(id);
        cliente.ifPresent(clienteRepository::delete);
    }
}

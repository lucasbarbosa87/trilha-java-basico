package com.calopsita.bancodigital.service;

import com.calopsita.bancodigital.model.Cliente;

public interface ClienteService {
    void cadastrarCliente(Cliente cliente);
    Iterable<Cliente> buscarTodos();
    Cliente buscarCliente(Long id);
    void deletar(Long id);
}

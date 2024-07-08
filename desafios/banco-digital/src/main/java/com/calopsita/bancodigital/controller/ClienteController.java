package com.calopsita.bancodigital.controller;

import com.calopsita.bancodigital.model.Cliente;
import com.calopsita.bancodigital.model.ClienteRepository;
import com.calopsita.bancodigital.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    public ResponseEntity<Cliente> salvarCliente(@RequestBody Cliente cliente) {
        clienteService.cadastrarCliente(cliente);
        return ResponseEntity.ok().body(cliente);
    }

    @GetMapping
    public ResponseEntity<Iterable<Cliente>> listarClientes() {
        return ResponseEntity.ok(clienteService.buscarTodos());
    }
    @GetMapping("{id}")
    public ResponseEntity<Cliente> buscarCliente(@PathVariable Long id) {
        return ResponseEntity.ok(clienteService.buscarCliente(id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> excluirCliente(@PathVariable Long id) {
        clienteService.deletar(id);
        return ResponseEntity.ok().build();
    }
}

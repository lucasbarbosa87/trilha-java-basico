package com.calopsita.bancodigital.controller;

import com.calopsita.bancodigital.dto.CriarContaDto;
import com.calopsita.bancodigital.model.Conta;
import com.calopsita.bancodigital.service.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contas")
public class ContaController {

    private final ContaService contaService;

    public ContaController(ContaService contaService) {
        this.contaService = contaService;
    }

    @GetMapping
    public ResponseEntity<Iterable<Conta>> getContas() {
        return ResponseEntity.ok(contaService.buscarTodos());
    }

    @PostMapping
    public ResponseEntity<Conta> inserir(@RequestBody CriarContaDto criarContaDto){
        return ResponseEntity.ok(contaService.criarConta(criarContaDto));
    }
}

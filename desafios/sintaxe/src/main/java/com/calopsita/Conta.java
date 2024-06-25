package com.calopsita;

import java.util.ArrayList;
import java.util.List;

public abstract class Conta implements IConta {
    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;
    private List<Operacao> operacaos = new ArrayList<Operacao>();

    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;

    public Conta(Cliente cliente) {
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
    }

    @Override
    public void sacar(double valor) {
        operacaos.add(new Saque(valor));
        saldo -= valor;
    }

    @Override
    public void depositar(double valor) {
        operacaos.add(new Deposito(valor));
        saldo += valor;
    }

    @Override
    public void transferir(double valor, IConta contaDestino) {
        this.sacar(valor);
        contaDestino.depositar(valor);
    }

    @Override
    public void imprimirExtrato() {
        for (Operacao operacao : operacaos) {
            System.out.printf("Tipo: %s | Valor: %.2f%n", operacao.getTipo(), operacao.getValor());
        }
    }

    @Override
    public void imprimirInformacoes() {
        System.out.printf("Olá %s, obrigado por criar uma conta em nosso banco, " +
                "sua agência é %d, conta %d e seu saldo %.2f " +
                "já está disponível para saque%n", cliente.getNome(), agencia, numero, saldo);
    }

    //
}

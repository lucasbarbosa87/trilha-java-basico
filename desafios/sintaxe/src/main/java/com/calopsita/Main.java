package com.calopsita;

public class Main {
    public static void main(String[] args) {
        Cliente venilton = new Cliente();
        venilton.setNome("Venilton");

        Conta cc = new ContaCorrente(venilton);
        Conta poupanca = new ContaPoupanca(venilton);

        cc.depositar(100);
        cc.transferir(100, poupanca);
        cc.imprimirInformacoes();
        cc.imprimirExtrato();

        poupanca.imprimirInformacoes();
        poupanca.imprimirExtrato();
    }
}
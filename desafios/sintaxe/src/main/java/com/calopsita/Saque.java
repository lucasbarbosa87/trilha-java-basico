package com.calopsita;

public class Saque extends Operacao {
    private double valor;
    public Saque(double valor){
        this.setTipo("S");
        this.valor = valor;
    }

}

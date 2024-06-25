package com.calopsita;

public class Deposito extends Operacao {
    public Deposito(double valor){
        this.setTipo("D");
        this.setValor(valor);
    }
}

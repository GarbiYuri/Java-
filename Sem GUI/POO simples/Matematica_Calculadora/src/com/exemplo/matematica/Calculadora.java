package com.exemplo.matematica;

public class Calculadora {
    public Double d1,d2,d4;

    public Double getD4() {
        return d4;
    }

    public void setD4 (double d4) {
        this.d4 = d4;
    }

    public double getD1() {
        return d1;
    }

    public void setD1(double d1) {
        this.d1 = d1;
    }

    public double getD2() {
        return d2;
    }

    public void setD2(double d2) {
        this.d2 = d2;
    }

    public String soma(){
        return "O Valor da Soma é: " + d4;
    }
    public String subtracao(){
        return "O Valor da Subtração do maior para o menor é: " + d4;
    }
    public String multiplicaco(){
        return "O Valor da Multiplicação é: " + d4;
    }
    public String divisao(){
        return "O Valor da Divisão do maior para o menor é: " + d4;
    }


}

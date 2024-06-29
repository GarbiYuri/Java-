package com.exemplo.matematica;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner  scanner = new Scanner(System.in);
        Calculadora calculadora = new Calculadora();

        int d3;

        System.out.println("Escreva um número: ");
        calculadora.setD1(scanner.nextDouble());
        System.out.println("Escreva outro número: ");
        calculadora.setD2(scanner.nextDouble());

        System.out.println("1 - Soma");
        System.out.println("2 - Subtração");
        System.out.println("3 - Multiplicação");
        System.out.println("4 - Divisão");
        System.out.println("Escolha uma Opção: ");
        d3 = scanner.nextInt();

        String resultado = "";

        switch (d3){
            case 1:
                calculadora.setD4(calculadora.getD1() + calculadora.getD2());
                resultado = calculadora.soma();
                break;
            case 2:
                if (calculadora.getD1() >= calculadora.getD2()){
                    calculadora.setD4(calculadora.getD1() - calculadora.getD2());
                }
                else {
                    calculadora.setD4(calculadora.getD2() - calculadora.getD1());
                }
                resultado = calculadora.subtracao();
                break;
            case 3:
                calculadora.setD4(calculadora.getD1() * calculadora.getD2());
                resultado = calculadora.multiplicaco();
                break;
            case 4:
                if (calculadora.getD1() >= calculadora.getD2()){
                    calculadora.setD4(calculadora.getD1() / calculadora.getD2());
                }
                else {
                    calculadora.setD4(calculadora.getD2() / calculadora.getD1());
                }
                resultado = calculadora.divisao();
                break;
            default:
                System.out.println("Erro!!");

        }
        System.out.println(resultado);
    }
}
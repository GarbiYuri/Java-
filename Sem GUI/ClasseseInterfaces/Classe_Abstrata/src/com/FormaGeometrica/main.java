package com.FormaGeometrica;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Triangulo triangulo1 = new Triangulo();
        Retangulo retangulo1 = new Retangulo();
        Circulo circulo1 = new Circulo();

        int d;
        double res = -1;
        do {


            System.out.println("Calcular Área:");
            System.out.println("1 - Circulo");
            System.out.println("2 - Triangulo");
            System.out.println("3 - Retângulo");
            System.out.println("Escolha uma opção: ");
            d = scanner.nextInt();



            switch (d) {
                case 1:
                    System.out.println("Qual o Raio: ");
                    circulo1.setA(scanner.nextDouble());
                    res = circulo1.getA();
                    System.out.println(circulo1.calcularArea());
                    break;
                case 2:
                    System.out.println("Qual a base: ");
                    triangulo1.setA(scanner.nextInt());
                    System.out.println("Qual a altura: ");
                    triangulo1.setB(scanner.nextInt());
                    res = (triangulo1.getA()+ triangulo1.getB());
                    System.out.println(triangulo1.calcularArea());
                    break;
                case 3:
                    System.out.println("Qual a base: ");
                    retangulo1.setA(scanner.nextInt());
                    System.out.println("Qual a altura: ");
                    retangulo1.setB(scanner.nextInt());
                    res = (retangulo1.getA()+retangulo1.getB());

                    System.out.println(retangulo1.calcularArea());
                    break;
                default:
                    System.out.println("Erro!!");


            }
        } while (res < 0);

    }
}

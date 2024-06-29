import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Livro livro = new Livro();
        int d = 0;

        do {
            if (d == 1){
                int m = 0;
                System.out.println("1 - Nome do Livro");
                System.out.println("2 - Autor do Livro");
                System.out.println("3 - Paginas do Livro");
                System.out.println("O que deseja modificar: ");
                m = scanner.nextInt();

                switch (m){
                    case 1:
                        System.out.println("Qual o nome do Livro: ");
                        scanner.next();
                        livro.setTitulo(scanner.nextLine());
                        System.out.println(livro.modificar("Nome do Livro"));
                        break;
                    case 2:
                        System.out.println("Qual o autor do Livro: ");
                        scanner.nextLine();
                        livro.setAutor(scanner.next());
                        System.out.println(livro.modificar("Autor do Livro"));;
                        break;
                    case 3:
                        System.out.println("Quantas paginas tem o Livro: ");
                        livro.setNumero_de_paginas(scanner.nextInt());
                        System.out.println(livro.modificar("Das Páginas Livro"));

                        break;
                    default:
                        System.out.println("Erro");
                }

            } else {


                System.out.println("Qual o nome do Livro: ");
                livro.setTitulo(scanner.nextLine());
                System.out.println("Qual o autor do Livro: ");
                livro.setAutor(scanner.nextLine());
                System.out.println("Quantas paginas tem o Livro: ");
                livro.setNumero_de_paginas(scanner.nextInt());
            }
            livro.acessar();

            System.out.println("Deseja Modificar algo: (1 = s/2 = n)");
            d = scanner.nextInt();

        }while (d == 1);
    }
}
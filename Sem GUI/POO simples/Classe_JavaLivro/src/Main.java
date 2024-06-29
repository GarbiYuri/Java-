
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Livro livro = new Livro();

        String decisao;

        //ler atributos:

        System.out.println("Escreva o nome do autor:");
        livro.setAutor(scanner.nextLine());
        System.out.println("Escreva o nome do Livro:");
        livro.setTitulo(scanner.nextLine());
        System.out.println("Escreva o Ano do Livro:");
        livro.setAno(scanner.nextInt());


            livro.exibirDetalhes();

    }
}
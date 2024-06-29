import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pessoa pessoa = new Pessoa();

        System.out.println("Qual o nome: ");
        pessoa.setNome(scanner.nextLine());
        System.out.println("Qual o Endereço: ");
        pessoa.setEnd(scanner.nextLine());
        System.out.println("Qual a idade: ");
        pessoa.setIdade(scanner.nextInt());
        System.out.println("Esse pessoa anda: ");
        scanner.nextLine();
        pessoa.andar(scanner.next());

        pessoa.dados();


    }
}
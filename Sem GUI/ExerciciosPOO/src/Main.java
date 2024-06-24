import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Carro carro = new Carro();

        System.out.println("Qual a marca do carro:");
        carro.setMarca(scanner.nextLine());
        System.out.println("Qual o modelo do carro:");
        carro.setModelo(scanner.nextLine());
        System.out.println("Qual o ano de fabricação: ");
        carro.setAno(scanner.nextInt());

        carro.MostrarDetalhes();
    }
}
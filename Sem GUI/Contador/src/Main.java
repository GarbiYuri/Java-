import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Contador contador = new Contador();

        System.out.println("Digite um número: ");
        contador.setA(scanner.nextInt());

        for (int i = contador.getA(); i > -1; i--){
            contador.contagem(i);

            System.out.println(contador.contagem(i));
        }
    }
}
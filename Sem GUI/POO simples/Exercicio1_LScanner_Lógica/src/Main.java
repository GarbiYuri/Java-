import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int idd;

        System.out.println("Qual a sua idade:");
        idd = scanner.nextInt();

        if (idd >= 18){
            System.out.println("Você alcançou a maioridade!!");
        }
        else {
            System.out.println("Você não Alcançou a maioridade!!");
            System.out.println("Faltam: " + (18 - idd) + " anos!");
        }

    }
}
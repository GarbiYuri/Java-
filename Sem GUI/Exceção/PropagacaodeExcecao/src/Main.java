import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean boo;
        do {
            boo = true;
            System.out.println("Escreva uma senha de 4 dígitos: ");
            try {
                // Leitura da entrada como String
                String a = scanner.next();

                // Tenta converter a entrada para um número inteiro
                int c = Integer.parseInt(a);

                // Converte de volta para String para verificar se houve perda de precisão
                String b = String.valueOf(c);

                // Chama o método para verificar e aplicar a exceção personalizada
                ChamarExcecao chamar = new ChamarExcecao();
                chamar.verificareaplicar(b);

            } catch (NumberFormatException e) {
                System.out.println("Entrada não numérica detectada!! Por favor, digite apenas números.");
                boo = false; // Define boo como false para repetir o loop
                scanner.nextLine(); // Limpa o buffer do Scanner
            } catch (Minhaexcecao e) {
                System.out.println(e.getMessage());
                boo = false; // Define boo como false para repetir o loop
            } finally {
                if (boo) {
                    System.out.println("Código Finalizado!!");
                }
            }
        } while (!boo);

        scanner.close(); // Fecha o Scanner no final do programa
    }
}

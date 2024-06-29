import javax.sound.midi.Soundbank;
import java.util.InputMismatchException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
   /* public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("X: ");
            int a = scanner.nextInt();

            System.out.println("Y: ");
            int b = scanner.nextInt();

            double ab = a/b;
            double ba = b/a;

            System.out.println("X / Y = " + ab);

            System.out.println("Y / X = " + ba);

        }catch (ArithmeticException e){
            System.out.println("Impossível a Divisão por Zero!!");
        }catch (InputMismatchException e){
            System.out.println("Entrada não númerica detectada!!");
        }finally {
            System.out.println("Fim do Código!!");
        }
    }*/

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        VeficarIdade veficaridade = new VeficarIdade();
        System.out.println("Veja se Você Pode entrar");
        System.out.println("Digite sua idade:");
        int a = scanner.nextInt();
        try {
            veficaridade.verificaridade(a);
        }catch (InputMismatchException e){
            System.out.println("Entrada não númerica detectada!!");
        }catch (IdadeInvalidaException e){
                System.out.println(e.getMessage());
        }finally {
            System.out.println("Fim do Código!!");
        }
    }
}
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Dialogo.Pessoa pessoa = new Dialogo.Pessoa();


        System.out.println("Digite o nome:");
        pessoa.setNome(scanner.nextLine());
        System.out.println("Informe seu Sexo:");
        pessoa.setSexo(scanner.nextLine());
        System.out.println("Informe sua idade:");
        pessoa.setIdade(Integer.parseInt(scanner.nextLine()));
        System.out.println("Informe sua estatura:");
        pessoa.setEstatura(Double.parseDouble(scanner.nextLine()));
        System.out.println("Fale algo para o Mundo:");
        String text = pessoa.falar(scanner.nextLine());

        pessoa.andar();

        System.out.println("\n");


        System.out.println(text);
    }
}

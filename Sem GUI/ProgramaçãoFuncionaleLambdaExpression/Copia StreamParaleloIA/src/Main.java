
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        List<Integer> numeros = new ArrayList<>();
        Random random = new Random();
        int tamanho = 1000;

        for (int i = 0; i <= tamanho; i++){
            numeros.add(random.nextInt(100));
        }

        int soma = numeros.parallelStream()

                        .mapToInt(Integer::intValue)
                                .sum();



        System.out.println("Soma: " + soma);

    }
}
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ParallelStreamSum {
    public static void main(String[] args) {
        // Cria uma lista grande de números
        List<Integer> numbers = new ArrayList<>();
        Random random = new Random();
        int listSize = 1000000;

        for (int i = 0; i < listSize; i++) {
            numbers.add(random.nextInt(100)); // Números aleatórios entre 0 e 99
        }

        // Calcula a soma usando stream paralelo
        long startTime = System.currentTimeMillis();
        int sum = numbers.parallelStream()
                .mapToInt(Integer::intValue)
                .sum();
        long endTime = System.currentTimeMillis();

        System.out.println("Soma: " + sum);
        System.out.println("Tempo de execução: " + (endTime - startTime) + " ms");
    }
}
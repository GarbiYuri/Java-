import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;


//Lambda e Interfaces Funcionais:
    /*public class Main{
        public static void main(String[] args) {


            List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5);
            List<Integer> pares = numeros.stream()
                    .filter(numero -> numero % 2 == 0)
                    .collect(Collectors.toList());

            System.out.println(pares); // Resultado: [2, 4]


        }
    }*/
//
/*public class Main{
    public static void main(String[] args) {


        List<String> palavras = Arrays.asList("Ferro", "Aço", "Lã", "Água", "Pedra");
        List<String> mais4 = palavras.stream()
                .filter(palavra -> palavra.length() > 4)
                .collect(Collectors.toList());

        System.out.println(mais4); // Resultado: [Ferro, Pedra]


    }
}*/

/*public class Main {
    public static void main(String[] args){
        List<Integer> numeros = Arrays.asList(1,2,3,4,5);
        List<Integer> quadrados = numeros.stream()
                .map(numero -> numero * numero)
                .collect(Collectors.toList());

        System.out.println(quadrados);

    }
}*/
public class Main {
    public static void main(String[] args){
        List<Integer> numeros = Arrays.asList(4,10,5,6,1);
        List<Integer> quadrados = numeros.stream()
                .sorted((n1,n2) -> n2.compareTo(n1))
                .collect(Collectors.toList());

        System.out.println(quadrados);

    }
}



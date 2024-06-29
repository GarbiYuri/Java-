package ObjetoThreadComFilaEspera;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Jogo> jogos = Arrays.asList(
                new Jogo("Aventura Espacial", 60, "Explore o universo e descubra planetas."),
                new Jogo("Corrida Radical", 45, "Corridas emocionantes em pistas desafiadoras."),
                new Jogo("Puzzle Mágico", 30, "Resolvendo quebra-cabeças em um mundo encantado."),
                new Jogo("Guerra Medieval", 80, "Conquiste castelos e expanda seu império."),
                new Jogo("Missão Secreta", 55, "Infiltre-se em bases inimigas em missões secretas."),
                new Jogo("Esportes 2024", 70, "Compita em vários esportes em eventos globais."),
                new Jogo("Aventuras Submarinas", 65, "Descubra os mistérios das profundezas oceânicas."),
                new Jogo("Simulador de Construção", 40, "Construa e gerencie sua própria cidade."),
                new Jogo("Sobrevivência Zumbi", 50, "Lute para sobreviver em um apocalipse zumbi."),
                new Jogo("Mundo da Fantasia", 75, "Explore um mundo cheio de magia e criaturas fantásticas.")
        );

        FilaJogo fila = new FilaJogo();
        ProdutorJogo produtor = new ProdutorJogo(jogos, fila);
        Thread produtorthreads = new Thread(produtor);
        produtorthreads.start();

        int numConsumidores = 2; // Número de threads consumidoras
        List<Thread> consumidorThreads = new ArrayList<>();

        for (int i = 0; i < numConsumidores; i++) {
            ConsumidorJogo consumidor = new ConsumidorJogo(fila);
            Thread consumidorThread = new Thread(consumidor);
            consumidorThreads.add(consumidorThread);
            consumidorThread.start();
        }

        try {
            produtorthreads.join(); // Aguarda o produtor terminar
            for (Thread consumidorThread : consumidorThreads) {
                consumidorThread.join(); // Aguarda todos os consumidores terminarem
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

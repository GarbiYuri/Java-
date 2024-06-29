import java.util.ArrayList;
import java.util.List;

public class ExemploProcessamentoUsuarios {
    public static void main(String[] args) {
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(new Usuario("João", 30));
        usuarios.add(new Usuario("Maria", 25));
        usuarios.add(new Usuario("Pedro", 40));
        usuarios.add(new Usuario("Ana", 22));

        FilaUsuarios fila = new FilaUsuarios();
        ProdutorUsuarios produtor = new ProdutorUsuarios(usuarios, fila);
        Thread produtorThread = new Thread(produtor);
        produtorThread.start();

        int numConsumidores = 2; // Número de threads consumidoras
        List<Thread> consumidorThreads = new ArrayList<>();

        for (int i = 0; i < numConsumidores; i++) {
            ConsumidorUsuarios consumidor = new ConsumidorUsuarios(fila);
            Thread consumidorThread = new Thread(consumidor);
            consumidorThreads.add(consumidorThread);
            consumidorThread.start();
        }

        try {
            produtorThread.join(); // Aguarda o produtor terminar
            for (Thread consumidorThread : consumidorThreads) {
                consumidorThread.join(); // Aguarda todos os consumidores terminarem
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
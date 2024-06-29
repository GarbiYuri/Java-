package ObjetoThreadComFilaEspera;
import java.util.PriorityQueue;
import java.util.Queue;

public class FilaJogo {
    private final Queue<Jogo> fila = new PriorityQueue<>((u1, u2) -> u1.getNome().compareTo(u2.getNome()));
    private boolean done = false;

    public synchronized void adicionar(Jogo jogo){
        fila.add(jogo);
        notifyAll();
    }

    public synchronized Jogo pegar(){
        while (fila.isEmpty() && !done){
            try {
                wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        return  fila.isEmpty() ? null : fila.poll();
    }
    public synchronized void fechar(){
        done = true;
        notifyAll();
    }

}

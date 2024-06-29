package ObjetoThreadComFilaEspera;

public class ConsumidorJogo implements Runnable{
    private final FilaJogo fila;

    public ConsumidorJogo(FilaJogo fila) {
        this.fila = fila;
    }

    @Override
    public void run() {
        while (true){
            Jogo jogo = fila.pegar();
            if (jogo == null){
                break;
            }
            processarjogo(jogo);
            try {
                Thread.sleep(100);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    private void processarjogo(Jogo jogo){
        System.out.println(Thread.currentThread().getName() + ": Processando " + jogo);
    }
}

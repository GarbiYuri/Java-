package ObjetoThreadComFilaEspera;

import java.util.List;

public class ProdutorJogo implements Runnable{
    private final List<Jogo> jogos;
    private final FilaJogo fila;

    public ProdutorJogo(List<Jogo> jogos, FilaJogo fila) {
        this.jogos = jogos;
        this.fila = fila;
    }

    @Override
    public void run() {
            for (Jogo jogos : jogos) {
                fila.adicionar(jogos);

            }
    }
}

import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class JogoImplemento implements Runnable{
    private final List<Jogo> jogos;
    public int a,b;

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    ReentrantLock lock = new ReentrantLock();

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public JogoImplemento(List<Jogo> jogos) {
        this.jogos = jogos;

    }

    @Override
    public void run() {
            for (Jogo jogos : jogos) {
                jogos.toString();

            }
    }
}

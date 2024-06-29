import java.util.concurrent.locks.ReentrantLock;

public class ContagemRegressiva {
        int quantidade = 11;

        ReentrantLock lock = new ReentrantLock();

        public void fila(){
            if (quantidade > 0) {
                lock.lock();
                try {
                    Thread.sleep(500);
                    quantidade--;
                    System.out.println(quantidade);

                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
            if (quantidade == 1){
                System.out.println("GO GO GO");
            }

        }

}

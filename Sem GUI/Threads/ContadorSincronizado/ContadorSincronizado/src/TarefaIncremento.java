public class TarefaIncremento implements Runnable{
    private final Contador contadores;

    public TarefaIncremento(Contador contadores){
        this.contadores = contadores;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++){
            contadores.colocar();
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}

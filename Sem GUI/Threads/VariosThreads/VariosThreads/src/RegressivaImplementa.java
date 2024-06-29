public class RegressivaImplementa implements Runnable{
        private final ContagemRegressiva contagemRegressiva;

    public RegressivaImplementa(ContagemRegressiva contagemRegressiva) {
        this.contagemRegressiva = contagemRegressiva;
    }

    @Override
    public void run() {
        for (int i = 2; i > 0; i--) {
                contagemRegressiva.fila();

            }
    }
}

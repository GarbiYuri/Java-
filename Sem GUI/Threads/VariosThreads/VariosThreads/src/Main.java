public class Main {
    public static void main(String[] args) {
        ContagemRegressiva contagemRegressiva = new ContagemRegressiva();

        Thread a = new Thread(new RegressivaImplementa(contagemRegressiva));

        Thread b = new Thread(new RegressivaImplementa(contagemRegressiva));

        Thread c = new Thread(new RegressivaImplementa(contagemRegressiva));

        Thread d = new Thread(new RegressivaImplementa(contagemRegressiva));

        Thread e = new Thread(new RegressivaImplementa(contagemRegressiva));


        a.start();

        b.start();
        c.start();

        d.start();
        e.start();
    }
}
public class Contador {
    private int cont;

    public synchronized void colocar(){
        cont++;
        System.out.println("Valor incrementado: " + cont);
    }
}

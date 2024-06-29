//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
            Contador sincrono = new Contador();

            Thread a = new Thread(new TarefaIncremento(sincrono));

            Thread b = new Thread(new TarefaIncremento(sincrono));

            a.start();
            b.start();
        }
    }

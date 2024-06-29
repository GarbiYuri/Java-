public class ConsumidorUsuarios implements Runnable {
    private final FilaUsuarios fila;

    public ConsumidorUsuarios(FilaUsuarios fila) {
        this.fila = fila;
    }

    @Override
    public void run() {
        while (true) {
            Usuario usuario = fila.pegar();
            if (usuario == null) {
                break;
            }
            processarUsuario(usuario);
            try {
                Thread.sleep(100); // Simula tempo de processamento
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void processarUsuario(Usuario usuario) {
        System.out.println(Thread.currentThread().getName() + ": Processando " + usuario);
    }
}
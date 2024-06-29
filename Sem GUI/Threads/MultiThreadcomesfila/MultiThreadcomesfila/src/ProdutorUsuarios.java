import java.util.List;

public class ProdutorUsuarios implements Runnable {
    private final List<Usuario> usuarios;
    private final FilaUsuarios fila;

    public ProdutorUsuarios(List<Usuario> usuarios, FilaUsuarios fila) {
        this.usuarios = usuarios;
        this.fila = fila;
    }

    @Override
    public void run() {
        for (Usuario usuario : usuarios) {
            fila.adicionar(usuario);
        }
        fila.fechar();
    }
}
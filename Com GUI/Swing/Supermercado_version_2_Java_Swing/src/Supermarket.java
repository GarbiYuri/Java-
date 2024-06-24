
import java.util.ArrayList;

class Supermarket {
    private ArrayList<Produto> produtos;
    private ArrayList<Cliente> clientes;
    private Carrinho carrinho;

    public Supermarket() {
        produtos = new ArrayList<>();
        clientes = new ArrayList<>();
        carrinho = new Carrinho();
    }

    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }



    public void removerProduto(Produto produto) {
        produtos.remove(produto);
    }

    public void adicionarUsuario(Cliente cliente) {
        clientes.add(cliente);
    }

    public void removerUsuario(Cliente cliente) {
        clientes.remove(cliente);
    }

    public ArrayList<Produto> getProdutos() {
        return produtos;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }
    public Cliente getNomeCliente(String nome) {
        for (Cliente cliente : clientes) {
            if (cliente.getNome().equalsIgnoreCase(nome)) {
                return cliente;
            }
        }
        return null;
    }

    public Carrinho getCarrinho() {
        return carrinho;
    }
}

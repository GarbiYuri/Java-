import java.util.ArrayList;

class Carrinho {
    private ArrayList<Produto> produtos;

    public Carrinho() {
        produtos = new ArrayList<>();
    }

    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    public void removerProduto(Produto produto) {
        produtos.remove(produto);
    }

    public ArrayList<Produto> getProdutos() {
        return produtos;
    }

    public void esvaziar() {
        produtos.clear();
    }
}

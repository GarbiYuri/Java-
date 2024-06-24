
import java.util.ArrayList;

class Carrinho {

    int  quantidade;

    private ArrayList<Produto> produtos;

    public Carrinho() {
        produtos = new ArrayList<>();
    }

    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
        quantidade += 1;
    }

    public void removerperma(Produto produto) {
        for (int i = quantidade; i >= 0; i--) {
            produtos.remove(produto);
            quantidade -= 1;
        }
    }


    public void removerProduto(Produto produto) {
        produtos.remove(produto);
        quantidade -= 1;
    }


    public ArrayList<Produto> getProdutos() {
        return produtos;
    }

    public void esvaziar() {
        produtos.clear();
    }

}

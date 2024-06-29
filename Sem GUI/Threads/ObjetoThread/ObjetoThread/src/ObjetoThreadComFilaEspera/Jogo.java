package ObjetoThreadComFilaEspera;

public class Jogo {
    String nome;
    String descrição;
    int preco;

    public Jogo(String nome, int preco, String descrição) {
        this.nome = nome;
        this.preco = preco;
        this.descrição = descrição;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPreco() {
        return preco;
    }

    public void setPreco(int preco) {
        this.preco = preco;
    }

    public String getDescrição() {
        return descrição;
    }

    public void setDescrição(String descrição) {
        this.descrição = descrição;
    }

    @Override
    public String toString() {
        return "\nNome: " + this.nome + ".\n Decrição: " + this.descrição + ". \n Preço: " + this.preco;
    }
}

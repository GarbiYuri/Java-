public class Cliente {
    private final String nome;
    private final int idade;
    private final int numeroHabilitacao;
    private final int idCarteira;
    private final Carteira carteira;

    public Cliente(String nome, int idade, int numeroHabilitacao, int idCarteira, Carteira carteira) {
        this.nome = nome;
        this.idade = idade;
        this.numeroHabilitacao = numeroHabilitacao;
        this.idCarteira = idCarteira;
        this.carteira = carteira;
    }

    public String getNome() {
        return nome;
    }

    public int getNumeroHabilitacao() {
        return numeroHabilitacao;
    }


    public int getIdade() {
        return idade;
    }


    public int getIdCarteira() {
        return idCarteira;
    }

    public Carteira getCarteira() {
        return carteira;
    }

    public double puxarCarteira() {
        return carteira.getQuantidadecart();
    }
}
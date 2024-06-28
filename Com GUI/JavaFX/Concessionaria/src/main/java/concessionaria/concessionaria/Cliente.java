package concessionaria.concessionaria;

// Classe Cliente representa um cliente da concessionária
public class Cliente {
    private final String nome; // Nome do cliente
    private final int idade; // Idade do cliente
    private final int numeroHabilitacao; // Número da habilitação do cliente
    private final int idCarteira; // ID da carteira do cliente
    private final Carteira carteira; // Carteira do cliente

    // Construtor da classe Cliente para inicializar seus atributos
    public Cliente(String nome, int idade, int numeroHabilitacao, int idCarteira, Carteira carteira) {
        this.nome = nome;
        this.idade = idade;
        this.numeroHabilitacao = numeroHabilitacao;
        this.idCarteira = idCarteira;
        this.carteira = carteira;
    }

    // Métodos para obter os atributos privados do cliente
    public String getNome() {
        return nome; // Retorna o nome do cliente
    }

    public int getNumeroHabilitacao() {
        return numeroHabilitacao; // Retorna o número da habilitação do cliente
    }

    public int getIdade() {
        return idade; // Retorna a idade do cliente
    }

    public int getIdCarteira() {
        return idCarteira; // Retorna o ID da carteira do cliente
    }

    public Carteira getCarteira() {
        return carteira; // Retorna a carteira do cliente
    }

    // Método para obter a quantidade de dinheiro na carteira do cliente
    public double puxarCarteira() {
        return carteira.getQuantidadecart(); // Retorna a quantidade de dinheiro na carteira do cliente
    }
}

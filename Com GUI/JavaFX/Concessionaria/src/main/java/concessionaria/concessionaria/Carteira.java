package concessionaria.concessionaria;

// Classe Carteira representa a carteira de dinheiro de um cliente na concessionária
public class Carteira {
    private double quantidadecart; // Quantidade de dinheiro na carteira
    private int idcart; // ID da carteira

    // Construtor da classe Carteira para inicializar seus atributos
    public Carteira(int idcart, double quantidadecart) {
        this.idcart = idcart;
        this.quantidadecart = quantidadecart;
    }

    // Métodos para obter e definir os atributos privados da carteira
    public int getIdcart() {
        return idcart; // Retorna o ID da carteira
    }

    public double getQuantidadecart() {
        return quantidadecart; // Retorna a quantidade de dinheiro na carteira
    }

    public void setQuantidadecart(double quantidadecart) {
        this.quantidadecart = quantidadecart; // Define a quantidade de dinheiro na carteira
    }

    // Método para adicionar dinheiro à carteira, se o ID da carteira corresponder
    public void colocarmais(int id, double qtd) {
        if (idcart == id) {
            quantidadecart += qtd; // Adiciona a quantidade especificada à carteira
        }
    }

    // Método para remover uma quantidade especificada de dinheiro da carteira, se o ID da carteira corresponder e houver saldo suficiente
    public void removerumpouco(int id, double qtd) {
        if (idcart == id) {
            if (quantidadecart >= qtd) {
                quantidadecart -= qtd; // Remove a quantidade especificada da carteira, se houver saldo suficiente
            }
        }
    }
}

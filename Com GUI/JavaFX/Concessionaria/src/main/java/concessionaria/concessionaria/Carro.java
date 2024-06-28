package concessionaria.concessionaria;

// Classe Carro representa um veículo na concessionária
public class Carro {
    private final String marca; // Marca do carro
    private final String modelo; // Modelo do carro
    private final int dataFabricacao; // Ano de fabricação do carro
    private final int chassi; // Número de chassi único do carro
    private final double preco; // Preço do carro

    // Construtor da classe Carro para inicializar seus atributos
    public Carro(String marca, String modelo, int dataFabricacao, int chassi, double preco) {
        this.marca = marca;
        this.modelo = modelo;
        this.dataFabricacao = dataFabricacao;
        this.chassi = chassi;
        this.preco = preco;
    }

    // Métodos para obter os atributos privados do carro
    public double getPreco() {
        return preco; // Retorna o preço do carro
    }

    public String getMarca() {
        return marca; // Retorna a marca do carro
    }

    public String getModelo() {
        return modelo; // Retorna o modelo do carro
    }

    public int getDataFabricacao() {
        return dataFabricacao; // Retorna o ano de fabricação do carro
    }

    public int getChassi() {
        return chassi; // Retorna o número de chassi do carro
    }
}

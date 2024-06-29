public class Carro {
    private final String marca;
    private final String modelo;
    private final int dataFabricacao;
    private final int chassi;
    private final double preco;

    public Carro(String marca, String modelo, int dataFabricacao, int chassi, double preco) {
        this.marca = marca;
        this.modelo = modelo;
        this.dataFabricacao = dataFabricacao;
        this.chassi = chassi;
        this.preco = preco;
    }

    public double getPreco() {
        return preco;
    }


    public String getMarca() {
        return marca;
    }


    public String getModelo() {
        return modelo;
    }


    public int getDataFabricacao() {
        return dataFabricacao;
    }


    public int getChassi() {
        return chassi;
    }


}
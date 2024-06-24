public class Carro {
    public String marca;
    public String modelo;
    public int ano;

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void MostrarDetalhes(){
        System.out.println("O Carro da marca: " + marca + " do ano: " + ano  +
                " do modelo: " + modelo + " esta andando...");
    }
}

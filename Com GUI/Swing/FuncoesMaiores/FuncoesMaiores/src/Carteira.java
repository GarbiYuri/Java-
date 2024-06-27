public class Carteira {
    private double quantidadecart;
    private int idcart;

    public Carteira(int idcart, double quantidadecart) {
        this.idcart = idcart;
        this.quantidadecart = quantidadecart;
    }

    public int getIdcart() {
        return idcart;
    }


    public double getQuantidadecart() {
        return quantidadecart;
    }

    public void setQuantidadecart(double quantidadecart) {
        this.quantidadecart = quantidadecart;
    }

    public void colocarmais(int id, double qtd) {
        if (idcart == id) {
            quantidadecart += qtd;
        }
    }

    public void removerumpouco(int id, double qtd) {
        if (idcart == id) {
            if (quantidadecart >= qtd) {
                quantidadecart -= qtd;
            }
        }
    }
}
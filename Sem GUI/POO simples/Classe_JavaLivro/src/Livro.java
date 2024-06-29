public class Livro {
    //atributos

    public String titulo, autor;
    public int ano;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    //métodos

    public void exibirDetalhes(){
        System.out.println("O Livro " + titulo + " do autor " + autor + " lançado no ano " + ano + " foi registrado com sucesso! Código do Livro: ");
    }
}

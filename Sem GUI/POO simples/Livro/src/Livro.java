public class Livro {
    public String titulo;
    public String autor;
    public int numero_de_paginas;

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


    public int getNumero_de_paginas() {
        return numero_de_paginas;
    }

    public void setNumero_de_paginas(int numero_de_paginas) {
        this.numero_de_paginas = numero_de_paginas;
    }

    public void acessar(){
        System.out.println("O Livro: " + titulo + " do autor: " + autor + " com numero: " + numero_de_paginas + " de páginas. Foi registrado com sucesso.");
    }
    public String modificar(String a){
        return "Dados do: "+ a +" Modificados...";

    }
}

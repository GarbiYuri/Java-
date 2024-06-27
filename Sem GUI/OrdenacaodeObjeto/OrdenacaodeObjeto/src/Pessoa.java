import java.util.ArrayList;
import java.util.List;

public class Pessoa {
    int Idade;
    String Nome;

    public Pessoa(String nome, int idade){
        this.Nome = nome;
        this.Idade = idade;
    }

    public int getIdade() {
        return Idade;
    }

    public void setIdade(int idade) {
        Idade = idade;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String Falas(){
        return "Nome: " + Nome + " Idade: " + Idade;
    }
    public static void main(String[] args) {
        List<Pessoa> pessoas = new ArrayList<>();
        pessoas.add(new Pessoa("João", 22));
        pessoas.add(new Pessoa("Luan", 40));
        pessoas.add(new Pessoa("Rodrigo", 15));
        pessoas.add(new Pessoa("Humberto", 25));
        pessoas.add(new Pessoa("Francisco", 70));

        pessoas.sort((a,b) -> b.getNome().compareTo(a.getNome()));
        System.out.println("Ordenado por nome:");
        pessoas.forEach(pessoa -> System.out.println(pessoa.Falas()));

        pessoas.sort((a,b) -> Integer.compare(b.getIdade(), a.getIdade()));
        System.out.println("Ordenado por Idade:");
        pessoas.forEach(pessoa -> System.out.println(pessoa.Falas()));



    }
}
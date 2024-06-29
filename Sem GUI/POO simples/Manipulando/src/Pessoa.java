public class Pessoa {
    public int idade;
    public String nome;
    private String end;

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    private String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void dados(){
        System.out.println("A pessoa: " + nome + " Que tem: " + idade + " anos. E mora no endereço: " + end);
    }
    public void andar(String a){
        System.out.println("Andar = " + a);
    }
}
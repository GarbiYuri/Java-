public class VeficarIdade {
    public  void verificaridade(int idade) throws IdadeInvalidaException{
        if (idade < 18 || idade > 100){
            throw new IdadeInvalidaException("Idade Inválida!!");
        }
        System.out.println("Idade Válida!!");
    }
}

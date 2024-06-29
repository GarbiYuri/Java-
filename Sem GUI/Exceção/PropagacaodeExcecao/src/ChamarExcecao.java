public class ChamarExcecao {
    public void verificareaplicar(String a) throws Minhaexcecao {
        if (a.length() != 4){
            throw new Minhaexcecao("A senha deve conter exatamente 4 dígitos.");
        }
       System.out.println("Senha Cadastrada!");
    }
}

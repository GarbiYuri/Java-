import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;

        try {
            // Caminho do arquivo a ser lido
            String nomeArquivo = "C:\\Users\\Francisco\\Desktop\\Leia.txt";

            // Inicializa FileReader e BufferedReader
            fileReader = new FileReader(nomeArquivo);
            bufferedReader = new BufferedReader(fileReader);

            // Leitura do arquivo linha por linha
            String linha;
            while ((linha = bufferedReader.readLine()) != null) {
                System.out.println(linha);
            }

        } catch (IOException e) {
            e.printStackTrace(); // Ou tratamento adequado da exceção
        }
        finally {
            // Fechamento dos recursos no bloco finally para garantir que sejam liberados corretamente
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                if (fileReader != null) {
                    fileReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace(); // Ou tratamento adequado da exceção ao fechar os recursos
            }
        }
    }
}

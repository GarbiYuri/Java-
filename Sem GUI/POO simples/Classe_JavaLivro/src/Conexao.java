import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Drive");
            Connection conexao = DriverManager.getConnection("127.0.0.1:3306", "usuario", "senha");
        } catch (ClassNotFoundException ex) {
            System.out.println("Banco de dados não localizado");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conectaDAO {

    public static Connection connectDB() {
        Connection conn = null;

        try {
            // URL de conexão corrigida para evitar problemas de SSL
            String url = "jdbc:mysql://localhost:3306/LeiloesTDSat?useSSL=false&allowPublicKeyRetrieval=true";
            String user = "root";
            String password = "38577894Weverton";

            conn = DriverManager.getConnection(url, user, password);

        } catch (SQLException e) {
            System.out.println("Erro de conexão: " + e.getMessage());
        }

        return conn;
    }
}

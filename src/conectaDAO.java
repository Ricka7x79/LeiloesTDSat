
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adm
 */
public class conectaDAO {
    
    public static Connection connectDB() {
        Connection conn = null;

        try {
            String url = "jdbc:mysql://localhost:3306/LeiloesTDSat";
            String user = "root";
            String password = "38577894Weverton";

            conn = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            System.out.println("Erro de conexão: " + e.getMessage());
        }

        return conn;
    }
}

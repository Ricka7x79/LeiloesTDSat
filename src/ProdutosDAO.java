import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProdutosDAO {

    // ✅ CADASTRAR PRODUTO
    public boolean cadastrarProduto(ProdutosDTO produto) {

        String sql = "INSERT INTO produtos (nome, valor, status) VALUES (?, ?, ?)";

        // try-with-resources garante fechamento automático de Connection e PreparedStatement
        try (Connection conn = conectaDAO.connectDB();
             PreparedStatement prep = conn.prepareStatement(sql)) {

            prep.setString(1, produto.getNome());
            prep.setInt(2, produto.getValor());
            prep.setString(3, produto.getStatus());

            prep.executeUpdate();

            return true; // SUCESSO

        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar: " + e.getMessage());
            return false; // ERRO
        }
    }

    // ✅ LISTAR PRODUTOS
    public ArrayList<ProdutosDTO> listarProdutos() {

        ArrayList<ProdutosDTO> listagem = new ArrayList<>();
        String sql = "SELECT * FROM produtos";

        try (Connection conn = conectaDAO.connectDB();
             PreparedStatement prep = conn.prepareStatement(sql);
             ResultSet resultset = prep.executeQuery()) {

            while (resultset.next()) {
                ProdutosDTO produto = new ProdutosDTO();
                produto.setId(resultset.getInt("id"));
                produto.setNome(resultset.getString("nome"));
                produto.setValor(resultset.getInt("valor"));
                produto.setStatus(resultset.getString("status"));

                listagem.add(produto);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar produtos: " + e.getMessage());
        }

        return listagem;
    }

    // ✅ VENDER PRODUTO
    public boolean venderProduto(int id) {

        String sql = "UPDATE produtos SET status = ? WHERE id = ?";

        try (Connection conn = conectaDAO.connectDB();
             PreparedStatement prep = conn.prepareStatement(sql)) {

            prep.setString(1, "Vendido");
            prep.setInt(2, id);

            prep.executeUpdate();

            return true;

        } catch (SQLException e) {
            System.out.println("Erro ao vender produto: " + e.getMessage());
            return false;
        }
    }
    
    
    
    // ✅ LISTAR PRODUTOS VENDIDOS
public ArrayList<ProdutosDTO> listarProdutosVendidos() {
    ArrayList<ProdutosDTO> listagem = new ArrayList<>();
    String sql = "SELECT * FROM produtos WHERE status = 'Vendido'";

    try (Connection conn = conectaDAO.connectDB();
         PreparedStatement prep = conn.prepareStatement(sql);
         ResultSet resultset = prep.executeQuery()) {

        while (resultset.next()) {
            ProdutosDTO produto = new ProdutosDTO();
            produto.setId(resultset.getInt("id"));
            produto.setNome(resultset.getString("nome"));
            produto.setValor(resultset.getInt("valor"));
            produto.setStatus(resultset.getString("status"));
            listagem.add(produto);
        }

    } catch (SQLException e) {
        System.out.println("Erro ao listar produtos vendidos: " + e.getMessage());
    }

    return listagem;
}
}

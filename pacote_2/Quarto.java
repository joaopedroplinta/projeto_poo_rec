package pacote_2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Quarto {
    private int numero;
    private String categoria;
    private String status;

    private static final String URL = "jdbc:postgresql://localhost:5432/projeto_poo";
    private static final String USUARIO = "postgres";
    private static final String SENHA = "1234";

    public Quarto(int numero, String categoria, String status) {
        this.numero = numero;
        this.categoria = categoria;
        this.status = status;
    }

    public int getNumero() {
        return numero;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String novoStatus) {
        this.status = novoStatus;
    }

    private Connection abrirConexao() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, SENHA);
    }

    public void criarQuarto(int Numero, String Categoria, String Status) {
        try (Connection conexao = abrirConexao();
             PreparedStatement preparedStatement = conexao.prepareStatement(
                     "INSERT INTO quartos (numero, categoria, status) VALUES (?, ?, ?)")) {

            preparedStatement.setInt(1, Numero);
            preparedStatement.setString(2, Categoria);
            preparedStatement.setString(3, Status);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Quarto lerQuarto(int numero) {
        Quarto quarto = null;

        try (Connection conexao = abrirConexao();
            PreparedStatement preparedStatement = conexao.prepareStatement(
                "SELECT * FROM quartos WHERE numero = ?")) {

            preparedStatement.setInt(1, numero);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    quarto = new Quarto(
                            resultSet.getInt("numero"),
                            resultSet.getString("categoria"),
                            resultSet.getString("status")
                    );
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return quarto;
    }

    public void atualizarQuarto(int numero, Quarto novosDados) {
        try (Connection conexao = abrirConexao();
            PreparedStatement preparedStatement = conexao.prepareStatement(
                "UPDATE quartos SET status = ? WHERE numero = ?")) {

            preparedStatement.setString(1, novosDados.getStatus());
            preparedStatement.setInt(2, numero);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletarQuarto(int numero) {
        try (Connection conexao = abrirConexao();
            PreparedStatement preparedStatement = conexao.prepareStatement(
                "DELETE FROM quartos WHERE numero = ?")) {

            preparedStatement.setInt(1, numero);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
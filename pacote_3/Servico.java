package pacote_3;

import java.sql.*;

public class Servico {
    private int ID;
    private String descricao;
    private double preco;

    private static final String URL = "jdbc:postgresql://localhost:5432/projeto_poo";
    private static final String USUARIO = "postgres";
    private static final String SENHA = "1234";

    // Construtor
    public Servico(int ID, String descricao, double preco) {
        this.ID = ID;
        this.descricao = descricao;
        this.preco = preco;
    }

    // Getters e Setters
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    // Método auxiliar para conexão
    private Connection abrirConexao() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, SENHA);
    }

    // CRUD metodos
    public void criarServico(int novoID, String novaDescricao, double novoPreco) {
        try (Connection conexao = abrirConexao();
            PreparedStatement preparedStatement = conexao.prepareStatement(
                "INSERT INTO servicos (ID, descricao, preco) VALUES (?, ?, ?)")) {

            preparedStatement.setInt(1, novoID);
            preparedStatement.setString(2, novaDescricao);
            preparedStatement.setDouble(3, novoPreco);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace(); // ou lidar com a exceção de acordo com sua lógica de tratamento de erros
        }
    }

    public Servico lerServico(int ID) {
        Servico servico = null;

        try (Connection conexao = abrirConexao();
            PreparedStatement preparedStatement = conexao.prepareStatement(
                "SELECT * FROM servicos WHERE ID = ?")) {

            preparedStatement.setInt(1, ID);

            try (ResultSet resultado = preparedStatement.executeQuery()) {
                if (resultado.next()) {
                    servico = new Servico(resultado.getInt("ID"),
                            resultado.getString("descricao"),
                            resultado.getDouble("preco"));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace(); // ou lidar com a exceção de acordo com sua lógica de tratamento de erros
        }

        return servico;
    }

    public void atualizarServico(int ID, String novaDescricao, double novoPreco) {
        try (Connection conexao = abrirConexao();
            PreparedStatement preparedStatement = conexao.prepareStatement(
                "UPDATE servicos SET descricao = ?, preco = ? WHERE ID = ?")) {

            preparedStatement.setString(1, novaDescricao);
            preparedStatement.setDouble(2, novoPreco);
            preparedStatement.setInt(3, ID);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace(); // ou lidar com a exceção de acordo com sua lógica de tratamento de erros
        }
    }

    public void deletarServico(int ID) {
        try (Connection conexao = abrirConexao();
            PreparedStatement preparedStatement = conexao.prepareStatement(
                "DELETE FROM servicos WHERE ID = ?")) {

            preparedStatement.setInt(1, ID);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace(); // ou lidar com a exceção de acordo com sua lógica de tratamento de erros
        }
    }
}
package pacote_1;

import java.sql.*;

public class Funcionario extends Usuario {

    private static final String URL = "jdbc:postgresql://localhost:5432/projeto_poo";
    private static final String USUARIO = "postgres";
    private static final String SENHA = "1234";


    public Funcionario(int ID, String CPF, String nome, int telefone, String endereco) {
        super(ID, CPF, nome, telefone, endereco);
    }

    // Método auxiliar para conexão
    private Connection abrirConexao() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, SENHA);
    }

    public void criarFuncionario(int ID, String CPF, String nome, int telefone, String endereco) {
        try (Connection conexao = abrirConexao();
                PreparedStatement preparedStatement = conexao.prepareStatement(
                        "INSERT INTO funcionarios (ID, CPF, nome, telefone, endereco) VALUES (?, ?, ?, ?, ?)")) {

            preparedStatement.setInt(1, ID);
            preparedStatement.setString(2, CPF);
            preparedStatement.setString(3, nome);
            preparedStatement.setInt(4, telefone);
            preparedStatement.setString(5, endereco);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace(); // ou lidar com a exceção de acordo com sua lógica de tratamento de erros
        }
    }

    public Funcionario lerFuncionario(int ID) {
        Funcionario funcionario = null;

        try (Connection conexao = abrirConexao();
                PreparedStatement preparedStatement = conexao.prepareStatement(
                        "SELECT * FROM funcionarios WHERE ID = ?")) {

            preparedStatement.setInt(1, ID);
            try (var resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    funcionario = new Funcionario(resultSet.getInt("ID"), resultSet.getString("CPF"),
                            resultSet.getString("nome"), resultSet.getInt("telefone"), resultSet.getString("endereco"));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace(); // ou lidar com a exceção de acordo com sua lógica de tratamento de erros
        }

        return funcionario;
    }

    public void atualizarFuncionario(int ID, String CPF, String nome, int telefone, String endereco) {
        try (Connection conexao = abrirConexao();
                PreparedStatement preparedStatement = conexao.prepareStatement(
                        "UPDATE funcionarios SET CPF = ?, nome = ?, telefone = ?, endereco = ? WHERE ID = ?")) {

            preparedStatement.setString(1, CPF);
            preparedStatement.setString(2, nome);
            preparedStatement.setInt(3, telefone);
            preparedStatement.setString(4, endereco);
            preparedStatement.setInt(5, ID);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace(); // ou lidar com a exceção de acordo com sua lógica de tratamento de erros
        }
    }

    public void deletarFuncionario(int ID) {
        try (Connection conexao = abrirConexao();
                PreparedStatement preparedStatement = conexao.prepareStatement(
                        "DELETE FROM funcionarios WHERE ID = ?")) {

            preparedStatement.setInt(1, ID);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace(); // ou lidar com a exceção de acordo com sua lógica de tratamento de erros
        }
    }
}
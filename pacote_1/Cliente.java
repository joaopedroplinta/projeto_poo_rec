package pacote_1;

import java.sql.*;

public class Cliente extends Usuario{

    private static final String URL = "jdbc:postgresql://localhost:5432/projeto_poo";
    private static final String USUARIO = "postgres";
    private static final String SENHA = "1234";

    public Cliente(int ID, String CPF, String nome, String endereco, int telefone) {
        super(ID,CPF,nome,telefone,endereco);
    }

    // Método auxiliar para conexão
    private Connection abrirConexao() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, SENHA);
    }
    public void criarCliente(int ID, String CPF, String nome, String endereco, int telefone) {
        try (Connection conexao = abrirConexao();
                PreparedStatement preparedStatement = conexao.prepareStatement(
                        "INSERT INTO clientes (ID, CPF, nome, telefone, endereco) VALUES (?, ?, ?, ?, ?)")) {

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

    public Cliente lerCliente(int ID) {
        Cliente cliente = null;

        try (Connection conexao = abrirConexao();
                PreparedStatement preparedStatement = conexao.prepareStatement(
                        "SELECT * FROM clientes WHERE ID = ?")) {

            preparedStatement.setInt(1, ID);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    setID(resultSet.getInt("ID"));
                    setCPF(resultSet.getString("CPF"));
                    setNome(resultSet.getString("nome"));
                    setTelefone(resultSet.getInt("telefone"));
                    setEndereco(resultSet.getString("endereco"));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace(); // ou lidar com a exceção de acordo com sua lógica de tratamento de erros
        }

        return cliente;
    }

    public void atualizarCliente(int ID, String CPF, String nome, int telefone, String endereco){
        try (Connection conexao = abrirConexao();
                PreparedStatement preparedStatement = conexao.prepareStatement(
                        "UPDATE clientes SET CPF = ?, nome = ?, telefone = ?, endereco = ? WHERE ID = ?")) {

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

    public void deletarCliente(int ID) {
        try (Connection conexao = abrirConexao();
                PreparedStatement preparedStatement = conexao.prepareStatement(
                        "DELETE FROM clientes WHERE ID = ?")) {

            preparedStatement.setInt(1, ID);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            // Lidar com a exceção de acordo com sua lógica de tratamento de erros
            e.printStackTrace();
        }
    }
}
package pacote_1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Usuario {
    private int ID;
    private String CPF;
    private String nome;
    private int telefone;
    private String endereco;

    public Usuario(int ID, String CPF, String nome, int telefone, String endereco) {
        this.ID = ID;
        this.CPF = CPF;
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    // Getters and Setters são usados para proteger seus dados, especialmente na
    // criação de classes.
    public int getID() {
        return ID;
    }

    public String getCPF() {
        return CPF;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public int getTelefone() {
        return this.telefone;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    // Método auxiliar para conexão
    private Connection abrirConexao() throws SQLException {
        return DriverManager.getConnection(Definitions.URL, Definitions.USUARIO, Definitions.SENHA);
    }

    public void criar(Usuario usuario) {
        try (Connection conexao = abrirConexao();
                PreparedStatement preparedStatement = conexao.prepareStatement(
                        "INSERT INTO servicos (ID, CPF, nome, telefone, endereco) VALUES (?, ?, ?, ?, ?)")) {

            preparedStatement.setInt(1, usuario.ID);
            preparedStatement.setString(2, usuario.CPF);
            preparedStatement.setString(3, usuario.nome);
            preparedStatement.setInt(4, usuario.telefone);
            preparedStatement.setString(5, usuario.endereco);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace(); // ou lidar com a exceção de acordo com sua lógica de tratamento de erros
        }
    }

    public Usuario ler(int ID) {
        Usuario usuario = null;

        try (Connection conexao = abrirConexao();
                PreparedStatement preparedStatement = conexao.prepareStatement(
                        "SELECT * FROM Usuario WHERE ID = ?")) {

            preparedStatement.setInt(1, ID);

            try (ResultSet resultado = preparedStatement.executeQuery()) {
                if (resultado.next()) {
                    usuario = new Usuario(resultado.getInt("ID"),
                            resultado.getString("CPF"),
                            resultado.getString("nome"),
                            resultado.getInt("telefone"),
                            resultado.getString("endereco"));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace(); // ou lidar com a exceção de acordo com sua lógica de tratamento de erros
        }

        return usuario;
    }

    public void atualizar(Usuario usuario) {
        try (Connection conexao = abrirConexao();
                PreparedStatement preparedStatement = conexao.prepareStatement(
                        "UPDATE Usuario SET CPF = ?, nome = ?, telefone = ?, endereco = ? WHERE ID = ?")) {

            preparedStatement.setString(1, usuario.CPF);
            preparedStatement.setString(2, usuario.nome);
            preparedStatement.setInt(3, usuario.telefone);
            preparedStatement.setString(4, usuario.endereco);
            preparedStatement.setInt(5, usuario.ID);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace(); // ou lidar com a exceção de acordo com sua lógica de tratamento de erros
        }
    }

    public void deletar(int ID) {
        try (Connection conexao = abrirConexao();
                PreparedStatement preparedStatement = conexao.prepareStatement(
                        "DELETE FROM Usuario WHERE ID = ?")) {

            preparedStatement.setInt(1, ID);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            // Lidar com a exceção de acordo com sua lógica de tratamento de erros
            e.printStackTrace();
        }
    }
}

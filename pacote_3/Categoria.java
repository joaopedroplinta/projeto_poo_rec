package pacote_3;

import java.sql.*;

public class Categoria {
    private int ID;
    private String nome;
    private String descricao;
    
    private static final String URL = "jdbc:postgresql://localhost:5432/projeto_poo";
    private static final String USUARIO = "postgres";
    private static final String SENHA = "sua_senha";

    // Construtor
    public Categoria(int ID, String nome, String descricao) {
        this.ID = ID;
        this.nome = nome;
        this.descricao = descricao;
    }

    // Getters e Setters
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        if (nome.length() > 0) {
            this.nome = nome;
        }
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        if (descricao.length() > 0) {
            this.descricao = descricao;
        }
    }

    // Método auxiliar para conexão com o banco de dados
    private Connection abrirConexao() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, SENHA);
    }

    // CRUD methods
    public void criar(int novoID, String novoNome, String novaDescricao) {
        try (Connection conexao = abrirConexao();
            PreparedStatement preparedStatement = conexao.prepareStatement(
                "INSERT INTO categorias (ID, nome, descricao) VALUES (?, ?, ?)")) {

            preparedStatement.setInt(1, novoID);
            preparedStatement.setString(2, novoNome);
            preparedStatement.setString(3, novaDescricao);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            // Lidar com a exceção de acordo com sua lógica de tratamento de erros
            e.printStackTrace();
        }
    }

    public Categoria ler(int ID) {
        Categoria categoria = null;

        try (Connection conexao = abrirConexao();
            PreparedStatement preparedStatement = conexao.prepareStatement(
                "SELECT * FROM categorias WHERE ID = ?")) {

            preparedStatement.setInt(1, ID);

            try (ResultSet resultado = preparedStatement.executeQuery()) {
                if (resultado.next()) {
                    categoria = new Categoria(resultado.getInt("ID"),
                            resultado.getString("nome"),
                            resultado.getString("descricao"));
                }
            }

        } catch (SQLException e) {
            // Lidar com a exceção de acordo com sua lógica de tratamento de erros
            e.printStackTrace();
        }

        return categoria;
    }

    public void atualizar(int ID, String novoNome, String novaDescricao) {
        try (Connection conexao = abrirConexao();
            PreparedStatement preparedStatement = conexao.prepareStatement(
                "UPDATE categorias SET nome = ?, descricao = ? WHERE ID = ?")) {

            preparedStatement.setString(1, novoNome);
            preparedStatement.setString(2, novaDescricao);
            preparedStatement.setInt(3, ID);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            // Lidar com a exceção de acordo com sua lógica de tratamento de erros
            e.printStackTrace();
        }
    }

    public void deletar(int ID) {
        try (Connection conexao = abrirConexao();
            PreparedStatement preparedStatement = conexao.prepareStatement(
                "DELETE FROM categorias WHERE ID = ?")) {

            preparedStatement.setInt(1, ID);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            // Lidar com a exceção de acordo com sua lógica de tratamento de erros
            e.printStackTrace();
        }
    }
}
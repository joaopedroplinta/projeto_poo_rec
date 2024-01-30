package pacote_2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Reserva {
    private int id;
    private String cliente;
    private Quarto quarto;
    private String dataCheckIn;
    private String dataCheckOut;
    private double valorTotal;

    private static final String URL = "jdbc:postgresql://localhost:5432/projeto_poo";
    private static final String USUARIO = "postgres";
    private static final String SENHA = "1234";

    public Reserva(int id, String cliente, Quarto quarto, String dataCheckIn, String dataCheckOut, double valorTotal) {
        this.id = id;
        this.cliente = cliente;
        this.quarto = quarto;
        this.dataCheckIn = dataCheckIn;
        this.dataCheckOut = dataCheckOut;
        this.valorTotal = valorTotal;
    }

    public int getId() {
        return id;
    }

    public String getCliente() {
        return cliente;
    }

    public Quarto getQuarto() {
        return quarto;
    }

    public String getDataCheckIn() {
        return dataCheckIn;
    }

    public String getDataCheckOut() {
        return dataCheckOut;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double novoValorTotal) {
        this.valorTotal = novoValorTotal;
    }

    private Connection abrirConexao() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, SENHA);
    }

    public void criarReserva() {
        try (Connection conexao = abrirConexao();
             PreparedStatement preparedStatement = conexao.prepareStatement(
                     "INSERT INTO reservas (cliente, quarto_id, data_checkin, data_checkout, valor_total) " +
                             "VALUES (?, ?, ?, ?, ?)")) {

            preparedStatement.setString(1, cliente);
            preparedStatement.setInt(2, quarto.getNumero());
            preparedStatement.setString(3, dataCheckIn);
            preparedStatement.setString(4, dataCheckOut);
            preparedStatement.setDouble(5, valorTotal);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Reserva lerReserva(int id) {
        Reserva reserva = null;

        try (Connection conexao = abrirConexao();
             PreparedStatement preparedStatement = conexao.prepareStatement(
                     "SELECT * FROM reservas WHERE id = ?")) {

            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    reserva = new Reserva(
                            resultSet.getInt("id"),
                            resultSet.getString("cliente"),
                            new Quarto(
                                    resultSet.getInt("quarto_id"),
                                    resultSet.getString("categoria"),
                                    resultSet.getString("status")
                            ),
                            resultSet.getString("data_checkin"),
                            resultSet.getString("data_checkout"),
                            resultSet.getDouble("valor_total")
                    );
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return reserva;
    }

    public void atualizarReserva(int id, double novoValorTotal) {
        try (Connection conexao = abrirConexao();
            PreparedStatement preparedStatement = conexao.prepareStatement(
                "UPDATE reservas SET valor_total = ? WHERE id = ?")) {

            preparedStatement.setDouble(1, novoValorTotal);
            preparedStatement.setInt(2, id);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletarReserva(int id) {
        try (Connection conexao = abrirConexao();
            PreparedStatement preparedStatement = conexao.prepareStatement(
                "DELETE FROM reservas WHERE id = ?")) {

            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
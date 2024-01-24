package pacote_2;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Reserva {
    private int id;
    private String cliente;
    private Quarto quarto;
    private String dataCheckIn;
    private String dataCheckOut;
    private double valorTotal;
    private List<Reserva> reservas;

    private static final String URL = "jdbc:postgresql://localhost:5432/projeto_poo";
    private static final String USUARIO = "postgres";
    private static final String SENHA = "1234";

    // Construtor
    public Reserva(int id, String cliente, Quarto quarto, String dataCheckIn, String dataCheckOut, double valorTotal) {
        this.id = id;
        this.cliente = cliente;
        this.quarto = quarto;
        this.dataCheckIn = dataCheckIn;
        this.dataCheckOut = dataCheckOut;
        this.valorTotal = valorTotal;
        this.reservas = new ArrayList<>();
    }

    // Getters e Setters
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

    // Método auxiliar para conexão
    private Connection abrirConexao() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, SENHA);
    }

    // Métodos CRUD para Reserva
    public void criarReserva(Reserva reserva) {
        reservas.add(reserva);
    }

    public Reserva lerReserva(int id) {
        for (Reserva reserva : reservas) {
            if (reserva.getId() == id) {
                return reserva;
            }
        }
        return null;
    }

    public void atualizarReserva(int id, Reserva novosDados) {
        Reserva reserva = lerReserva(id);
        if (reserva != null) {
            reserva.setValorTotal(novosDados.getValorTotal());
        }
    }

    public void deletarReserva(int id) {
        Reserva reserva = lerReserva(id);
        if (reserva != null) {
            reservas.remove(reserva);
        }
    }
}
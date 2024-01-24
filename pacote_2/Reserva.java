package pacote_2;

public class Reserva {
    private int id;
    private String cliente;
    private Quarto quarto;
    private String dataCheckIn;
    private String dataCheckOut;
    private double valorTotal;

    // Construtor
    public Reserva(int id, String cliente, Quarto quarto, String dataCheckIn, String dataCheckOut, double valorTotal) {
        this.id = id;
        this.cliente = cliente;
        this.quarto = quarto;
        this.dataCheckIn = dataCheckIn;
        this.dataCheckOut = dataCheckOut;
        this.valorTotal = valorTotal;
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
}
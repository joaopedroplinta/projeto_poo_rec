package pacote_2;

public class Quarto {
    private int numero;
    private String categoria;
    private String status;

    // Construtor
    public Quarto(int numero, String categoria, String status) {
        this.numero = numero;
        this.categoria = categoria;
        this.status = status;
    }

    // Getters e Setters
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
}

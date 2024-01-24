package pacote_2;

import java.util.ArrayList;
import java.util.List;

public class Quarto {
    private int numero;
    private String categoria;
    private String status;
    private List<Quarto> quartos;

    // Construtor
    public Quarto(int numero, String categoria, String status) {
        this.numero = numero;
        this.categoria = categoria;
        this.status = status;
        this.quartos = new ArrayList<>();
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

     // Métodos CRUD para Quarto
    public void criarQuarto(Quarto quarto) {
        quartos.add(quarto);
    }

    public Quarto lerQuarto(int numero) {
        for (Quarto quarto : quartos) {
            if (quarto.getNumero() == numero) {
                return quarto;
            }
        }
        return null;
    }

    public void atualizarQuarto(int numero, Quarto novosDados) {
        Quarto quarto = lerQuarto(numero);
        if (quarto != null) {
            quarto.setStatus(novosDados.getStatus());
        }
    }


    public void deletarQuarto(int numero) {
        Quarto quarto = lerQuarto(numero);
        if (quarto != null) {
            quartos.remove(quarto);
        }
    }
}

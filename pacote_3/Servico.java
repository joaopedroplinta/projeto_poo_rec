package pacote_3;

public class Servico {
    private int ID;
    private String descricao;
    private double preco;

    // Constructor
    public Servico(int ID, String descricao, double preco) {
        this.ID = ID;
        this.descricao = descricao;
        this.preco = preco;
    }

    // Getters and Setters
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

    // CRUD methods
    public void create() {
        // Implementation for creating a new Servico object
    }

    public Servico read(int ID) {
        // Implementation for reading a Servico object by ID
        return null;
    }

    public void update() {
        // Implementation for updating an existing Servico object
    }

    public void delete() {
        // Implementation for deleting an existing Servico object
    }
}
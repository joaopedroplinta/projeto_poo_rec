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

    // CRUD metodos
    public void criar() {
        // Implementação para criar um novo objeto Servico
    }

    public Servico ler(int ID) {
        // Implementação para ler um objeto Servico pelo ID
        return null;
    }

    public void atualizar() {
        // Implementação para atualizar um objeto Servico existente
    }

    public void deletar() {
        // Implementação para deletar um objeto Servico existente
    }
}
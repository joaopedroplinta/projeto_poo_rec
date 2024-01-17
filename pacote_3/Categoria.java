package pacote_3;

public class Categoria {
    private int ID;
    private String nome;
    private String descricao;

    // Construtor
    public Categoria(int ID, String nome, String descricao) {
        this.ID = ID;
        this.nome = nome;
        this.descricao = descricao;
    }

    // Getters and Setters
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

    // CRUD methods
    public void create() {
        // Implementation for creating a new Categoria object
    }

    public Categoria read(int ID) {
        // Implementation for reading a Categoria object by ID
        return null;
    }

    public void update() {
        // Implementation for updating an existing Categoria object
    }

    public void delete() {
        // Implementation for deleting an existing Categoria object
    }
}
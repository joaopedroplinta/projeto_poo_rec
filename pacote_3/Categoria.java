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
    public void criar() {
        // Implementação para criar um novo objeto Categoria
    }

    public Categoria ler(int ID) {
        // Implementação para ler um objeto Categoria pelo ID
        return null;
    }

    public void atualizar() {
        // Implementação para atualizar um objeto Categoria existente
    }

    public void deletar() {
        // Implementação para deletar um objeto Categoria existente
    }
}
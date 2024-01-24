package pacote_1;

public class Usuario {
    private int ID;
    private String CPF;
    private String nome;
    private int telefone;
    private String endereco;

    public Usuario(int ID, String CPF, String nome, int telefone, String endereco){
        this.ID = ID;
        this.CPF = CPF;
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
    }
  // Getters and Setters são usados para proteger seus dados, especialmente na criação de classes.
    public int getID() {
        return ID;
    }

    public String getCPF() {
        return CPF;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public int getTelefone() {
        return this.telefone;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }
}

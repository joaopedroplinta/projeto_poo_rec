package pacote_1;

import java.util.List;

public class Cliente {
    private int ID;
    private String nome;
    private String endereco;
    private String telefone;


    public Cliente(int ID, String nome, String endereco, String telefone) {
        this.ID = ID;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    public static Cliente criarCliente(int ID, String nome, String endereco, String telefone) {
        return new Cliente(ID, nome, endereco, telefone);
    }

    public static Cliente lerCliente(int ID, List<Cliente> clientes) {
        for (Cliente cliente : clientes) {
            if (cliente.getID() == ID) { // o get simula entrada do cliente
                return cliente;
            }
        }
        return null; 
    }

    
    public static void atualizarCliente(int ID, List<Cliente> clientes, Cliente novosDados) {
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getID() == ID) {
                clientes.set(i, novosDados);
                break;
            }
        }
    }

    public static void excluirCliente(int ID, List<Cliente> clientes) {
        clientes.removeIf(cliente -> cliente.getID() == ID);
    }

    // Getters and Setters são usados para proteger seus dados, especialmente na criação de classes.
    public int getID() {
        return ID;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public int setID(int ID) {
        return this.ID = ID;
    }

    public String setNome(String nome) {
        return this.nome = nome;
    }

    public String setEndereco(String endereco) {
        return this.endereco = endereco;
    }

    public String setTelefone(String telefone) {
        return this.telefone = telefone;
    }
}
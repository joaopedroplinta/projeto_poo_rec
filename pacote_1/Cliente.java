package pacote_1;

import java.util.List;

public class Cliente extends Usuario{

    public Cliente(int ID, String CPF, String nome, String endereco, int telefone) {
        super(ID,CPF,nome,telefone,endereco);
    }

    public static Cliente criarCliente(int ID, String CPF, String nome, String endereco, int telefone) {
        return new Cliente(ID, CPF, nome, endereco, telefone);
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
}

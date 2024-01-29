package pacote_1;

import java.util.List;

public class Funcionario extends Usuario {

    public Funcionario(int ID, String CPF, String nome, int telefone, String endereco) {
        super(ID, CPF, nome, telefone, endereco);
    }

    public static Funcionario criarFuncionario(int ID, String CPF, String nome, int telefone, String endereco) {
        return new Funcionario(ID, CPF, nome, telefone, endereco);
    }

    public static Funcionario lerFuncionario(int ID, List<Funcionario> funcionarios) {
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getID() == ID) { // o get simula entrada do funcionario
                return funcionario;
            }
        }
        return null;
    }

    public static void atualizarFuncionario(int ID, List<Funcionario> funcionarios, Funcionario novosDados) {
        for (int i = 0; i < funcionarios.size(); i++) {
            if (funcionarios.get(i).getID() == ID) {
                funcionarios.set(i, novosDados);
                break;
            }
        }
    }

    public static void excluirFuncionario(int ID, List<Funcionario> funcionarios) {
        funcionarios.removeIf(funcionario -> funcionario.getID() == ID);
    }
}

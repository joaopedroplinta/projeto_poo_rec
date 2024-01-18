package pacote_3;
import java.util.ArrayList;
import java.util.List;

public class Servico {
    private int ID;
    private String descricao;
    private double preco;
    private static List<Servico> listaDeServicos;

    // Constructor
    public Servico(int ID, String descricao, double preco) {
        this.ID = ID;
        this.descricao = descricao;
        this.preco = preco;
        listaDeServicos = new ArrayList<>();
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
    public void criar(int novoID, String novaDescricao, double novoPreco) {
        // Implementação para criar um novo objeto Servico
        Servico novoServico = new Servico(novoID, novaDescricao, novoPreco);
        listaDeServicos.add(novoServico);
    }

    public Servico ler(int ID) {
        // Implementação para ler um objeto Servico pelo ID
        for (Servico servico : listaDeServicos) {
            if (servico.getID() == ID) {
                return servico;
            }
        }
        return null;
    }

    public void atualizar(int ID, String novaDescricao, double novoPreco) {
        // Implementação para atualizar um objeto Servico existente
        for (Servico servico : listaDeServicos) {
            if (servico.getID() == ID) {
                servico.setDescricao(novaDescricao);
                servico.setPreco(novoPreco);

                break;
            }
        }
    }

    public void deletar(int ID) {
        // Implementação para deletar um objeto Servico existente
        Servico servicoParaRemover = null;
        for (Servico servico : listaDeServicos) {
            if (servico.getID() == ID) {
                servicoParaRemover = servico;
                break;
            }
        }
        if (servicoParaRemover != null) {
            listaDeServicos.remove(servicoParaRemover);
        }
    }
}
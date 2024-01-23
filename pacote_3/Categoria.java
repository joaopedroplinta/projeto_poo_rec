package pacote_3;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class Categoria {
    private int ID;
    private String nome;
    private String descricao;
    private static List<Categoria> listaDeCategorias;
    
    private static final String URL = "jdbc:postgresql://localhost:5432/projeto_poo";
    private static final String USUARIO = "postgres";
    private static final String SENHA = "sua_senha";

    // Construtor
    public Categoria(int ID, String nome, String descricao) {
        this.ID = ID;
        this.nome = nome;
        this.descricao = descricao;
        listaDeCategorias = new ArrayList<>();
    }

    // Getters e Setters
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
    public void criar(int novoID, String novoNome, String novaDescricao) {
        // Implementação para criar um novo objeto Categoria
        Categoria novaCategoria = new Categoria(novoID, novoNome, novaDescricao);
        listaDeCategorias.add(novaCategoria);

    }

    public Categoria ler(int ID) {
        // Implementação para ler um objeto Categoria pelo ID
        for (Categoria categoria : listaDeCategorias) {
            if (categoria.getID() == ID) {
                return categoria;
            }
        }
        return null;
    }

    public void atualizar(int ID, String novoNome, String novaDescricao) {
        // Implementação para atualizar um objeto Categoria existente
        for (Categoria categoria : listaDeCategorias) {
            if (categoria.getID() == ID) {
                categoria.setNome(novoNome);
                categoria.setDescricao(novaDescricao);

                break;
            }
        }
    }

    public void deletar(int ID) {
        // Implementação para deletar um objeto Categoria existente
        Categoria categoriaParaRemover = null;
        for (Categoria categoria : listaDeCategorias) {
            if (categoria.getID() == ID) {
                categoriaParaRemover = categoria;
                break;
            }
        }
        if (categoriaParaRemover != null) {
            listaDeCategorias.remove(categoriaParaRemover);
        }
    }
}
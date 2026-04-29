/*
 * Disciplina: CBTSWE1 - ADS 571
 * Professor: Wellington Tuler Moraes
 * Trabalho Prático 02 - CRUD Banco em Memória
 * Dupla: Gustavo Murai e Igor Murai
 * Data: 28/04/2026
 */
package br.edu.ifsp.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import br.edu.ifsp.model.Produto;

public class Banco {

    // A lista estática atua como nossa tabela no banco de dados
    private static List<Produto> listaProdutos = new ArrayList<>();
    private static int chaveSequencial = 1;

    // Bloco estático para popular o banco com dados iniciais para testes
    static {
        Produto p1 = new Produto();
        p1.setNome("Monitor Alienware AW2724DM");
        p1.setDescricao("Monitor Gamer Dell 27 polegadas");
        p1.setUnidadeCompra(2);
        p1.setQtdPrevistoMes(1.0);
        p1.setPrecoMaxComprado(3500.00);
        adiciona(p1);
        
        Produto p2 = new Produto();
        p2.setNome("Teclado Mecânico Corsair");
        p2.setDescricao("Teclado com switch Cherry MX Red");
        p2.setUnidadeCompra(5);
        p2.setQtdPrevistoMes(3.0);
        p2.setPrecoMaxComprado(850.00);
        adiciona(p2);
    }

    // CREATE (Salvar)
    public static void adiciona(Produto produto) {
        produto.setId(Banco.chaveSequencial++);
        listaProdutos.add(produto);
    }

    // READ (Listar todos)
    public static List<Produto> getProdutos() {
        return Banco.listaProdutos;
    }

    // READ (Buscar um específico pelo ID)
    public static Produto buscaProdutoPelaId(int id) {
        for (Produto p : listaProdutos) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    // UPDATE (Atualizar)
    public static void altera(Produto produto) {
        Produto p = buscaProdutoPelaId(produto.getId());
        if (p != null) {
            p.setNome(produto.getNome());
            p.setDescricao(produto.getDescricao());
            p.setUnidadeCompra(produto.getUnidadeCompra());
            p.setQtdPrevistoMes(produto.getQtdPrevistoMes());
            p.setPrecoMaxComprado(produto.getPrecoMaxComprado());
        }
    }

    // DELETE (Remover)
    public static void remove(int id) {
        Iterator<Produto> it = listaProdutos.iterator();
        while(it.hasNext()) {
            Produto p = it.next();
            if(p.getId() == id) {
                it.remove();
                break;
            }
        }
    }
}
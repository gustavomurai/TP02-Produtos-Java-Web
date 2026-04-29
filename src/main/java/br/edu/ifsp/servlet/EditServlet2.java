/*
 * Disciplina: CBTSWE1 - ADS 571
 * Professor: Wellington Tuler Moraes
 * Trabalho Prático 02 - CRUD Banco em Memória
 * Dupla: Gustavo Murai e Igor Murai
 * Data: 28/04/2026
 */
package br.edu.ifsp.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifsp.dao.Banco;
import br.edu.ifsp.model.Produto;

@WebServlet("/EditServlet2")
public class EditServlet2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        
        // Pega todos os dados do formulário
        int id = Integer.parseInt(request.getParameter("id"));
        String nome = request.getParameter("nome");
        String descricao = request.getParameter("descricao");
        int unidadeCompra = Integer.parseInt(request.getParameter("unidadeCompra"));
        double qtdPrevistoMes = Double.parseDouble(request.getParameter("qtdPrevistoMes"));
        double precoMaxComprado = Double.parseDouble(request.getParameter("precoMaxComprado"));
        
        // Monta o objeto com os dados novos
        Produto p = new Produto();
        p.setId(id);
        p.setNome(nome);
        p.setDescricao(descricao);
        p.setUnidadeCompra(unidadeCompra);
        p.setQtdPrevistoMes(qtdPrevistoMes);
        p.setPrecoMaxComprado(precoMaxComprado);
        
        // Chama a função altera do nosso Banco em memória
        Banco.altera(p);
        
        // Volta para a tela de listagem
        response.sendRedirect("ViewServlet");
    }
}
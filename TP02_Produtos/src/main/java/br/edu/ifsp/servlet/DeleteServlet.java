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

@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sid = request.getParameter("id");
        int id = Integer.parseInt(sid);
        
        // Remove do banco em memória e redireciona direto para a lista
        Banco.remove(id);
        response.sendRedirect("ViewServlet");
    }
}
/*
 * Disciplina: CBTSWE1 - ADS 571
 * Professor: Wellington Tuler Moraes
 * Trabalho Prático 02 - CRUD Banco em Memória
 * Dupla: Gustavo Murai e Igor Murai
 * Data: 28/04/2026
 */
package br.edu.ifsp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifsp.dao.Banco;
import br.edu.ifsp.model.Produto;

@WebServlet("/SaveServlet")
public class SaveServlet extends HttpServlet {
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        
        // Pegando os dados
        String nome = request.getParameter("nome");
        String descricao = request.getParameter("descricao");
        int unidadeCompra = Integer.parseInt(request.getParameter("unidadeCompra"));
        double qtdPrevistoMes = Double.parseDouble(request.getParameter("qtdPrevistoMes"));
        double precoMaxComprado = Double.parseDouble(request.getParameter("precoMaxComprado"));
        
        // Montando o objeto
        Produto produto = new Produto();
        produto.setNome(nome);
        produto.setDescricao(descricao);
        produto.setUnidadeCompra(unidadeCompra);
        produto.setQtdPrevistoMes(qtdPrevistoMes);
        produto.setPrecoMaxComprado(precoMaxComprado);
        
        // Salvando no banco em memória (Aqui estava o erro de digitação no seu código)
        Banco.adiciona(produto);
        
        // Design System - Tela de Sucesso
        out.print("<!DOCTYPE html><html lang='pt-br'><head><meta charset='UTF-8'><title>Sucesso - TP02</title>");
        out.print("<link rel='preconnect' href='https://fonts.googleapis.com'><link rel='preconnect' href='https://fonts.gstatic.com' crossorigin>");
        out.print("<link href='https://fonts.googleapis.com/css2?family=Inter:wght@400;500;600&display=swap' rel='stylesheet'>");
        out.print("<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css' rel='stylesheet'>");
        out.print("<link rel='stylesheet' href='https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css'>");
        
        out.print("<style>");
        out.print(":root { --bg-base: #0F0F11; --bg-surface: #18181B; --border-color: #3F3F46; --brand-primary: #6366F1; --brand-hover: #4F46E5; --text-primary: #F4F4F5; --text-secondary: #A1A1AA; --radius-md: 12px; --radius-sm: 8px; --transition-fast: 0.2s ease; }");
        out.print("body { background-color: var(--bg-base); color: var(--text-primary); font-family: 'Inter', sans-serif; display: flex; align-items: center; justify-content: center; min-height: 100vh; margin: 0; }");
        out.print(".surface-card { background-color: var(--bg-surface); border: 1px solid var(--border-color); border-radius: var(--radius-md); padding: 40px; width: 100%; max-width: 440px; box-shadow: 0 20px 40px rgba(0,0,0,0.4); text-align: center; }");
        out.print(".icon-success { font-size: 3rem; color: #10B981; margin-bottom: 16px; }");
        out.print(".btn-ui { display: flex; align-items: center; justify-content: center; gap: 10px; height: 48px; border-radius: var(--radius-sm); font-size: 0.95rem; font-weight: 500; transition: var(--transition-fast); width: 100%; text-decoration: none; border: none; margin-top: 12px; }");
        out.print(".btn-primary-ui { background-color: var(--brand-primary); color: #ffffff; }");
        out.print(".btn-primary-ui:hover { background-color: var(--brand-hover); transform: translateY(-1px); color: white; }");
        out.print(".btn-ghost-ui { background-color: transparent; color: var(--text-secondary); border: 1px solid var(--border-color); }");
        out.print(".btn-ghost-ui:hover { color: var(--text-primary); background-color: #27272A; }");
        out.print("</style></head><body>");
        
        out.print("<div class='surface-card'>");
        out.print("<i class='bi bi-check-circle-fill icon-success'></i>");
        out.print("<h3 class='mb-2 fw-semibold'>Produto Salvo!</h3>");
        out.print("<p style='color: var(--text-secondary); margin-bottom: 32px;'>O item <b>" + nome + "</b> foi cadastrado com sucesso na memória.</p>");
        
        out.print("<a href='ViewServlet' class='btn-ui btn-primary-ui'><i class='bi bi-card-list'></i> Ver Lista de Produtos</a>");
        out.print("<a href='index.html' class='btn-ui btn-ghost-ui'><i class='bi bi-house'></i> Voltar ao Menu</a>");
        out.print("</div></body></html>");
        
        out.close();
    }
}
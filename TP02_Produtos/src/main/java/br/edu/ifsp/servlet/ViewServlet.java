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
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifsp.dao.Banco;
import br.edu.ifsp.model.Produto;

@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        out.println("<!DOCTYPE html><html lang='pt-br'><head><meta charset='UTF-8'><title>Gestão de Produtos - TP02</title>");
        out.println("<link rel='preconnect' href='https://fonts.googleapis.com'><link rel='preconnect' href='https://fonts.gstatic.com' crossorigin>");
        out.println("<link href='https://fonts.googleapis.com/css2?family=Inter:wght@400;500;600&display=swap' rel='stylesheet'>");
        out.println("<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css' rel='stylesheet'>");
        out.println("<link rel='stylesheet' href='https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css'>");
        
        // O mesmo Design System
        out.println("<style>");
        out.println(":root { --bg-base: #0F0F11; --bg-surface: #18181B; --bg-surface-hover: #27272A; --border-color: #3F3F46; --brand-primary: #6366F1; --brand-hover: #4F46E5; --text-primary: #F4F4F5; --text-secondary: #A1A1AA; --radius-md: 12px; --radius-sm: 8px; --transition-fast: 0.2s ease; }");
        out.println("body { background-color: var(--bg-base); color: var(--text-primary); font-family: 'Inter', sans-serif; padding: 40px 0; -webkit-font-smoothing: antialiased; }");
        out.println(".surface-card { background-color: var(--bg-surface); border: 1px solid var(--border-color); border-radius: var(--radius-md); padding: 40px; box-shadow: 0 20px 40px rgba(0,0,0,0.4); }");
        
        // Estilização UI da Tabela
        out.println(".table { color: var(--text-primary); margin-top: 10px; margin-bottom: 0; }");
        out.println(".table th { border-bottom: 1px solid var(--border-color); color: var(--text-secondary); font-weight: 500; font-size: 0.8rem; text-transform: uppercase; letter-spacing: 0.5px; padding-bottom: 16px; border-top: none; }");
        out.println(".table td { border-bottom: 1px solid var(--border-color); vertical-align: middle; padding: 16px 8px; font-size: 0.95rem; background: transparent; color: var(--text-primary); }");
        out.println("tbody tr { transition: var(--transition-fast); }");
        out.println("tbody tr:hover { background-color: rgba(255, 255, 255, 0.02); }");
        out.println("tbody tr:last-child td { border-bottom: none; }");
        
        // Botões
        out.println(".btn-ui { display: inline-flex; align-items: center; gap: 8px; padding: 10px 20px; border-radius: var(--radius-sm); font-size: 0.9rem; font-weight: 500; transition: var(--transition-fast); text-decoration: none; border: none; }");
        out.println(".btn-primary-ui { background-color: var(--brand-primary); color: white; }");
        out.println(".btn-primary-ui:hover { background-color: var(--brand-hover); color: white; transform: translateY(-1px); }");
        out.println(".btn-ghost-ui { background-color: transparent; color: var(--text-secondary); border: 1px solid var(--border-color); }");
        out.println(".btn-ghost-ui:hover { color: var(--text-primary); background-color: var(--bg-surface-hover); }");
        
        // Ações da Tabela
        out.println(".action-btn { display: inline-flex; align-items: center; justify-content: center; width: 32px; height: 32px; border-radius: 6px; transition: var(--transition-fast); color: var(--text-secondary); text-decoration: none; border: 1px solid transparent; }");
        out.println(".btn-edit:hover { color: var(--brand-primary); background-color: rgba(99, 102, 241, 0.1); border-color: rgba(99, 102, 241, 0.2); }");
        out.println(".btn-delete:hover { color: #ef4444; background-color: rgba(239, 68, 68, 0.1); border-color: rgba(239, 68, 68, 0.2); }");
        out.println("</style></head><body>");
        
        out.println("<div class='container'>");
        out.println("<div class='surface-card'>");
        
        out.println("<div class='d-flex justify-content-between align-items-center mb-4'>");
        out.println("<h2 class='m-0 fs-4 fw-semibold d-flex align-items-center gap-2'><i class='bi bi-box-seam' style='color: var(--brand-primary);'></i> Gestão de Produtos</h2>");
        out.println("<div class='d-flex gap-2'>");
        out.println("<a href='index.html' class='btn-ui btn-ghost-ui'><i class='bi bi-house'></i> Menu</a>");
        out.println("<a href='cadastrar.html' class='btn-ui btn-primary-ui'><i class='bi bi-plus-lg'></i> Novo Produto</a>");
        out.println("</div></div>");
        
        List<Produto> lista = Banco.getProdutos();
        
        if (lista.isEmpty()) {
            out.println("<div class='text-center py-5' style='color: var(--text-secondary);'>");
            out.println("<i class='bi bi-inbox fs-1 mb-3 d-block' style='opacity: 0.5;'></i>");
            out.println("<p>Nenhum produto cadastrado na memória.</p></div>");
        } else {
            out.println("<div class='table-responsive'>");
            out.println("<table class='table align-middle'>");
            out.println("<thead><tr>");
            out.println("<th>ID</th><th>Nome</th><th>Descrição</th><th>Unid. Compra</th><th>Qtd. Mês</th><th>Preço Máx</th><th class='text-end'>Ações</th>");
            out.println("</tr></thead><tbody>");
            
            for(Produto p : lista) {
                out.print("<tr>");
                out.print("<td style='color: var(--text-secondary); font-family: monospace;'>" + String.format("%03d", p.getId()) + "</td>");
                out.print("<td class='fw-medium'>" + p.getNome() + "</td>");
                out.print("<td style='color: var(--text-secondary); max-width: 250px; white-space: nowrap; overflow: hidden; text-overflow: ellipsis;'>" + p.getDescricao() + "</td>");
                out.print("<td>" + p.getUnidadeCompra() + "</td>");
                out.print("<td>" + p.getQtdPrevistoMes() + "</td>");
                out.print("<td>R$ " + String.format("%.2f", p.getPrecoMaxComprado()) + "</td>");
                
                out.print("<td class='text-end'>");
                out.print("<a href='EditServlet?id=" + p.getId() + "' class='action-btn btn-edit me-1' title='Editar'><i class='bi bi-pencil'></i></a>");
                out.print("<a href='DeleteServlet?id=" + p.getId() + "' class='action-btn btn-delete' title='Deletar' onclick='return confirm(\"Excluir definitivamente o produto " + p.getNome() + "?\")'><i class='bi bi-trash3'></i></a>");
                out.print("</td></tr>");
            }
            out.println("</tbody></table></div>");
        }
        
        out.println("</div></div></body></html>");
        out.close();
    }
}
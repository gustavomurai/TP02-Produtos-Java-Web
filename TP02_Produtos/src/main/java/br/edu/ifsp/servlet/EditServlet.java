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

@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String sid = request.getParameter("id");
        int id = Integer.parseInt(sid);
        
        Produto p = Banco.buscaProdutoPelaId(id);
        
        out.print("<!DOCTYPE html><html lang='pt-br'><head><meta charset='UTF-8'><title>Editar Produto - TP02</title>");
        out.print("<link rel='preconnect' href='https://fonts.googleapis.com'><link rel='preconnect' href='https://fonts.gstatic.com' crossorigin>");
        out.print("<link href='https://fonts.googleapis.com/css2?family=Inter:wght@400;500;600&display=swap' rel='stylesheet'>");
        out.print("<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css' rel='stylesheet'>");
        out.print("<link rel='stylesheet' href='https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css'>");
        
        out.print("<style>");
        out.print(":root { --bg-base: #0F0F11; --bg-surface: #18181B; --bg-input: #121214; --border-color: #3F3F46; --brand-primary: #6366F1; --brand-hover: #4F46E5; --text-primary: #F4F4F5; --text-secondary: #A1A1AA; --radius-md: 12px; --radius-sm: 8px; --transition-fast: 0.2s ease; }");
        out.print("body { background-color: var(--bg-base); color: var(--text-primary); font-family: 'Inter', sans-serif; padding: 40px 0; display: flex; align-items: center; justify-content: center; min-height: 100vh; }");
        out.print(".surface-card { background-color: var(--bg-surface); border: 1px solid var(--border-color); border-radius: var(--radius-md); padding: 40px; width: 100%; max-width: 600px; box-shadow: 0 20px 40px rgba(0,0,0,0.4); }");
        out.print(".header-title { display: flex; align-items: center; gap: 12px; margin-bottom: 32px; font-size: 1.25rem; font-weight: 600; }");
        
        out.print(".form-label-ui { font-size: 0.85rem; font-weight: 500; color: var(--text-secondary); margin-bottom: 6px; display: block; }");
        out.print(".form-control-ui { background-color: var(--bg-input); border: 1px solid var(--border-color); color: var(--text-primary); border-radius: var(--radius-sm); padding: 12px 16px; font-size: 0.95rem; transition: var(--transition-fast); width: 100%; }");
        out.print(".form-control-ui:focus { outline: none; border-color: var(--brand-primary); box-shadow: 0 0 0 1px var(--brand-primary); background-color: #1A1A1E; }");
        out.print("input[type=number]::-webkit-inner-spin-button, input[type=number]::-webkit-outer-spin-button { -webkit-appearance: none; margin: 0; }");
        
        out.print(".btn-ui { display: flex; align-items: center; justify-content: center; gap: 10px; height: 48px; border-radius: var(--radius-sm); font-size: 0.95rem; font-weight: 500; transition: var(--transition-fast); width: 100%; border: none; text-decoration: none; cursor: pointer; }");
        out.print(".btn-primary-ui { background-color: var(--brand-primary); color: #ffffff; margin-bottom: 12px; }");
        out.print(".btn-primary-ui:hover { background-color: var(--brand-hover); transform: translateY(-1px); }");
        out.print(".btn-ghost-ui { background-color: transparent; color: var(--text-secondary); border: 1px solid transparent; }");
        out.print(".btn-ghost-ui:hover { color: var(--text-primary); background-color: rgba(255,255,255,0.05); }");
        out.print(".row-gap { margin-bottom: 20px; }");
        out.print("</style></head><body>");
        
        out.print("<div class='container d-flex justify-content-center'><div class='surface-card'>");
        out.print("<div class='header-title'><i class='bi bi-pencil-square' style='color: var(--brand-primary);'></i> Editar Produto</div>");
        
        out.print("<form action='EditServlet2' method='post'>");
        out.print("<input type='hidden' name='id' value='" + p.getId() + "'/>");
        
        out.print("<div class='row-gap'><label class='form-label-ui'>NOME DO PRODUTO</label>");
        out.print("<input type='text' name='nome' class='form-control-ui' value='" + p.getNome() + "' required/></div>");
        
        out.print("<div class='row-gap'><label class='form-label-ui'>DESCRIÇÃO</label>");
        out.print("<textarea name='descricao' class='form-control-ui' rows='3' required>" + p.getDescricao() + "</textarea></div>");
        
        out.print("<div class='row row-gap'><div class='col-md-4 mb-3 mb-md-0'><label class='form-label-ui'>UNID. COMPRA</label>");
        out.print("<input type='number' name='unidadeCompra' class='form-control-ui' value='" + p.getUnidadeCompra() + "' required/></div>");
        
        out.print("<div class='col-md-4 mb-3 mb-md-0'><label class='form-label-ui'>QTD. MÊS</label>");
        out.print("<input type='number' step='0.01' name='qtdPrevistoMes' class='form-control-ui' value='" + p.getQtdPrevistoMes() + "' required/></div>");
        
        out.print("<div class='col-md-4'><label class='form-label-ui'>PREÇO MÁX. (R$)</label>");
        out.print("<input type='number' step='0.01' name='precoMaxComprado' class='form-control-ui' value='" + p.getPrecoMaxComprado() + "' required/></div></div>");
        
        out.print("<div class='mt-4 pt-4 border-top' style='border-color: var(--border-color) !important;'>");
        out.print("<button type='submit' class='btn-ui btn-primary-ui'><i class='bi bi-check2'></i> Atualizar Produto</button>");
        out.print("<a href='ViewServlet' class='btn-ui btn-ghost-ui'>Cancelar</a>");
        out.print("</div></form></div></div></body></html>");
        
        out.close();
    }
}
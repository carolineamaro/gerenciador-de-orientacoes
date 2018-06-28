package br.com.orientacoes.controller;

import br.com.orientacoes.dao.OrientacaoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Caroline
 */
@WebServlet(urlPatterns = {"/orientacao"})
public class OrientacaoListarController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        OrientacaoDAO dao = new OrientacaoDAO();
        request.setAttribute("orientacoes", dao.listar());

        if (request.getParameter("deletar") != null) {
            int id = Integer.parseInt(request.getParameter("deletar"));
            dao.deletar(id);
            response.sendRedirect("orientacao?excluido=true");
            return;
        }

        request.getRequestDispatcher("todos-orientacao.jsp").forward(request, response);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.orientacoes.controller;

import br.com.orientacoes.dao.ProfessorDAO;
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
@WebServlet(urlPatterns = {"/professor"})
public class ProfessorListarController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProfessorDAO dao = new ProfessorDAO();
        request.setAttribute("professores", dao.listar());

        if (request.getParameter("deletar") != null) {
            int id = Integer.parseInt(request.getParameter("deletar"));
            if (dao.deletar(id)) {
                response.sendRedirect("professor?excluido=sim");
            } else {
                response.sendRedirect("professor?excluido=nao");
            }

            return;
        }

        request.getRequestDispatcher("todos-professores.jsp").forward(request, response);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.orientacoes.controller;

import br.com.orientacoes.dao.ProfessorDAO;
import br.com.orientacoes.modelo.Professor;
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
@WebServlet(urlPatterns = {"/professor-novo"})
public class ProfessorAdicionarController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("adicionar-professor.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nome = request.getParameter("nome");
        if (!nome.isEmpty()) {
            Professor professor = new Professor(nome);
            ProfessorDAO dao = new ProfessorDAO();
            dao.inserir(professor);

            response.sendRedirect("professor?inserido=true");
        } else {
            doGet(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

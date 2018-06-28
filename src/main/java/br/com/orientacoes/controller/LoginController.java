package br.com.orientacoes.controller;

import br.com.orientacoes.dao.UsuarioDAO;
import br.com.orientacoes.modelo.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Caroline
 */
@WebServlet(name = "LoginController", urlPatterns = {"/login"})
public class LoginController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        if(request.getSession().getAttribute("usuario") != null){
            response.sendRedirect("professor");
        }else{
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }    
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        
        if(email != null && senha != null){
            UsuarioDAO dao = new UsuarioDAO();
            Usuario usuario = dao.realizarLogin(email, senha);
            
            if(usuario != null){
                HttpSession session = request.getSession();
                session.setAttribute("usuario", usuario);
            }else{
                request.setAttribute("erro", "Seu e-mail ou senha são incorretos, tente novamente!");
            }
        }else{
            request.setAttribute("erro", "Seu e-mail ou senha não foram enviados corretamente!");
        }
        
        doGet(request, response);
    }
}

package br.com.orientacoes.controller.rest;

import br.com.orientacoes.dao.ProfessorDAO;
import br.com.orientacoes.modelo.Professor;
import br.com.orientacoes.util.Erro;
import br.com.orientacoes.util.Sucesso;
import com.google.gson.Gson;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/rest-professor"})
public class ProfessorREST extends HttpServlet {

    private Gson gson;

    public ProfessorREST() {
        this.gson = new Gson();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        ProfessorDAO dao = new ProfessorDAO();
        String json = gson.toJson(dao.listar());
        response.getWriter().write(json);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        String nome = request.getParameter("nome");

        if (nome != null) {
            Professor professor = new Professor(nome);
            ProfessorDAO dao = new ProfessorDAO();
            dao.inserir(professor);
            response.getWriter().write(gson.toJson(new Sucesso("Professor inserido com sucesso!")));
        } else {
            response.getWriter().write(gson.toJson(new Erro("O atributo 'nome' é obrigatório")));
        }
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        
        ProfessorDAO dao = new ProfessorDAO();
        if (request.getParameter("id_professor") != null) {
            int id = Integer.parseInt(request.getParameter("id_professor"));
            if (dao.deletar(id)) {
                response.getWriter().write(gson.toJson(new Sucesso("Professor excluido com sucesso!")));
            } else {
                response.getWriter().write(gson.toJson(new Erro("Não foi possível excluir este professor, pois ele tem orientações!")));
            }
        }
    }
}

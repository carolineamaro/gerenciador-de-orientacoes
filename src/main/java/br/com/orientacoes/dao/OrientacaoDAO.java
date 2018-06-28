/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.orientacoes.dao;

import br.com.orientacoes.modelo.Orientacao;
import br.com.orientacoes.modelo.Professor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Caroline
 */
public class OrientacaoDAO extends AbstractDAO<Orientacao> {

    @Override
    public boolean inserir(Orientacao orientacao) {
        try {
            abreConexao();
            PreparedStatement query = connection.prepareStatement("INSERT INTO orientacao VALUES (NULL, ?, ?, ?)");
            query.setString(1, orientacao.getTema());
            query.setString(2, orientacao.getAluno());
            query.setInt(3, orientacao.getProfessor().getId());
            query.execute();

            fechaConexao();

            return true;
        } catch (SQLException ex) {
            Logger.getLogger(OrientacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public List<Orientacao> listar() {
        List<Orientacao> orientacao = new ArrayList<Orientacao>();

        try {
            abreConexao();
            PreparedStatement query = connection.prepareStatement("SELECT * FROM orientacao ORDER BY id_orientacao DESC");
            ResultSet resultado = query.executeQuery();
            while (resultado.next()) {
                orientacao.add(new Orientacao(
                        resultado.getInt("id_orientacao"),
                        resultado.getString("tema"),
                        new ProfessorDAO().procurar(Integer.parseInt(resultado.getString("id_professor"))),
                        resultado.getString("aluno")
                ));
            }
            fechaConexao();
        } catch (SQLException ex) {
            Logger.getLogger(OrientacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return orientacao;
    }

    public boolean deletar(int id) {
        try {
            abreConexao();
            PreparedStatement query = connection.prepareStatement("DELETE FROM orientacao where id_orientacao = ?");
            query.setInt(1, id);
            query.execute();
            fechaConexao();

            return true;
        } catch (SQLException ex) {
            Logger.getLogger(OrientacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public Orientacao procurar(int id) {
        for (Orientacao orientacao : this.listar()) {
            if (orientacao.getId() == id) {
                return orientacao;
            }
        }
        return null;
    }
}

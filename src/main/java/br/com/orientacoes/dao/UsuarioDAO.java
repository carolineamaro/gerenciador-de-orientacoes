/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.orientacoes.dao;

import br.com.orientacoes.modelo.Professor;
import br.com.orientacoes.modelo.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Caroline
 */
public class UsuarioDAO extends AbstractDAO<Usuario> {

    @Override
    public boolean inserir(Usuario objeto) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Usuario> listar() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean deletar(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Usuario procurar(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Usuario realizarLogin(String email, String senha) {
        try {
            abreConexao();
            PreparedStatement query = connection.prepareStatement("SELECT * FROM usuario WHERE email = ? AND senha = ? LIMIT 1");
            query.setString(1, email);
            query.setString(2, senha);

            ResultSet resultado = query.executeQuery();
            while (resultado.next()) {
                return new Usuario(resultado.getInt("id_usuario"), resultado.getString("email"), resultado.getString("senha"));
            }
            fechaConexao();
        } catch (SQLException ex) {
            Logger.getLogger(ProfessorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}

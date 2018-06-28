/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.orientacoes.dao;

import br.com.orientacoes.modelo.Professor;
import br.com.orientacoes.util.Conexao;
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
public class ProfessorDAO extends AbstractDAO<Professor>{

    public boolean inserir(Professor professor) {
        try {
            abreConexao();
            PreparedStatement query = connection.prepareStatement("INSERT INTO professor VALUES (NULL, ?)");
            query.setString(1, professor.getNome());
            query.execute();
            
            fechaConexao();
            
            return true; 
        } catch (SQLException ex) {
            Logger.getLogger(ProfessorDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public List<Professor> listar(){
        List<Professor> professores = new ArrayList<Professor>();
        
        try {
            abreConexao();
            PreparedStatement query = connection.prepareStatement("SELECT * FROM professor ORDER BY id_professor DESC");
            ResultSet resultado = query.executeQuery();
            while(resultado.next()){
                professores.add(new Professor(resultado.getInt("id_professor"), resultado.getString("nome")));
            }
            fechaConexao();
        } catch (SQLException ex) {
            Logger.getLogger(ProfessorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return professores;
    }
    
    public boolean deletar(int id){
        try {
            abreConexao();
            PreparedStatement query = connection.prepareStatement("DELETE FROM professor where id_professor = ?");
            query.setInt(1, id);
            query.execute();
            fechaConexao();

            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ProfessorDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public Professor procurar(int id) {
        for(Professor professor : this.listar()){
            if(professor.getId() == id){
                return professor;
            }
        }
        return null;
    }
}

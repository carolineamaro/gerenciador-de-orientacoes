/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.orientacoes.dao;

import br.com.orientacoes.util.Conexao;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Caroline
 */
public abstract class AbstractDAO<T> /* T = Tipo genérico */ {

    protected Conexao conexao;
    protected Connection connection;

    public AbstractDAO() {
        this.conexao = new Conexao();
    }

    protected void abreConexao() {
        this.connection = conexao.conecta();
    }

    protected void fechaConexao() {
        try {
            this.connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProfessorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //obriga o tipo a ser igual na classe que extende e no metodo
    public abstract boolean inserir(T objeto);
    public abstract List<T> listar();
    public abstract boolean deletar(int id);
    
    public abstract T procurar(int id);
}

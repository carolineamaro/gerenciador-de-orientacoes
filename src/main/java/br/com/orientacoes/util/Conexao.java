package br.com.orientacoes.util;

import com.mchange.v2.c3p0.DataSources;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.sql.DataSource;

public class Conexao {
    public Connection conecta(){
        try {
            DataSource ds = DataSources.unpooledDataSource("jdbc:mysql://localhost/orientacao?characterEncoding=UTF-8","root","");
            System.out.println("Conexao realizada com sucesso");
            return ds.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
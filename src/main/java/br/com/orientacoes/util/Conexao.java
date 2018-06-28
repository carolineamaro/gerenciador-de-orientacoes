package br.com.orientacoes.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
    public Connection conecta(){
        try {
            String driverName = "com.mysql.jdbc.Driver";
            Class.forName(driverName);
            System.out.println("Conexao realizada com sucesso");
            return DriverManager.getConnection("jdbc:mysql://localhost/orientacao?characterEncoding=UTF-8", "root", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
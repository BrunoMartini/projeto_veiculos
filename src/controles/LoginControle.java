/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controles;

import banco.Conexao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelos.Usuarios;

/**
 *
 * @author Bruno Martini
 */
public class LoginControle {
    
     public Usuarios Login(String usuario, String senha){
        //INÍCIO CONEXÃO COM O BANCO DE DADOS
        System.out.println("Vai abrir a conexão com o banco de dados");
        Conexao.abreConexao();
        
        Usuarios user = null;
        ResultSet rs = null;

        StringBuilder comandoSQL = new StringBuilder();
        comandoSQL.append(" SELECT login, nome");
        comandoSQL.append(" FROM usuarios");
        comandoSQL.append(" WHERE login = '"+ usuario +"'");
        comandoSQL.append(" AND senha =  '"+ senha +"'");

        try {
            System.out.println("Vai Executar Conexão em buscar area");
            rs = Conexao.stmt.executeQuery(comandoSQL.toString());
            System.out.println("Executou Conexão em buscar area");
            
            if (rs.next() == true) {
                user = new Usuarios();
                user.setLogin(rs.getString("login"));
                user.setNome(rs.getString("nome"));
                
            }
        } catch (SQLException ex) {
            System.out.println("ERRO de SQL: " + ex.getMessage().toString());
            return user;
        }finally{
            Connection con = Conexao.obterConexao();
            System.out.println("Vai fechar a conexão com o banco de dados");
            Conexao.fecharConexao(con);
        }
        
        return user;
        
    }
    
}

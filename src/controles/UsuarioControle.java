/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controles;

import banco.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelos.CadastroUsuario;

/**
 *
 * @author bruno.martini
 */
public class UsuarioControle {
    
    CadastroUsuario objUsuario;
    
    public UsuarioControle(CadastroUsuario objUsuario) {
        this.objUsuario = objUsuario;
        
    }
    
    public boolean incluir(){
        
        Conexao.abreConexao();
        Connection con = Conexao.obterConexao();
        PreparedStatement stmt = null;
        
        try{
            stmt = con.prepareStatement("INSERT INTO usuarios(login,nome,senha) VALUES(?,?,?)");
            stmt.setString(1, objUsuario.getLogin());
            stmt.setString(2, objUsuario.getNome());
            stmt.setString(3, objUsuario.getSenha());
            
            stmt.executeUpdate();
            
            return true;
            
        }catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }finally{
            Conexao.fecharConexao(con, stmt);
        }
    }
    
    public boolean alterar(){
        
        Conexao.abreConexao();
        Connection con = Conexao.obterConexao();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("UPDATE usuarios SET login=?, nome=?, senha=? WHERE id_usuario=?");
            stmt.setString(1, objUsuario.getLogin());
            stmt.setString(2, objUsuario.getNome());
            stmt.setString(3, objUsuario.getSenha());
            stmt.setInt(4, objUsuario.getId_usuario());
            
            stmt.executeUpdate();
            
            return true;
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }finally{
            Conexao.fecharConexao(con, stmt);
        }
        
    }
    
     public CadastroUsuario buscar(String id)
    {
        try {
            Conexao.abreConexao();
            ResultSet rs = null;

            String SQL = "";
            SQL = " SELECT id_usuario, login, nome, senha ";
            SQL += " FROM usuarios ";
            SQL += " WHERE id_usuario = '" + id + "'";
            

            try{
                System.out.println("Vai Executar Conexão em buscar");
                rs = Conexao.stmt.executeQuery(SQL);
                System.out.println("Executou Conexão em buscar");

                objUsuario = new CadastroUsuario();
                if(rs.next() == true)
                {
                    objUsuario.setId_usuario(rs.getInt(1));
                    objUsuario.setLogin(rs.getString(2));
                    objUsuario.setNome(rs.getString(3));
                    objUsuario.setSenha(rs.getString(4));
                }
            }

            catch (SQLException ex )
            {
                System.out.println("ERRO de SQL: " + ex.getMessage().toString());
                return null;
            }

        } catch (Exception e) {
            System.out.println("ERRO: " + e.getMessage().toString());
            return null;
        }
        
        System.out.println ("Executou buscar area com sucesso");
        return objUsuario;
    }
    
}

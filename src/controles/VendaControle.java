/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controles;

import banco.Conexao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelos.Venda;

/**
 *
 * @author Martini
 */
public class VendaControle {
    
     Venda objVenda;
    
    
    public VendaControle(Venda objVenda) {
        this.objVenda = objVenda;
        
    }
    
      public boolean incluir(){
        
        
        Conexao.abreConexao();
        Connection con = Conexao.obterConexao();
        PreparedStatement stmt = null;
        
        try{
            stmt = con.prepareStatement("INSERT INTO venda(dtvenda, forma_pagamento, valor, id_veiculo, id_cliente) VALUES(?,?,?,?,?)");
            Date data_venda = Date.valueOf(objVenda.getDtvenda());  
            stmt.setDate(1, data_venda);
            stmt.setString(2, objVenda.getForma_pagamento());
            stmt.setString(3, objVenda.getValor());
            stmt.setInt(4, objVenda.getId_veiculo());
            stmt.setInt(5, objVenda.getId_cliente());
            
            
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
            stmt = con.prepareStatement("UPDATE venda SET dtvenda=?, forma_pagamento=?, valor=?, id_veiculo=?, id_cliente=? WHERE id_venda=?");
            Date data_venda = Date.valueOf(objVenda.getDtvenda());  
            stmt.setDate(1, data_venda);
            stmt.setString(2, objVenda.getForma_pagamento());
            stmt.setString(3, objVenda.getValor());
            stmt.setInt(4, objVenda.getId_veiculo());
            stmt.setInt(5, objVenda.getId_cliente());
            stmt.setInt(6, objVenda.getId_venda());
            
            stmt.executeUpdate();
            
            return true;
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }finally{
            Conexao.fecharConexao(con, stmt);
        }
        
    }
       
       public Venda buscar(String id)
    {
        try {
            Conexao.abreConexao();
            ResultSet rs = null;

            String SQL = "";
            SQL = " SELECT id_venda, dtvenda, forma_pagamento, valor, id_veiculo, id_cliente ";
            SQL += " FROM venda ";
            SQL += " WHERE id_venda = '" + id + "'";
            

            try{
                System.out.println("Vai Executar Conexão em buscar");
                rs = Conexao.stmt.executeQuery(SQL);
                System.out.println("Executou Conexão em buscar");

                objVenda = new Venda();
                if(rs.next() == true)
                {
                    objVenda.setId_venda(rs.getInt(1));
                    objVenda.setDtvenda(rs.getString(2));
                    objVenda.setForma_pagamento(rs.getString(3));
                    objVenda.setValor(rs.getString(4));
                    objVenda.setId_veiculo(rs.getInt(5));
                    objVenda.setId_cliente(rs.getInt(6));
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
        return objVenda;
    }
        
        public ResultSet buscarRelatorio()
    {
        ResultSet rs = null;
        try {
            Conexao.abreConexao();
            
            String SQL = "";
            SQL = " SELECT * from venda ";

            try{
                System.out.println("Vai Executar Conexão em buscar visitante");
                rs = Conexao.stmt.executeQuery(SQL);
            }

            catch (SQLException ex )
            {
                System.out.println("ERRO de SQL: " + ex.getMessage().toString());
                return rs;
            }

        } catch (Exception e) {
            System.out.println("ERRO: " + e.getMessage().toString());
            return rs;
        }
        
        System.out.println ("Executou buscar visitante com sucesso");
        return rs;
    }
    
}

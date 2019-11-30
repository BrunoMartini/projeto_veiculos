/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controles;

import banco.Conexao;
import java.awt.Color;
import java.awt.Component;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import modelos.Cliente;

/**
 *
 * @author Bruno Martini
 */
public class ClienteControle {
    
    Cliente objCliente;
    JTable jtbCliente = null;
    
    public ClienteControle(Cliente objCliente, JTable jtbCliente) {
        this.objCliente = objCliente;
        this.jtbCliente = jtbCliente;
    }
    
      public boolean incluir(){
          
          if(verificaExistenciaCPF() == true){
            return false;
        }
        
        Conexao.abreConexao();
        Connection con = Conexao.obterConexao();
        PreparedStatement stmt = null;
        
        try{
            stmt = con.prepareStatement("INSERT INTO cliente(nome, cpf, dtnasc, telefone, email, rua, numero, id_bairro, id_estado, id_cidade) VALUES(?,?,?,?,?,?,?,?,?,?)");
            stmt.setString(1, objCliente.getNome());
            stmt.setString(2, objCliente.getCpf());
            Date data_nasc = Date.valueOf(objCliente.getDtnasc());  
            stmt.setDate(3, data_nasc);
            stmt.setString(4, objCliente.getTelefone());
            stmt.setString(5, objCliente.getEmail());
            stmt.setString(6, objCliente.getRua());
            stmt.setString(7, objCliente.getNumero());
            stmt.setInt(8, objCliente.getId_bairro());
            stmt.setInt(9, objCliente.getId_estado());
            stmt.setInt(10, objCliente.getId_cidade());
            
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
        
        if(verificaExistenciaCPF() == true){
            return false;
        }
        
        Conexao.abreConexao();
        Connection con = Conexao.obterConexao();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("UPDATE cliente SET nome=?, cpf=?, dtnasc=?, telefone=?, email=?, rua=?, numero=?, id_bairro=?, id_estado=?, id_cidade=?  WHERE id_cliente=?");
            stmt.setString(1, objCliente.getNome());
            stmt.setString(2, objCliente.getCpf());
            Date data_nasc = Date.valueOf(objCliente.getDtnasc());  
            stmt.setDate(3, data_nasc);
            stmt.setString(4, objCliente.getTelefone());
            stmt.setString(5, objCliente.getEmail());
            stmt.setString(6, objCliente.getRua());
            stmt.setString(7, objCliente.getNumero());
            stmt.setInt(8, objCliente.getId_bairro());
            stmt.setInt(9, objCliente.getId_estado());
            stmt.setInt(10, objCliente.getId_cidade());
            stmt.setInt(11, objCliente.getId_cliente());
            
            stmt.executeUpdate();
            
            return true;
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }finally{
            Conexao.fecharConexao(con, stmt);
        }
        
    }
    
    public void preencher() {

        Conexao.abreConexao();
        
        Vector<String> cabecalhos = new Vector<String>();
        Vector dadosTabela = new Vector(); //receber os dados do banco
        
        cabecalhos.add("Código");
        cabecalhos.add("Nome");
        cabecalhos.add("CPF");
        cabecalhos.add("Telefone");
        cabecalhos.add("Cidade");
        cabecalhos.add("Excluir");
        
        ResultSet result = null;
        
        try {

            String SQL = "";
            SQL = " SELECT id_cliente,nome,cpf,telefone,id_cidade ";
            SQL += " FROM cliente ";
            SQL += " WHERE data_exclusao is null ";
            SQL += " ORDER BY nome ";
            
            result = Conexao.stmt.executeQuery(SQL);

            Vector<Object> linha;
            while(result.next()) {
                linha = new Vector<Object>();
                
                linha.add(result.getInt(1));
                linha.add(result.getString(2));
                linha.add(result.getString(3));
                linha.add(result.getString(4));
                linha.add(result.getInt(5));
                linha.add("X");
                
                dadosTabela.add(linha);
            }
            
        } catch (Exception e) {
            System.out.println("problemas para popular tabela...");
            System.out.println(e);
        }

        jtbCliente.setModel(new DefaultTableModel(dadosTabela, cabecalhos) {

            @Override
            public boolean isCellEditable(int row, int column) {
              return false;
            }
            // permite seleção de apenas uma linha da tabela
        });

        // permite seleção de apenas uma linha da tabela
        jtbCliente.setSelectionMode(0);

        // redimensiona as colunas de uma tabela
        TableColumn column = null;
        for (int i = 0; i <= 5; i++) {
            column = jtbCliente.getColumnModel().getColumn(i);
            switch (i) {
                case 0:
                    column.setPreferredWidth(60);
                    break;
                case 1:
                    column.setPreferredWidth(230);
                    break;
                case 2:
                    column.setPreferredWidth(150);
                    break;
                case 3:
                    column.setPreferredWidth(150);
                    break;
                case 4:
                    column.setPreferredWidth(150);
                    break;
                case 5:
                    column.setPreferredWidth(10);
                    break;
            }
        }
        
        jtbCliente.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {

            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                    boolean isSelected, boolean hasFocus, int row, int column) {
                super.getTableCellRendererComponent(table, value, isSelected,
                        hasFocus, row, column);
                if (row % 5 == 0) {
                    setBackground(Color.LIGHT_GRAY);
                } else {
                    setBackground(Color.WHITE);
                }
                return this;
            }
        });
        //return (true);
    }
    
    public Cliente buscar(String id)
    {
        try {
            Conexao.abreConexao();
            ResultSet rs = null;

            String SQL = "";
            SQL = " SELECT id_cliente, nome, cpf, dtnasc, telefone, email, rua, numero, id_bairro, id_estado, id_cidade ";
            SQL += " FROM cliente ";
            SQL += " WHERE id_cliente = '" + id + "'";
            SQL += " AND data_exclusao is null ";

            try{
                System.out.println("Vai Executar Conexão em buscar");
                rs = Conexao.stmt.executeQuery(SQL);
                System.out.println("Executou Conexão em buscar");

                objCliente = new Cliente();
                if(rs.next() == true)
                {
                    objCliente.setId_cliente(rs.getInt(1));
                    objCliente.setNome(rs.getString(2));
                    objCliente.setCpf(rs.getString(3));
                    objCliente.setDtnasc(rs.getString(4));
                    objCliente.setTelefone(rs.getString(5));
                    objCliente.setEmail(rs.getString(6));
                    objCliente.setRua(rs.getString(7));
                    objCliente.setNumero(rs.getString(8));
                    objCliente.setId_bairro(rs.getInt(9));
                    objCliente.setId_estado(rs.getInt(10));
                    objCliente.setId_cidade(rs.getInt(11));
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
        return objCliente;
    }
    
    public boolean excluir(){
        
        Conexao.abreConexao();
        Connection con = Conexao.obterConexao();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("UPDATE cliente SET data_exclusao= now() WHERE id_cliente=?");
            stmt.setInt(1, objCliente.getId_cliente());
                        
            stmt.executeUpdate();
            
            return true;
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }finally{
            Conexao.fecharConexao(con, stmt);
        }
    }
    
    public Boolean verificaExistenciaCPF()
    {
        try {
            Conexao.abreConexao();
            ResultSet rs = null;

            String SQL = "";
            SQL = " SELECT id_cliente, nome ";
            SQL += " FROM cliente ";
            SQL += " WHERE cpf = '" + objCliente.getCpf()+ "'";
            SQL += " AND data_exclusao is null ";

            try{
                System.out.println("Vai Executar Conexão em buscar");
                rs = Conexao.stmt.executeQuery(SQL);
                System.out.println("Executou Conexão em buscar");

                if(rs.next() == true)
                {
                    if(rs.getInt(1) != objCliente.getId_cliente()){
                        return true; //Já existe uma pessoa com este CPF
                    }else{
                        return false;
                    }
                }else{
                    return false;
                }
            }

            catch (SQLException ex )
            {
                System.out.println("ERRO de SQL: " + ex.getMessage().toString());
                return false;
            }

        } catch (Exception e) {
            System.out.println("ERRO: " + e.getMessage().toString());
            return false;
        }
    }
    
    public ResultSet buscarRelatorio()
    {
        ResultSet rs = null;
        try {
            Conexao.abreConexao();
            
            String SQL = "";
            SQL = " SELECT * from cliente ";

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

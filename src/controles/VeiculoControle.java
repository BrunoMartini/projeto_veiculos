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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import modelos.Veiculo;

/**
 *
 * @author Martini
 */
public class VeiculoControle {
    
    Veiculo objVeiculo;
    JTable jtbVeiculo = null;
    
    public VeiculoControle(Veiculo objVeiculo, JTable jtbVeiculo) {
        this.objVeiculo = objVeiculo;
        this.jtbVeiculo = jtbVeiculo;
    }
    
      public boolean incluir(){
          
          if(verificaExistenciaPlaca() == true){
            return false;
        }
        
        Conexao.abreConexao();
        Connection con = Conexao.obterConexao();
        PreparedStatement stmt = null;
        
        try{
            stmt = con.prepareStatement("INSERT INTO veiculo(cor, placa, km, chassi, renavam, combustivel, id_montadora, id_classificacao, nome, preco, num_portas, quantidade) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");
            stmt.setString(1, objVeiculo.getCor());
            stmt.setString(2, objVeiculo.getPlaca());
            stmt.setString(3, objVeiculo.getKm());
            stmt.setString(4, objVeiculo.getChassi());
            stmt.setString(5, objVeiculo.getRenavam());
            stmt.setString(6, objVeiculo.getCombustivel());
            stmt.setInt(7, objVeiculo.getId_montadora());
            stmt.setInt(8, objVeiculo.getId_classificacao());
            stmt.setString(9, objVeiculo.getNome());
            stmt.setString(10, objVeiculo.getPreco());
            stmt.setString(11, objVeiculo.getNum_portas());
            stmt.setString(12, objVeiculo.getQuantidade());
            
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
        
        if(verificaExistenciaPlaca() == true){
            return false;
        }
        
        Conexao.abreConexao();
        Connection con = Conexao.obterConexao();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("UPDATE veiculo SET cor=?, placa=?, km=?, chassi=?, renavam=?, combustivel=?, id_montadora=?, id_classificacao=?, nome=?, preco=?, num_portas=?,quantidade=? WHERE id_veiculo=?");
            stmt.setString(1, objVeiculo.getCor());
            stmt.setString(2, objVeiculo.getPlaca());
            stmt.setString(3, objVeiculo.getKm());
            stmt.setString(4, objVeiculo.getChassi());
            stmt.setString(5, objVeiculo.getRenavam());
            stmt.setString(6, objVeiculo.getCombustivel());
            stmt.setInt(7, objVeiculo.getId_montadora());
            stmt.setInt(8, objVeiculo.getId_classificacao());
            stmt.setString(9, objVeiculo.getNome());
            stmt.setString(10, objVeiculo.getPreco());
            stmt.setString(11, objVeiculo.getNum_portas());
            stmt.setString(12, objVeiculo.getQuantidade());
            stmt.setInt(13, objVeiculo.getId_veiculo());
            
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
        cabecalhos.add("Placa");
        cabecalhos.add("Preço");
        cabecalhos.add("KM");
        cabecalhos.add("Excluir");
        
        ResultSet result = null;
        
        try {

            String SQL = "";
            SQL = " SELECT id_veiculo,nome,placa,preco,km ";
            SQL += " FROM veiculo ";
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
                linha.add(result.getString(5));
                linha.add("X");
                
                dadosTabela.add(linha);
            }
            
        } catch (Exception e) {
            System.out.println("problemas para popular tabela...");
            System.out.println(e);
        }

        jtbVeiculo.setModel(new DefaultTableModel(dadosTabela, cabecalhos) {

            @Override
            public boolean isCellEditable(int row, int column) {
              return false;
            }
            // permite seleção de apenas uma linha da tabela
        });

        // permite seleção de apenas uma linha da tabela
        jtbVeiculo.setSelectionMode(0);

        // redimensiona as colunas de uma tabela
        TableColumn column = null;
        for (int i = 0; i <= 5; i++) {
            column = jtbVeiculo.getColumnModel().getColumn(i);
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
        
        jtbVeiculo.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {

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
      
      public Veiculo buscar(String id)
    {
        try {
            Conexao.abreConexao();
            ResultSet rs = null;

            String SQL = "";
            SQL = " SELECT id_veiculo, cor, placa, km, chassi, renavam, combustivel, id_montadora, id_classificacao, nome, preco, num_portas,quantidade";
            SQL += " FROM veiculo ";
            SQL += " WHERE id_veiculo = '" + id + "'";
            SQL += " AND data_exclusao is null ";

            try{
                System.out.println("Vai Executar Conexão em buscar");
                rs = Conexao.stmt.executeQuery(SQL);
                System.out.println("Executou Conexão em buscar");

                objVeiculo = new Veiculo();
                if(rs.next() == true)
                {
                    objVeiculo.setId_veiculo(rs.getInt(1));
                    objVeiculo.setCor(rs.getString(2));
                    objVeiculo.setPlaca(rs.getString(3));
                    objVeiculo.setKm(rs.getString(4));
                    objVeiculo.setChassi(rs.getString(5));
                    objVeiculo.setRenavam(rs.getString(6));
                    objVeiculo.setCombustivel(rs.getString(7));
                    objVeiculo.setId_montadora(rs.getInt(8));
                    objVeiculo.setId_classificacao(rs.getInt(9));
                    objVeiculo.setNome(rs.getString(10));
                    objVeiculo.setPreco(rs.getString(11)); 
                    objVeiculo.setNum_portas(rs.getString(12));
                    objVeiculo.setQuantidade(rs.getString(13));
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
        return objVeiculo;
    }
      
      public boolean excluir(){
        
        Conexao.abreConexao();
        Connection con = Conexao.obterConexao();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("UPDATE veiculo SET data_exclusao= now() WHERE id_veiculo=?");
            stmt.setInt(1, objVeiculo.getId_veiculo());
                        
            stmt.executeUpdate();
            
            return true;
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }finally{
            Conexao.fecharConexao(con, stmt);
        }
    }
    
    public Boolean verificaExistenciaPlaca()
    {
        try {
            Conexao.abreConexao();
            ResultSet rs = null;

            String SQL = "";
            SQL = " SELECT id_veiculo, nome ";
            SQL += " FROM veiculo ";
            SQL += " WHERE placa = '" + objVeiculo.getPlaca()+ "'";
            SQL += " AND data_exclusao is null ";

            try{
                System.out.println("Vai Executar Conexão em buscar");
                rs = Conexao.stmt.executeQuery(SQL);
                System.out.println("Executou Conexão em buscar");

                if(rs.next() == true)
                {
                    if(rs.getInt(1) != objVeiculo.getId_veiculo()){
                        return true; //Já existe um carro com esta placa;
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
            SQL = " SELECT * from veiculo ";

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

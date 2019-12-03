/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import static banco.Conexao.obterConexao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Martini
 */
public class EntradaSaida extends javax.swing.JFrame {
    
    static Connection con;
    public static Statement stmt;
    
    public EntradaSaida() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnProcessar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaDados = new javax.swing.JTable();
        lblOperacao = new javax.swing.JLabel();
        rbEntrada = new javax.swing.JRadioButton();
        rbSaida = new javax.swing.JRadioButton();
        lblQuantidade = new javax.swing.JLabel();
        txtQuantidade = new javax.swing.JTextField();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnProcessar.setText("PROCESSAR");
        btnProcessar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProcessarActionPerformed(evt);
            }
        });
        getContentPane().add(btnProcessar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 360, -1, -1));

        tabelaDados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "Quantidade"
            }
        ));
        jScrollPane2.setViewportView(tabelaDados);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 450, 200));

        lblOperacao.setText("Operação:");
        getContentPane().add(lblOperacao, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, -1, -1));

        rbEntrada.setText("Entrada");
        getContentPane().add(rbEntrada, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, -1, -1));

        rbSaida.setText("Saída");
        getContentPane().add(rbSaida, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 260, -1, -1));

        lblQuantidade.setText("Quantidade:");
        getContentPane().add(lblQuantidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, -1, -1));
        getContentPane().add(txtQuantidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, 100, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnProcessarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProcessarActionPerformed
        // TODO add your handling code here:
        int linha = tabelaDados.getSelectedRow();
        if (validarDados() && (linha >= 0)) {
            String sql = "";
            if (rbEntrada.isSelected()) {
                sql = "UPDATE veiculo SET quantidade=quantidade+? WHERE id_veiculo=?";                
            } else {
                sql = "UPDATE veiculo SET quantidade=quantidade-? WHERE id_veiculo=?";                                
            }
            
            try {
                PreparedStatement stmt = con.prepareStatement(null);
                stmt.setString(1, txtQuantidade.getText());
                stmt.setString(2, tabelaDados.getValueAt(linha, 0).toString());
                stmt.execute();
                stmt.close();
                mostrarDados();
                JOptionPane.showMessageDialog(null, "Alterado com sucesso!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Erro! Verifique os campos.");
        }
        txtQuantidade.setText("");
        txtQuantidade.grabFocus();        
                                      
    }//GEN-LAST:event_btnProcessarActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        try {
            
            Connection con = obterConexao();
            stmt = con.createStatement();
            System.out.print("Conexão com Banco de Dados Criada!");
        } catch (Exception ex) {
            System.out.print(ex);
        }
    }//GEN-LAST:event_formWindowOpened

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EntradaSaida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EntradaSaida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EntradaSaida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EntradaSaida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EntradaSaida().setVisible(true);
            }
        });
    }
    public void setOperacao(int op) {
        if (op == 1) {
            rbEntrada.setSelected(true);
        } else {
            rbSaida.setSelected(true);
        }
    }
    
    private void mostrarDados() {
       try {
           PreparedStatement stmt = con.prepareStatement("SELECT * FROM veiculo");
           ResultSet rs = stmt.executeQuery();
           DefaultTableModel model = (DefaultTableModel) tabelaDados.getModel();
           model.setRowCount(0); // Limpar Tabela
           while (rs.next()) {
               Object linha[] = {rs.getString("id_veiculo"), rs.getString("nome"),
                                 rs.getString("quantidade")};
               model.addRow(linha);
           }   
           stmt.close();
       } catch (Exception e) {
           e.printStackTrace();
       }
    }
    private boolean validarDados() {
        if (txtQuantidade.getText().trim().length() == 0) {
            return false;
        }
        
        try {
            int quantidade = Integer.parseInt(txtQuantidade.getText());
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnProcessar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblOperacao;
    private javax.swing.JLabel lblQuantidade;
    private javax.swing.JRadioButton rbEntrada;
    private javax.swing.JRadioButton rbSaida;
    private javax.swing.JTable tabelaDados;
    private javax.swing.JTextField txtQuantidade;
    // End of variables declaration//GEN-END:variables
}
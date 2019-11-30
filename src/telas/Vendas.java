/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import controles.VendaControle;
import ferramentas.CaixaDeDialogo;
import ferramentas.Combos;
import ferramentas.Formatacao;
import ferramentas.Validacao;
import modelos.Venda;

/**
 *
 * @author Martini
 */
public class Vendas extends javax.swing.JFrame {

    Combos cbComboVeiculo;
    Combos cbComboCliente;
    Venda objVenda;
    VendaControle objVendaControle;
    
    public Vendas() {
        initComponents();
        limparTela();
        
        try{
            cbComboCliente = new Combos(jComboCliente);
            cbComboCliente.PreencheCombo("SELECT id_cliente, nome FROM cliente ");
            
            
            
            cbComboVeiculo = new Combos(jComboVeiculo);
            cbComboVeiculo.PreencheCombo("SELECT id_veiculo, nome  FROM veiculo ");
            
             
        }catch (Exception ex) {
            CaixaDeDialogo.obterinstancia().exibirMensagem("ERRO:" + ex.getMessage());
        }
    
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lblId = new javax.swing.JLabel();
        lblData = new javax.swing.JLabel();
        txtData = new javax.swing.JTextField();
        lblPagamento = new javax.swing.JLabel();
        txtPagamento = new javax.swing.JTextField();
        lblValor = new javax.swing.JLabel();
        txtValor = new javax.swing.JTextField();
        jComboVeiculo = new javax.swing.JComboBox<>();
        lblVeiculo = new javax.swing.JLabel();
        lblCliente = new javax.swing.JLabel();
        jComboCliente = new javax.swing.JComboBox<>();
        btnSalvar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("CADASTRO VENDAS");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, -1, -1));

        lblId.setText("ID");
        getContentPane().add(lblId, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 20, -1, -1));

        lblData.setText("Data:");
        getContentPane().add(lblData, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));
        getContentPane().add(txtData, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 140, -1));

        lblPagamento.setText("Forma Pagamento:");
        getContentPane().add(lblPagamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));
        getContentPane().add(txtPagamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 90, 110, -1));

        lblValor.setText("Valor Veículo:");
        getContentPane().add(lblValor, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, 10));
        getContentPane().add(txtValor, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 130, 100, -1));

        getContentPane().add(jComboVeiculo, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 170, -1, -1));

        lblVeiculo.setText("Veículo:");
        getContentPane().add(lblVeiculo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        lblCliente.setText("Cliente:");
        getContentPane().add(lblCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, -1, -1));

        getContentPane().add(jComboCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 210, -1, -1));

        btnSalvar.setText("SALVAR");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, -1, -1));

        btnLimpar.setText("LIMPAR");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });
        getContentPane().add(btnLimpar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 260, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        // TODO add your handling code here:
        try{
            boolean retorno;
            //validar os campos
            if(txtPagamento.getText().trim().length() == 0){
                CaixaDeDialogo.obterinstancia().exibirMensagem("Informe um nome corretamente", 'a');
                return;
            }
            if(txtValor.getText().trim().length() == 0){
                CaixaDeDialogo.obterinstancia().exibirMensagem("Informe um CPF corretamente", 'a');
                return;
            }
            
            if(!Validacao.validarData(txtData.getText())){
                CaixaDeDialogo.obterinstancia().exibirMensagem("Informe uma data corretamente", 'a');
                return;
            }
            
            
            objVenda = new Venda();
            objVenda.setForma_pagamento(txtPagamento.getText().trim());
            objVenda.setValor(txtValor.getText().trim());
            
            
            Combos v = (Combos) jComboVeiculo.getSelectedItem();
            String veiculo = v.getCodigo();
            objVenda.setId_veiculo(Integer.parseInt(veiculo));
            
            Combos c = (Combos) jComboCliente.getSelectedItem();
            String cliente = c.getCodigo();
            objVenda.setId_cliente(Integer.parseInt(cliente));
            
            
            String data_venda = Formatacao.ajustaDataAMD(txtData.getText());
            objVenda.setDtvenda(data_venda);
            
            
            
            if(!lblId.getText().equals("ID")){
                objVenda.setId_venda(Integer.parseInt(lblId.getText()));
                objVendaControle = new VendaControle(objVenda);
                retorno = objVendaControle.alterar();
            }else{
                objVendaControle = new VendaControle(objVenda);
                retorno = objVendaControle.incluir();
            }
            
            if(retorno = true){
                CaixaDeDialogo.obterinstancia().exibirMensagem("Registro salvo");
            }else{
                CaixaDeDialogo.obterinstancia().exibirMensagem("Erro ao tentar salvar");
            }
            
           

        }catch(Exception ex){
            CaixaDeDialogo.obterinstancia().exibirMensagem("Erro ao tentar incluir");
            System.out.println("ERRO: " + ex.getMessage().toString());
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        // TODO add your handling code here:
        limparTela();
    }//GEN-LAST:event_btnLimparActionPerformed

    private void limparTela(){
        try{
            lblId.setText("ID");
            txtData.setText("");
            txtPagamento.setText("");
            txtValor.setText("");
            jComboCliente.setSelectedIndex(-1);
            jComboVeiculo.setSelectedIndex(-1);
            
            
            
            
           
            btnSalvar.setEnabled(true);
            
            
            
        }catch(Exception ex){
            CaixaDeDialogo.obterinstancia().exibirMensagem("Erro: " + ex.getMessage());
        }
    }
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
            java.util.logging.Logger.getLogger(Vendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Vendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Vendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Vendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Vendas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<String> jComboCliente;
    private javax.swing.JComboBox<String> jComboVeiculo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblCliente;
    private javax.swing.JLabel lblData;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblPagamento;
    private javax.swing.JLabel lblValor;
    private javax.swing.JLabel lblVeiculo;
    private javax.swing.JTextField txtData;
    private javax.swing.JTextField txtPagamento;
    private javax.swing.JTextField txtValor;
    // End of variables declaration//GEN-END:variables
}

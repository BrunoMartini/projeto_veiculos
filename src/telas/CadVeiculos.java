/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import controles.VeiculoControle;
import ferramentas.CaixaDeDialogo;
import ferramentas.Combos;
import java.text.DecimalFormat;
import modelos.Veiculo;

/**
 *
 * @author Martini
 */
public class CadVeiculos extends javax.swing.JFrame {

    Combos cbComboMontadora;
    Combos cbComboClassificacao;
    Veiculo objVeiculo;
    VeiculoControle objVeiculoControle;
    
    public CadVeiculos() {
        initComponents();
        limparTela();
        
        try{
            cbComboClassificacao = new Combos(jComboClassificacao);
            cbComboClassificacao.PreencheCombo("SELECT id_classificacao, descricao FROM classificacao ");
            
            
            cbComboMontadora = new Combos(jComboMontadora);
            cbComboMontadora.PreencheCombo("SELECT id_montadora, descricao  FROM montadora ");
            
             
        }catch (Exception ex) {
            CaixaDeDialogo.obterinstancia().exibirMensagem("ERRO:" + ex.getMessage());
        }
    }
     private void atualizarTabela(){
        try{
            
            objVeiculoControle = new VeiculoControle(null, jtbVeiculo);
            objVeiculoControle.preencher();
            
        }catch(Exception ex){
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
        lblNome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        lblPlaca = new javax.swing.JLabel();
        txtPlaca = new javax.swing.JTextField();
        lblCor = new javax.swing.JLabel();
        txtCor = new javax.swing.JTextField();
        lblKm = new javax.swing.JLabel();
        txtKm = new javax.swing.JTextField();
        lblChassi = new javax.swing.JLabel();
        txtChassi = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtRenavam = new javax.swing.JTextField();
        lblCombustivel = new javax.swing.JLabel();
        txtCombustivel = new javax.swing.JTextField();
        lblId = new javax.swing.JLabel();
        jComboMontadora = new javax.swing.JComboBox<>();
        lblMontadora = new javax.swing.JLabel();
        lblClassificacao = new javax.swing.JLabel();
        jComboClassificacao = new javax.swing.JComboBox<>();
        lblPreco = new javax.swing.JLabel();
        txtPreco = new javax.swing.JTextField();
        lblPortas = new javax.swing.JLabel();
        txtPortas = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbVeiculo = new javax.swing.JTable();
        btnSalvar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        lblQuantidade = new javax.swing.JLabel();
        txtQuantidade = new javax.swing.JTextField();
        lblAno = new javax.swing.JLabel();
        txtAno = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("CADASTRO VEÍCULOS");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 10, -1, 20));

        lblNome.setText("Nome:");
        getContentPane().add(lblNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));
        getContentPane().add(txtNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, 170, -1));

        lblPlaca.setText("Placa:");
        getContentPane().add(lblPlaca, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));
        getContentPane().add(txtPlaca, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, 120, -1));

        lblCor.setText("Cor:");
        getContentPane().add(lblCor, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));
        getContentPane().add(txtCor, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 110, -1));

        lblKm.setText("KM:");
        getContentPane().add(lblKm, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, -1));
        getContentPane().add(txtKm, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 90, -1));

        lblChassi.setText("Chassi:");
        getContentPane().add(lblChassi, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 50, -1, -1));
        getContentPane().add(txtChassi, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 50, 140, -1));

        jLabel2.setText("Renavam:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 90, -1, -1));
        getContentPane().add(txtRenavam, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 90, 120, -1));

        lblCombustivel.setText("Combustível:");
        getContentPane().add(lblCombustivel, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 120, -1, -1));
        getContentPane().add(txtCombustivel, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 120, 140, -1));

        lblId.setText("ID");
        getContentPane().add(lblId, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 10, -1, -1));

        getContentPane().add(jComboMontadora, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 160, -1, -1));

        lblMontadora.setText("Montadora:");
        getContentPane().add(lblMontadora, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 160, -1, -1));

        lblClassificacao.setText("Classificação:");
        getContentPane().add(lblClassificacao, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, -1));

        getContentPane().add(jComboClassificacao, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 180, -1, -1));

        lblPreco.setText("Preço:");
        getContentPane().add(lblPreco, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, -1, -1));
        getContentPane().add(txtPreco, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, 130, -1));

        lblPortas.setText("Portas:");
        getContentPane().add(lblPortas, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 200, -1, -1));
        getContentPane().add(txtPortas, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 200, 110, -1));

        jtbVeiculo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Título 5", "Título 6"
            }
        ));
        jtbVeiculo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbVeiculoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtbVeiculo);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 270, 510, 100));

        btnSalvar.setText("SALVAR");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 390, -1, -1));

        btnLimpar.setText("LIMPAR");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });
        getContentPane().add(btnLimpar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 390, -1, -1));

        lblQuantidade.setText("Quantidade:");
        getContentPane().add(lblQuantidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 230, -1, -1));
        getContentPane().add(txtQuantidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 230, 70, -1));

        lblAno.setText("Ano:");
        getContentPane().add(lblAno, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 160, -1, -1));
        getContentPane().add(txtAno, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 160, 70, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        // TODO add your handling code here:
        try{
            boolean retorno;
            //validar os campos
            if(txtCor.getText().trim().length() == 0){
                CaixaDeDialogo.obterinstancia().exibirMensagem("Informe um nome corretamente", 'a');
                return;
            }
            if(txtPlaca.getText().trim().length() == 0){
                CaixaDeDialogo.obterinstancia().exibirMensagem("Informe um CPF corretamente", 'a');
                return;
            }
            if(txtKm.getText().trim().length() == 0){
                CaixaDeDialogo.obterinstancia().exibirMensagem("Informe um CPF corretamente", 'a');
                return;
            }
            
             if(txtChassi.getText().trim().length() == 0){
                CaixaDeDialogo.obterinstancia().exibirMensagem("Informe um telefone corretamente", 'a');
                return;
            }
              if(txtRenavam.getText().trim().length() == 0){
                CaixaDeDialogo.obterinstancia().exibirMensagem("Informe um e-mail corretamente", 'a');
                return;
            }
               if(txtCombustivel.getText().trim().length() == 0){
                CaixaDeDialogo.obterinstancia().exibirMensagem("Informe uma rua corretamente", 'a');
                return;
            }
                if(txtNome.getText().trim().length() == 0){
                CaixaDeDialogo.obterinstancia().exibirMensagem("Informe um número corretamente", 'a');
                return;
            }
                if(txtPreco.getText().trim().length() == 0){
                CaixaDeDialogo.obterinstancia().exibirMensagem("Informe um número corretamente", 'a');
                return;
            }
                if(txtPortas.getText().trim().length() == 0){
                CaixaDeDialogo.obterinstancia().exibirMensagem("Informe um número corretamente", 'a');
                return;
            }
                if(txtQuantidade.getText().trim().length() == 0){
                CaixaDeDialogo.obterinstancia().exibirMensagem("Informe um número corretamente", 'a');
                return;
            }
                if(txtAno.getText().trim().length() == 0){
                CaixaDeDialogo.obterinstancia().exibirMensagem("Informe um número corretamente", 'a');
                return;
            }
            
            objVeiculo = new Veiculo();
            objVeiculo.setCor(txtCor.getText().trim());
            objVeiculo.setPlaca(txtPlaca.getText().trim());
            objVeiculo.setKm(txtKm.getText().trim());
            objVeiculo.setChassi(txtChassi.getText().trim());
            objVeiculo.setRenavam(txtRenavam.getText().trim());
            objVeiculo.setCombustivel(txtCombustivel.getText().trim());
            objVeiculo.setNome(txtNome.getText().trim());
            objVeiculo.setPreco(Double.parseDouble(txtPreco.getText().trim()));
            objVeiculo.setNum_portas(txtPortas.getText().trim());
            objVeiculo.setQuantidade(txtQuantidade.getText().trim());
            objVeiculo.setQuantidade(txtAno.getText().trim());
            
            Combos m = (Combos) jComboMontadora.getSelectedItem();
            String montadora = m.getCodigo();
            objVeiculo.setId_montadora(Integer.parseInt(montadora));
            
            Combos c = (Combos) jComboClassificacao.getSelectedItem();
            String classificacao = c.getCodigo();
            objVeiculo.setId_classificacao(Integer.parseInt(classificacao));
            
            
            if(!lblId.getText().equals("ID")){
                objVeiculo.setId_veiculo(Integer.parseInt(lblId.getText()));
                objVeiculoControle = new VeiculoControle(objVeiculo, null);
                retorno = objVeiculoControle.alterar();
            }else{
                objVeiculoControle = new VeiculoControle(objVeiculo, null);
                retorno = objVeiculoControle.incluir();
            }
            
            if(retorno = true){
                CaixaDeDialogo.obterinstancia().exibirMensagem("Registro salvo");
            }else{
                CaixaDeDialogo.obterinstancia().exibirMensagem("Erro ao tentar salvar");
            }
            
           atualizarTabela();

        }catch(Exception ex){
            CaixaDeDialogo.obterinstancia().exibirMensagem("Erro ao tentar incluir");
            System.out.println("ERRO: " + ex.getMessage().toString());
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        // TODO add your handling code here:
        limparTela();
    }//GEN-LAST:event_btnLimparActionPerformed

    private void jtbVeiculoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbVeiculoMouseClicked
        // TODO add your handling code here:
        try{
            
            int linhaSelecionada = jtbVeiculo.getSelectedRow();//pega a linha selecionada
            String codigo = jtbVeiculo.getModel().getValueAt(linhaSelecionada, 0).toString(); // Primeira coluna da linha
        
            //Verifica se clicou na coluna 5 = EXCLUIR
            if(jtbVeiculo.isColumnSelected(5)){
                try{
                    boolean wPergunta = CaixaDeDialogo.obterinstancia().pedirConfirmacao("Tem certeza de que deseja excluir?","",'p');
                    if (wPergunta == true){
                        objVeiculo = new Veiculo();
                        objVeiculo.setId_veiculo(Integer.parseInt(codigo));
                        
                        objVeiculoControle = new VeiculoControle(objVeiculo, null);
                        boolean wControle = objVeiculoControle.excluir();
                        if (wControle){
                            CaixaDeDialogo.obterinstancia().exibirMensagem("Excluído com Sucesso!");
                        }else{
                            CaixaDeDialogo.obterinstancia().exibirMensagem("Erro ao excluir!");
                        }
                    }
                    atualizarTabela();
                }catch (Exception ex){
                    CaixaDeDialogo.obterinstancia().exibirMensagem("Erro: " + ex.getMessage());
                }
            }else{
                 objVeiculoControle = new VeiculoControle(null, null);
                objVeiculo = objVeiculoControle.buscar(codigo);
                if (objVeiculo != null && objVeiculo.getId_veiculo()> 0){
                    preencherCampos();
                }else{
                    CaixaDeDialogo.obterinstancia().exibirMensagem("Erro ao buscar no BD!");
                }
            }
        }catch (Exception ex){
            CaixaDeDialogo.obterinstancia().exibirMensagem(ex.getMessage(), 'e');
        }
    }//GEN-LAST:event_jtbVeiculoMouseClicked

    private void limparTela(){
        try{
            lblId.setText("ID");
            txtCor.setText("");
            txtPlaca.setText("");
            txtKm.setText("");
            txtChassi.setText("");
            txtRenavam.setText("");
            txtCombustivel.setText("");
            txtNome.setText("");
            txtPreco.setText("");
            txtPortas.setText("");
            txtQuantidade.setText("");
            txtAno.setText("");
            jComboMontadora.setSelectedIndex(-1);
            jComboClassificacao.setSelectedIndex(-1);
            
            
            
            
            
           
            btnSalvar.setEnabled(true);
            
            atualizarTabela();
            
        }catch(Exception ex){
            CaixaDeDialogo.obterinstancia().exibirMensagem("Erro: " + ex.getMessage());
        }
    }
     private void preencherCampos(){
         
        try{
            lblId.setText(String.valueOf(objVeiculo.getId_veiculo()));
            txtCor.setText(objVeiculo.getCor());
            txtPlaca.setText(objVeiculo.getPlaca());
            txtKm.setText(objVeiculo.getKm());
            txtChassi.setText(objVeiculo.getChassi());
            txtRenavam.setText(objVeiculo.getRenavam());
            txtCombustivel.setText(objVeiculo.getCombustivel());
            txtNome.setText(objVeiculo.getNome());
            txtPreco.setText(String.valueOf(objVeiculo.getPreco()));
            txtPortas.setText(objVeiculo.getNum_portas());
            txtQuantidade.setText(objVeiculo.getQuantidade());
            txtAno.setText(objVeiculo.getQuantidade());
            cbComboClassificacao.SetaComboBox(String.valueOf(objVeiculo.getId_classificacao()));
            cbComboMontadora.SetaComboBox(String.valueOf(objVeiculo.getId_montadora()));
            
            
            
            
            
            
           
           
            btnSalvar.setEnabled(true);
            
          
            
            atualizarTabela();
            
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
            java.util.logging.Logger.getLogger(CadVeiculos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadVeiculos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadVeiculos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadVeiculos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadVeiculos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<String> jComboClassificacao;
    private javax.swing.JComboBox<String> jComboMontadora;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtbVeiculo;
    private javax.swing.JLabel lblAno;
    private javax.swing.JLabel lblChassi;
    private javax.swing.JLabel lblClassificacao;
    private javax.swing.JLabel lblCombustivel;
    private javax.swing.JLabel lblCor;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblKm;
    private javax.swing.JLabel lblMontadora;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblPlaca;
    private javax.swing.JLabel lblPortas;
    private javax.swing.JLabel lblPreco;
    private javax.swing.JLabel lblQuantidade;
    private javax.swing.JTextField txtAno;
    private javax.swing.JTextField txtChassi;
    private javax.swing.JTextField txtCombustivel;
    private javax.swing.JTextField txtCor;
    private javax.swing.JTextField txtKm;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtPlaca;
    private javax.swing.JTextField txtPortas;
    private javax.swing.JTextField txtPreco;
    private javax.swing.JTextField txtQuantidade;
    private javax.swing.JTextField txtRenavam;
    // End of variables declaration//GEN-END:variables
}

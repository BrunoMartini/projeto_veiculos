/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import com.sun.imageio.plugins.jpeg.JPEG;
import controles.ClienteControle;
import ferramentas.CaixaDeDialogo;
import ferramentas.Combos;
import ferramentas.Formatacao;
import ferramentas.Validacao;
import java.sql.SQLException;
import modelos.Cliente;

/**
 *
 * @author Bruno Martini
 */
public class CadCliente extends javax.swing.JFrame {

    Combos cbComboEstado;
    Combos cbComboCidade;
    Combos cbComboBairro;
    Cliente objCliente;
    ClienteControle objClienteControle;
    
    
    public CadCliente() {
        initComponents();
        limparTela();
        
        try{
            cbComboBairro = new Combos(jComboBairro);
            cbComboBairro.PreencheCombo("SELECT id, nome FROM bairros ");
            
            
            
            cbComboEstado = new Combos(jComboEstado);
            cbComboEstado.PreencheCombo("SELECT id_estado, sigla_estado  FROM estado ");
            
             
        }catch (Exception ex) {
            CaixaDeDialogo.obterinstancia().exibirMensagem("ERRO:" + ex.getMessage());
        }
    }
    private void atualizarTabela(){
        try{
            
            objClienteControle = new ClienteControle(null, jtbCliente);
            objClienteControle.preencher();
            
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
        lblId = new javax.swing.JLabel();
        lblNome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        lblCpf = new javax.swing.JLabel();
        lblNascimento = new javax.swing.JLabel();
        txtNascimento = new javax.swing.JTextField();
        lblTelefone = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        lblRua = new javax.swing.JLabel();
        txtRua = new javax.swing.JTextField();
        lblNumero = new javax.swing.JLabel();
        txtNumero = new javax.swing.JTextField();
        jComboBairro = new javax.swing.JComboBox();
        lblBairro = new javax.swing.JLabel();
        lblEstado = new javax.swing.JLabel();
        jComboEstado = new javax.swing.JComboBox();
        lblCidade = new javax.swing.JLabel();
        jComboCidade = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbCliente = new javax.swing.JTable();
        btnSalvar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        txtCpf = new javax.swing.JFormattedTextField();
        txtTelefone = new javax.swing.JFormattedTextField();
        btnSair = new javax.swing.JButton();
        addCidade = new javax.swing.JButton();
        addBairro = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("CADASTRO DE CLIENTES");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 20, -1, -1));

        lblId.setText("ID");
        getContentPane().add(lblId, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        lblNome.setText("Nome:");
        getContentPane().add(lblNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, -1, -1));
        getContentPane().add(txtNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, 160, -1));

        lblCpf.setText("CPF:");
        getContentPane().add(lblCpf, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 60, -1, -1));

        lblNascimento.setText("Data Nascimento:");
        getContentPane().add(lblNascimento, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));
        getContentPane().add(txtNascimento, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 110, 130, -1));

        lblTelefone.setText("Telefone:");
        getContentPane().add(lblTelefone, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 110, -1, -1));

        lblEmail.setText("E-mail:");
        getContentPane().add(lblEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, -1));
        getContentPane().add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, 130, -1));

        lblRua.setText("Rua:");
        getContentPane().add(lblRua, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 170, -1, -1));
        getContentPane().add(txtRua, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 170, 160, -1));

        lblNumero.setText("Número:");
        getContentPane().add(lblNumero, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 170, -1, -1));
        getContentPane().add(txtNumero, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 170, 150, -1));

        getContentPane().add(jComboBairro, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 220, -1, -1));

        lblBairro.setText("Bairro:");
        getContentPane().add(lblBairro, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, -1, -1));

        lblEstado.setText("Estado:");
        getContentPane().add(lblEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 220, -1, -1));

        jComboEstado.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboEstadoItemStateChanged(evt);
            }
        });
        getContentPane().add(jComboEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 220, -1, -1));

        lblCidade.setText("Cidade:");
        getContentPane().add(lblCidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 220, -1, -1));

        getContentPane().add(jComboCidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 220, -1, -1));

        jtbCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Título 5", "Título 6"
            }
        ));
        jtbCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbClienteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtbCliente);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 850, 120));

        btnSalvar.setText("SALVAR");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 400, -1, -1));

        btnLimpar.setText("LIMPAR");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });
        getContentPane().add(btnLimpar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 400, -1, -1));

        try {
            txtCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        getContentPane().add(txtCpf, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 60, 150, -1));

        try {
            txtTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        getContentPane().add(txtTelefone, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 110, 140, -1));

        btnSair.setText("SAIR");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });
        getContentPane().add(btnSair, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 400, -1, -1));

        addCidade.setText("CADASTRO CIDADE");
        addCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCidadeActionPerformed(evt);
            }
        });
        getContentPane().add(addCidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 400, -1, -1));

        addBairro.setText("CADASTRO BAIRRO");
        addBairro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBairroActionPerformed(evt);
            }
        });
        getContentPane().add(addBairro, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 400, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtbClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbClienteMouseClicked
       try{
            
            int linhaSelecionada = jtbCliente.getSelectedRow();//pega a linha selecionada
            String codigo = jtbCliente.getModel().getValueAt(linhaSelecionada, 0).toString(); // Primeira coluna da linha
        
            //Verifica se clicou na coluna 5 = EXCLUIR
            if(jtbCliente.isColumnSelected(5)){
                try{
                    boolean wPergunta = CaixaDeDialogo.obterinstancia().pedirConfirmacao("Tem certeza de que deseja excluir?","",'p');
                    if (wPergunta == true){
                        objCliente = new Cliente();
                        objCliente.setId_cliente(Integer.parseInt(codigo));
                        
                        objClienteControle = new ClienteControle(objCliente, null);
                        boolean wControle = objClienteControle.excluir();
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
                 objClienteControle = new ClienteControle(null, null);
                objCliente = objClienteControle.buscar(codigo);
                if (objCliente != null && objCliente.getId_cliente()> 0){
                    preencherCampos();
                }else{
                    CaixaDeDialogo.obterinstancia().exibirMensagem("Erro ao buscar no BD!");
                }
            }
        }catch (Exception ex){
            CaixaDeDialogo.obterinstancia().exibirMensagem(ex.getMessage(), 'e');
        }
    }//GEN-LAST:event_jtbClienteMouseClicked

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        try{
            boolean retorno;
            //validar os campos
            if(txtNome.getText().trim().length() == 0){
                CaixaDeDialogo.obterinstancia().exibirMensagem("Informe um nome corretamente", 'a');
                return;
            }
            if(txtCpf.getText().trim().length() == 0){
                CaixaDeDialogo.obterinstancia().exibirMensagem("Informe um CPF corretamente", 'a');
                return;
            }
            if(txtCpf.getText().trim().length() == 0){
                CaixaDeDialogo.obterinstancia().exibirMensagem("Informe um CPF corretamente", 'a');
                return;
            }
            if(!Validacao.validarData(txtNascimento.getText())){
                CaixaDeDialogo.obterinstancia().exibirMensagem("Informe uma data corretamente", 'a');
                return;
            }
             if(txtTelefone.getText().trim().length() == 0){
                CaixaDeDialogo.obterinstancia().exibirMensagem("Informe um telefone corretamente", 'a');
                return;
            }
              if(txtEmail.getText().trim().length() == 0){
                CaixaDeDialogo.obterinstancia().exibirMensagem("Informe um e-mail corretamente", 'a');
                return;
            }
               if(txtRua.getText().trim().length() == 0){
                CaixaDeDialogo.obterinstancia().exibirMensagem("Informe uma rua corretamente", 'a');
                return;
            }
                if(txtNumero.getText().trim().length() == 0){
                CaixaDeDialogo.obterinstancia().exibirMensagem("Informe um número corretamente", 'a');
                return;
            }
            
            objCliente = new Cliente();
            objCliente.setNome(txtNome.getText().trim());
            objCliente.setCpf(txtCpf.getText().trim());
            objCliente.setTelefone(txtTelefone.getText().trim());
            objCliente.setEmail(txtEmail.getText().trim());
            objCliente.setRua(txtRua.getText().trim());
            objCliente.setNumero(txtNumero.getText().trim());
            
            Combos c = (Combos) jComboBairro.getSelectedItem();
            String bairro = c.getCodigo();
            objCliente.setId_bairro(Integer.parseInt(bairro));
            
            Combos d = (Combos) jComboEstado.getSelectedItem();
            String estado = d.getCodigo();
            objCliente.setId_estado(Integer.parseInt(estado));
            
            Combos e = (Combos) jComboCidade.getSelectedItem();
            String cidade = e.getCodigo();
            objCliente.setId_cidade(Integer.parseInt(cidade));
            
            
            String data_nasc = Formatacao.ajustaDataAMD(txtNascimento.getText());
            objCliente.setDtnasc(data_nasc);
            
            
            
            if(!lblId.getText().equals("ID")){
                objCliente.setId_cliente(Integer.parseInt(lblId.getText()));
                objClienteControle = new ClienteControle(objCliente, null);
                retorno = objClienteControle.alterar();
            }else{
                objClienteControle = new ClienteControle(objCliente, null);
                retorno = objClienteControle.incluir();
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
        limparTela();
    }//GEN-LAST:event_btnLimparActionPerformed

    private void jComboEstadoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboEstadoItemStateChanged
        // TODO add your handling code here:
        try{
            if(jComboEstado.getSelectedIndex() > 0){
                
                Combos estado = (Combos) jComboEstado.getSelectedItem();
                String sigla = estado.getCodigo();
                
                cbComboCidade = new Combos(jComboCidade);
                cbComboCidade.PreencheCombo(" SELECT id_cidade, nome FROM cidade WHERE id_estado = '"+ sigla +"' ");
                
            }
        
        }catch(SQLException ex){
            CaixaDeDialogo.obterinstancia().exibirMensagem(ex.getMessage());
        }
    }//GEN-LAST:event_jComboEstadoItemStateChanged

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void addCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCidadeActionPerformed
        // TODO add your handling code here:
        CadCidade tela_cidade = new CadCidade();
        tela_cidade.setVisible(true);
    }//GEN-LAST:event_addCidadeActionPerformed

    private void addBairroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBairroActionPerformed
        // TODO add your handling code here:
        CadBairros tela_bairros = new CadBairros();
        tela_bairros.setVisible(true);
    }//GEN-LAST:event_addBairroActionPerformed

    private void limparTela(){
        try{
            lblId.setText("ID");
            txtNome.setText("");
            txtCpf.setText("");
            txtNascimento.setText("");
            txtTelefone.setText("");
            txtEmail.setText("");
            txtRua.setText("");
            txtNumero.setText("");
            jComboBairro.setSelectedIndex(-1);
            jComboEstado.setSelectedIndex(-1);
            jComboCidade.setSelectedIndex(-1);
            
            
            
            
           
            btnSalvar.setEnabled(true);
            
            atualizarTabela();
            
        }catch(Exception ex){
            CaixaDeDialogo.obterinstancia().exibirMensagem("Erro: " + ex.getMessage());
        }
    }
    
    private void preencherCampos(){
        try{
            lblId.setText(String.valueOf(objCliente.getId_cliente()));
            txtNome.setText(objCliente.getNome());
            txtCpf.setText(objCliente.getCpf());
            
            String data=Formatacao.ajustaDataDMA(objCliente.getDtnasc());
            txtNascimento.setText(data);
            
            txtTelefone.setText(objCliente.getTelefone());
            txtEmail.setText(objCliente.getEmail());
            txtRua.setText(objCliente.getRua());
            txtNumero.setText(objCliente.getNumero());
            cbComboBairro.SetaComboBox(String.valueOf(objCliente.getId_bairro()));
            cbComboEstado.SetaComboBox(String.valueOf(objCliente.getId_estado()));
            cbComboCidade.SetaComboBox(String.valueOf(objCliente.getId_cidade()));
            
            
            
            
            
            
           
           
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
            java.util.logging.Logger.getLogger(CadCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBairro;
    private javax.swing.JButton addCidade;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox jComboBairro;
    private javax.swing.JComboBox jComboCidade;
    private javax.swing.JComboBox jComboEstado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtbCliente;
    private javax.swing.JLabel lblBairro;
    private javax.swing.JLabel lblCidade;
    private javax.swing.JLabel lblCpf;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblNascimento;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblNumero;
    private javax.swing.JLabel lblRua;
    private javax.swing.JLabel lblTelefone;
    private javax.swing.JFormattedTextField txtCpf;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNascimento;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtNumero;
    private javax.swing.JTextField txtRua;
    private javax.swing.JFormattedTextField txtTelefone;
    // End of variables declaration//GEN-END:variables
}

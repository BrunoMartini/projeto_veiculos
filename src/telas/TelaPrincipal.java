package telas;

import controles.RelatorioControle;
import ferramentas.CaixaDeDialogo;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.HashMap;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Jonas
 */
public class TelaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form TelaPrincipal
     */
    public TelaPrincipal() {
        initComponents();
        this.setExtendedState(TelaPrincipal.MAXIMIZED_BOTH);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        mnCadastros = new javax.swing.JMenu();
        mnBairros = new javax.swing.JMenuItem();
        mnCidades = new javax.swing.JMenuItem();
        mnUsuarios = new javax.swing.JMenuItem();
        mnVeiculos = new javax.swing.JMenuItem();
        mnMontadoras = new javax.swing.JMenuItem();
        mnVendas = new javax.swing.JMenuItem();
        mnClientes = new javax.swing.JMenuItem();
        mnDiversos = new javax.swing.JMenu();
        mnFipe = new javax.swing.JMenuItem();
        mnCalculadora = new javax.swing.JMenuItem();
        mnNotas = new javax.swing.JMenuItem();
        mnRelatorios = new javax.swing.JMenu();
        rClientes = new javax.swing.JMenuItem();
        rClientesFiltro = new javax.swing.JMenuItem();
        rVeiculos = new javax.swing.JMenuItem();
        rVeiculosFiltro = new javax.swing.JMenuItem();
        rEstoque = new javax.swing.JMenuItem();
        rVendas = new javax.swing.JMenuItem();
        mnSair = new javax.swing.JMenu();
        mnSai = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        mnCadastros.setText("Cadastros");

        mnBairros.setText("Bairros");
        mnBairros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnBairrosActionPerformed(evt);
            }
        });
        mnCadastros.add(mnBairros);

        mnCidades.setText("Cidades");
        mnCidades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnCidadesActionPerformed(evt);
            }
        });
        mnCadastros.add(mnCidades);

        mnUsuarios.setText("Usuários");
        mnUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnUsuariosActionPerformed(evt);
            }
        });
        mnCadastros.add(mnUsuarios);

        mnVeiculos.setText("Veículos");
        mnVeiculos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnVeiculosActionPerformed(evt);
            }
        });
        mnCadastros.add(mnVeiculos);

        mnMontadoras.setText("Montadoras");
        mnCadastros.add(mnMontadoras);

        mnVendas.setText("Vendas");
        mnCadastros.add(mnVendas);

        mnClientes.setText("Clientes");
        mnClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnClientesActionPerformed(evt);
            }
        });
        mnCadastros.add(mnClientes);

        jMenuBar1.add(mnCadastros);

        mnDiversos.setText("Diversos");

        mnFipe.setText("Tabela Fipe");
        mnFipe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnFipeActionPerformed(evt);
            }
        });
        mnDiversos.add(mnFipe);

        mnCalculadora.setText("Calculadora");
        mnCalculadora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnCalculadoraActionPerformed(evt);
            }
        });
        mnDiversos.add(mnCalculadora);

        mnNotas.setText("Bloco de Notas");
        mnNotas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnNotasActionPerformed(evt);
            }
        });
        mnDiversos.add(mnNotas);

        jMenuBar1.add(mnDiversos);

        mnRelatorios.setText("Relatórios");

        rClientes.setText("Clientes");
        rClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rClientesActionPerformed(evt);
            }
        });
        mnRelatorios.add(rClientes);

        rClientesFiltro.setText("Clientes - Filtro (Data Nascimento)");
        rClientesFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rClientesFiltroActionPerformed(evt);
            }
        });
        mnRelatorios.add(rClientesFiltro);

        rVeiculos.setText("Veículos");
        rVeiculos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rVeiculosActionPerformed(evt);
            }
        });
        mnRelatorios.add(rVeiculos);

        rVeiculosFiltro.setText("Veículos - Filtro (Ano)");
        rVeiculosFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rVeiculosFiltroActionPerformed(evt);
            }
        });
        mnRelatorios.add(rVeiculosFiltro);

        rEstoque.setText("Estoque");
        rEstoque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rEstoqueActionPerformed(evt);
            }
        });
        mnRelatorios.add(rEstoque);

        rVendas.setText("Vendas");
        rVendas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rVendasActionPerformed(evt);
            }
        });
        mnRelatorios.add(rVendas);

        jMenuBar1.add(mnRelatorios);

        mnSair.setText("Sair");
        mnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnSairActionPerformed(evt);
            }
        });

        mnSai.setText("Sair");
        mnSai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnSaiActionPerformed(evt);
            }
        });
        mnSair.add(mnSai);

        jMenuBar1.add(mnSair);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnBairrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnBairrosActionPerformed
        // TODO add your handling code here:
        CadBairros tela_bairros = new CadBairros();
        tela_bairros.setVisible(true);
    }//GEN-LAST:event_mnBairrosActionPerformed

    private void mnCidadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnCidadesActionPerformed
        // TODO add your handling code here:
        CadCidade tela_cidade = new CadCidade();
        tela_cidade.setVisible(true);
     
    }//GEN-LAST:event_mnCidadesActionPerformed


    private void mnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnSairActionPerformed
        
    }//GEN-LAST:event_mnSairActionPerformed

    private void mnClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnClientesActionPerformed
        CadCliente tela_cliente = new CadCliente();
        tela_cliente.setVisible(true);
    }//GEN-LAST:event_mnClientesActionPerformed

    private void mnUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnUsuariosActionPerformed
        // TODO add your handling code here:
        CadUsuarios tela_usuarios = new CadUsuarios();
        tela_usuarios.setVisible(true);
    }//GEN-LAST:event_mnUsuariosActionPerformed

    private void mnCalculadoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnCalculadoraActionPerformed
        // TODO add your handling code here:
        try {
            Runtime.getRuntime().exec("calc.exe");        
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_mnCalculadoraActionPerformed

    private void mnNotasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnNotasActionPerformed
        // TODO add your handling code here:
        try {
            Runtime.getRuntime().exec("notepad.exe");        
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_mnNotasActionPerformed

    private void mnFipeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnFipeActionPerformed
        // TODO add your handling code here:
        try { Runtime.getRuntime().exec("cmd.exe /C start " + "https://veiculos.fipe.org.br/"); 
        
        } catch (IOException ex) { System.out.println(ex.getMessage()); }
    }//GEN-LAST:event_mnFipeActionPerformed

    private void mnSaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnSaiActionPerformed
        // TODO add your handling code here:
        if (JOptionPane.showConfirmDialog(null, 
                "Tem certeza que deseja sair?", 
                "Sair", JOptionPane.YES_NO_OPTION)== 0) {
            System.exit(0);
        }
    }//GEN-LAST:event_mnSaiActionPerformed

    private void mnVeiculosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnVeiculosActionPerformed
        // TODO add your handling code here:
        CadVeiculos tela_veiculos = new CadVeiculos();
        tela_veiculos.setVisible(true);
    }//GEN-LAST:event_mnVeiculosActionPerformed

    private void rVeiculosFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rVeiculosFiltroActionPerformed
        // TODO add your handling code here:
        RelatorioVeiculos tela_veiculos = new RelatorioVeiculos();
        tela_veiculos.setVisible(true);
    }//GEN-LAST:event_rVeiculosFiltroActionPerformed

    private void rVeiculosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rVeiculosActionPerformed
        // TODO add your handling code here:
        try{
            String wSelect = " select * from veiculo a\n" +
            "INNER JOIN montadora c ON c.id_montadora = a.id_veiculo";

            RelatorioControle objRelController = new RelatorioControle();
            ResultSet resultSet = objRelController.buscarRelatorio(wSelect);//Buscar os dados do relatório

            JRResultSetDataSource relResult = new JRResultSetDataSource(resultSet);//Passa um resultSet para a fonte de dados do relatório
            JasperPrint jpPrint = JasperFillManager.fillReport("ireport/RelatorioVeiculo.jasper", new HashMap(), relResult);//Prepara o relatório para ser impresso, recebe o gerenciador JASPER
            JasperViewer jpViewer = new JasperViewer(jpPrint, false); //
            jpViewer.setVisible(true);//abre o relatório para visualização
            jpViewer.toFront();//define o form a frente da aplicação

        }catch(JRException ex){
            CaixaDeDialogo.obterinstancia().exibirMensagem("Erro: " + ex.getMessage(), 'e');
        }
    }//GEN-LAST:event_rVeiculosActionPerformed

    private void rClientesFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rClientesFiltroActionPerformed
        // TODO add your handling code here:
        RelatorioCliente tela_cliente = new RelatorioCliente();
        tela_cliente.setVisible(true);
    }//GEN-LAST:event_rClientesFiltroActionPerformed

    private void rClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rClientesActionPerformed
        // TODO add your handling code here:
        try{
            String wSelect = " SELECT c.nome as cliente,\n" +
            "to_char(dtnasc, 'dd/MM/yyyy') as dtnasc,\n" +
            "b.nome as cidade\n" +
            "FROM cliente c, cidade b\n" +
            "WHERE c.id_cidade = b.id_cidade\n" +
            "ORDER BY c.nome\n" +
            "LIMIT 10";

            RelatorioControle objRelController = new RelatorioControle();
            ResultSet resultSet = objRelController.buscarRelatorio(wSelect);//Buscar os dados do relatório

            JRResultSetDataSource relResult = new JRResultSetDataSource(resultSet);//Passa um resultSet para a fonte de dados do relatório
            JasperPrint jpPrint = JasperFillManager.fillReport("ireport/RelatorioCliente.jasper", new HashMap(), relResult);//Prepara o relatório para ser impresso, recebe o gerenciador JASPER
            JasperViewer jpViewer = new JasperViewer(jpPrint, false); //
            jpViewer.setVisible(true);//abre o relatório para visualização
            jpViewer.toFront();//define o form a frente da aplicação

        }catch(JRException ex){
            CaixaDeDialogo.obterinstancia().exibirMensagem("Erro: " + ex.getMessage(), 'e');
        }
    }//GEN-LAST:event_rClientesActionPerformed

    private void rEstoqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rEstoqueActionPerformed
        // TODO add your handling code here:
        try{
            String wSelect = " SELECT  COUNT(m.id_veiculo), SUM(m.preco)\n" +
                    "FROM veiculo m";

            RelatorioControle objRelController = new RelatorioControle();
            ResultSet resultSet = objRelController.buscarRelatorio(wSelect);//Buscar os dados do relatório

            JRResultSetDataSource relResult = new JRResultSetDataSource(resultSet);//Passa um resultSet para a fonte de dados do relatório
            JasperPrint jpPrint = JasperFillManager.fillReport("ireport/RelatorioEstoque.jasper", new HashMap(), relResult);//Prepara o relatório para ser impresso, recebe o gerenciador JASPER
            JasperViewer jpViewer = new JasperViewer(jpPrint, false); //
            jpViewer.setVisible(true);//abre o relatório para visualização
            jpViewer.toFront();//define o form a frente da aplicação

        }catch(JRException ex){
            CaixaDeDialogo.obterinstancia().exibirMensagem("Erro: " + ex.getMessage(), 'e');
        }
    }//GEN-LAST:event_rEstoqueActionPerformed

    private void rVendasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rVendasActionPerformed
        // TODO add your handling code here:
         try{
            String wSelect = " select c.id_venda, c.forma_pagamento, c.valor, d.nome,\n" +
                    "to_char(dtvenda, 'dd/MM/yyyy') as dtvenda,\n" +
                    "v.nome as veiculo\n" +
                    "FROM venda c, cliente d, veiculo v\n" +
                    "WHERE c.id_cliente = d.id_cliente\n" +
                    "AND c.id_veiculo = v.id_veiculo";

            RelatorioControle objRelController = new RelatorioControle();
            ResultSet resultSet = objRelController.buscarRelatorio(wSelect);//Buscar os dados do relatório

            JRResultSetDataSource relResult = new JRResultSetDataSource(resultSet);//Passa um resultSet para a fonte de dados do relatório
            JasperPrint jpPrint = JasperFillManager.fillReport("ireport/RelatorioVendas.jasper", new HashMap(), relResult);//Prepara o relatório para ser impresso, recebe o gerenciador JASPER
            JasperViewer jpViewer = new JasperViewer(jpPrint, false); //
            jpViewer.setVisible(true);//abre o relatório para visualização
            jpViewer.toFront();//define o form a frente da aplicação

        }catch(JRException ex){
            CaixaDeDialogo.obterinstancia().exibirMensagem("Erro: " + ex.getMessage(), 'e');
        }
    }//GEN-LAST:event_rVendasActionPerformed


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
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem mnBairros;
    private javax.swing.JMenu mnCadastros;
    private javax.swing.JMenuItem mnCalculadora;
    private javax.swing.JMenuItem mnCidades;
    private javax.swing.JMenuItem mnClientes;
    private javax.swing.JMenu mnDiversos;
    private javax.swing.JMenuItem mnFipe;
    private javax.swing.JMenuItem mnMontadoras;
    private javax.swing.JMenuItem mnNotas;
    private javax.swing.JMenu mnRelatorios;
    private javax.swing.JMenuItem mnSai;
    private javax.swing.JMenu mnSair;
    private javax.swing.JMenuItem mnUsuarios;
    private javax.swing.JMenuItem mnVeiculos;
    private javax.swing.JMenuItem mnVendas;
    private javax.swing.JMenuItem rClientes;
    private javax.swing.JMenuItem rClientesFiltro;
    private javax.swing.JMenuItem rEstoque;
    private javax.swing.JMenuItem rVeiculos;
    private javax.swing.JMenuItem rVeiculosFiltro;
    private javax.swing.JMenuItem rVendas;
    // End of variables declaration//GEN-END:variables
}

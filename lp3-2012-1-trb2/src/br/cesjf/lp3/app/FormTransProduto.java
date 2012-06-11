package br.cesjf.lp3.app;

import br.cesjf.lp3.Filial;
import br.cesjf.lp3.Produto;
import br.cesjf.lp3.db.FilialJpaController;
import br.cesjf.lp3.db.ProdutoJpaController;
import br.cesjf.lp3.db.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FormTransProduto extends javax.swing.JDialog {

    Filial filial;
    FilialJpaController filialJPA;
    Produto produto;
    ProdutoJpaController produtoJPA;

    public FormTransProduto(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);

        filial = new Filial();
        filialJPA = new FilialJpaController();

        jFilialOrigem.removeAllItems();
        jFilialDestino.removeAllItems();
        List<Filial> filiais = filialJPA.listAll();
        for (Filial fil : filiais) {
            jFilialOrigem.addItem(fil);
            jFilialDestino.addItem(fil);
        }
    }

    public void LimparCampos() {
        jID.setText("");
        jQuantidadeD.setText("");
        jQuantidadeT.setText("");
        jTipo.setText("");
//        jFilialDestino.setSelectedIndex(0);
//        jFilialOrigem.setSelectedIndex(0);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Label = new javax.swing.JLabel();
        jQuantidadeD = new javax.swing.JTextField();
        jFilialOrigem = new javax.swing.JComboBox();
        jFilialDestino = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jQuantidadeT = new javax.swing.JTextField();
        jLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProduto = new javax.swing.JTable();
        jID = new javax.swing.JTextField();
        jIdade2 = new javax.swing.JLabel();
        jTipo = new javax.swing.JTextField();
        jIdade3 = new javax.swing.JLabel();
        jTransferir = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLimpar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Transferir Produto");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Filial Origem:");

        Label.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Label.setText("Quantidade Disponível:");

        jQuantidadeD.setEditable(false);
        jQuantidadeD.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jFilialOrigem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFilialOrigemActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Filial Destino:");

        jQuantidadeT.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel.setText("Quantidade Transferir:");

        tblProduto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID Produto", "Tipo", "Quantidade"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblProduto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProdutoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblProduto);

        jID.setEditable(false);
        jID.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jIdade2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jIdade2.setText("ID Produto:");

        jTipo.setEditable(false);
        jTipo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jIdade3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jIdade3.setText("Tipo:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane1)
                    .addComponent(jFilialOrigem, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jIdade2)
                                    .addComponent(jID, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jIdade3)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(jTipo))
                                .addGap(18, 18, 18))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jFilialDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(309, 309, 309)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jQuantidadeT, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel)
                            .addComponent(Label)
                            .addComponent(jQuantidadeD, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jFilialOrigem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jIdade2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(Label)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jQuantidadeD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jIdade3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(21, 21, 21)
                            .addComponent(jFilialDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jQuantidadeT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jLabel1.getAccessibleContext().setAccessibleName("");

        jTransferir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/img_salvar.png"))); // NOI18N
        jTransferir.setText("Transferir");
        jTransferir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTransferirActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/img_sair.png"))); // NOI18N
        jButton2.setText("Sair");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        jLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/btn_apagar.png"))); // NOI18N
        jLimpar.setText("Limpar");
        jLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jLimparActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLimpar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTransferir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTransferir)
                    .addComponent(jButton2)
                    .addComponent(jLimpar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        this.setVisible(false);
    }//GEN-LAST:event_jButton2MouseClicked

private void jTransferirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTransferirActionPerformed
    Filial filialDestino;
    filialDestino = new Filial();
    Produto produtoDestino;
    produtoDestino = new Produto();
    produto = new Produto();
    produtoJPA = new ProdutoJpaController();

    if (jFilialOrigem.getSelectedItem().equals(jFilialDestino.getSelectedItem())) {
        JOptionPane.showMessageDialog(null, "A Filial de Destino Deve ser Diferente da Filial de Origem!",
                "Atenção", JOptionPane.OK_OPTION + JOptionPane.INFORMATION_MESSAGE);

    } else if (Integer.parseInt(jQuantidadeT.getText()) > Integer.parseInt(jQuantidadeD.getText())) {
        JOptionPane.showMessageDialog(null, "A Quantidade a Ser Transferida não Pode Ser Maior que a Quantidade Disponível!",
                "Atenção", JOptionPane.OK_OPTION + JOptionPane.INFORMATION_MESSAGE);

    } else if ((jID.getText().equals("")) || (jQuantidadeT.getText().equals(""))) {
        JOptionPane.showMessageDialog(null, "Selecione um Produto e Informe a Quantidade Desejada!",
                "Atenção", JOptionPane.OK_OPTION + JOptionPane.INFORMATION_MESSAGE);
    } else {

        //Debita na Filial Destino
        produto.setId(Long.parseLong(jID.getText()));
        produto.setTipo(jTipo.getText());
        filial = (Filial) jFilialOrigem.getSelectedItem();
        produto.setFilial(filial);
        produto.setQuantidade(Integer.parseInt(jQuantidadeD.getText()) - Integer.parseInt(jQuantidadeT.getText()));

        //Credita na Filial Origem        
        produtoDestino.setTipo(jTipo.getText());
        filialDestino = (Filial) jFilialDestino.getSelectedItem();
        produtoDestino.setFilial(filialDestino);
        produtoDestino.setQuantidade(Integer.parseInt(jQuantidadeT.getText()));

        try {
            produtoJPA.transferirProduto(produto, produtoDestino);
            JOptionPane.showMessageDialog(null, "Produto Transferido Com Sucesso!",
                "Atenção", JOptionPane.OK_OPTION + JOptionPane.INFORMATION_MESSAGE);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(FormTransProduto.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(FormTransProduto.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        LimparCampos();
    }
}//GEN-LAST:event_jTransferirActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
    }//GEN-LAST:event_formWindowOpened

    private void jFilialOrigemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFilialOrigemActionPerformed
        LimparCampos();
        filial = new Filial();
        filial = (Filial) jFilialOrigem.getSelectedItem();
        atualizarTblProduto(filial);
    }//GEN-LAST:event_jFilialOrigemActionPerformed

    private void tblProdutoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProdutoMouseClicked
        produto = new Produto();
        produtoJPA = new ProdutoJpaController();

        int linha = tblProduto.getSelectedRow();
        Long id = (Long) tblProduto.getModel().getValueAt(linha, 0);

        try {
            produto = produtoJPA.buscaPorID(id);
            jID.setText(String.valueOf(produto.getId()));
            jQuantidadeD.setText(String.valueOf(produto.getQuantidade()));
            jTipo.setText(produto.getTipo());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível recuperar o registro!\n" + ex.getMessage(), "Erro ao buscar o registro", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(FormCadProduto.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }
    }//GEN-LAST:event_tblProdutoMouseClicked

    private void jLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jLimparActionPerformed
        LimparCampos();
    }//GEN-LAST:event_jLimparActionPerformed
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                FormTransProduto dialog = new FormTransProduto(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {

                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Label;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox jFilialDestino;
    private javax.swing.JComboBox jFilialOrigem;
    private javax.swing.JTextField jID;
    private javax.swing.JLabel jIdade2;
    private javax.swing.JLabel jIdade3;
    private javax.swing.JLabel jLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton jLimpar;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jQuantidadeD;
    private javax.swing.JTextField jQuantidadeT;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTipo;
    private javax.swing.JButton jTransferir;
    private javax.swing.JTable tblProduto;
    // End of variables declaration//GEN-END:variables

    private void atualizarTblProduto(Filial filial) {
        produto = new Produto();
        produtoJPA = new ProdutoJpaController();


        DefaultTableModel tm = (DefaultTableModel) tblProduto.getModel();
        tm.getDataVector().removeAllElements();

        try {
            List<Produto> produtos = produtoJPA.listarPorFilial(filial.getId());
            for (Produto prod : produtos) {
                tm.addRow(new Object[]{
                            prod.getId(),
                            prod.getTipo(),
                            prod.getQuantidade()
                        });
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível listar os registros!\n" + ex.getMessage(), "Erro ao listar", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(FormCadProduto.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }
    }
}

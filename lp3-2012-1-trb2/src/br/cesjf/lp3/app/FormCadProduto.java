package br.cesjf.lp3.app;

import br.cesjf.lp3.Filial;
import br.cesjf.lp3.Produto;
import br.cesjf.lp3.db.FilialJpaController;
import br.cesjf.lp3.db.ProdutoJpaController;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FormCadProduto extends javax.swing.JDialog {

    Filial filial;
    FilialJpaController filialJPA;
    Produto produto;
    ProdutoJpaController produtoJPA;

    public FormCadProduto(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);

        filial = new Filial();
        filialJPA = new FilialJpaController();

        cmbFilial.removeAllItems();
        List<Filial> filiais = filialJPA.listAll();
        for (Filial fil : filiais) {
            cmbFilial.addItem(fil);
        }
    }

    public void LimparCampos() {
        jTipo.setText("");
        jQuantidade.setText("");
        jID.setText("");
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTipo = new javax.swing.JTextField();
        jNome = new javax.swing.JLabel();
        jQuantidade = new javax.swing.JTextField();
        jID = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cmbFilial = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jGravar = new javax.swing.JButton();
        jSair = new javax.swing.JButton();
        jExcluir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProduto = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLimpar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro");

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Tipo:");

        jTipo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jNome.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jNome.setText("Quantidade:");

        jQuantidade.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jQuantidade.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jQuantidadeFocusLost(evt);
            }
        });

        jID.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jID.setEnabled(false);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("ID:");

        cmbFilial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbFilialActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Filial:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jID)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jNome)
                        .addComponent(jTipo)
                        .addComponent(jQuantidade, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cmbFilial, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cmbFilial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jNome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        jLabel1.getAccessibleContext().setAccessibleName("");

        jGravar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/img_salvar.png"))); // NOI18N
        jGravar.setText("Gravar");
        jGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jGravarActionPerformed(evt);
            }
        });

        jSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/img_sair.png"))); // NOI18N
        jSair.setText("Sair");
        jSair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jSairMouseClicked(evt);
            }
        });

        jExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/excluir.png"))); // NOI18N
        jExcluir.setText("Excluir");
        jExcluir.setEnabled(false);
        jExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jExcluirActionPerformed(evt);
            }
        });

        tblProduto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID Filial", "Cidade/Bairro", "ID Produto", "Tipo", "Quantidade"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblProduto.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblProduto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProdutoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblProduto);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 204, 204));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/tela_cliente.jpg"))); // NOI18N
        jLabel2.setText("             Cadastro");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/btn_apagar.png"))); // NOI18N
        jLimpar.setText("  Limpar");
        jLimpar.setPreferredSize(new java.awt.Dimension(93, 31));
        jLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jLimparActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 607, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jExcluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jGravar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSair, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jExcluir)
                    .addComponent(jGravar)
                    .addComponent(jSair)
                    .addComponent(jLimpar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jSairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSairMouseClicked
        this.setVisible(false);
    }//GEN-LAST:event_jSairMouseClicked

private void jGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jGravarActionPerformed
    produto = new Produto();
    produtoJPA = new ProdutoJpaController();

    if ((jTipo.getText().equals("")) || (jQuantidade.getText().equals(""))) {

        JOptionPane.showMessageDialog(null, "Preenchimento obrigatório de todos os campos!",
                "Atenção", JOptionPane.OK_OPTION + JOptionPane.INFORMATION_MESSAGE);
    } else {

        filial = (Filial) cmbFilial.getSelectedItem();
        produto.setTipo(jTipo.getText());
        produto.setQuantidade(Integer.parseInt(jQuantidade.getText()));
        produto.setFilial(filial);
        try {
            if (jID.getText().equals("")) {
                produtoJPA.create(produto);
                JOptionPane.showMessageDialog(null, "Produto Cadastrado Com Sucesso!",
                        "Atenção", JOptionPane.OK_OPTION + JOptionPane.INFORMATION_MESSAGE);
            } else {
                produto.setId(Long.parseLong(jID.getText()));
                produtoJPA.edit(produto);
                JOptionPane.showMessageDialog(null, "Produto Alterado Com Sucesso!",
                        "Atenção", JOptionPane.OK_OPTION + JOptionPane.INFORMATION_MESSAGE);
            }
            LimparCampos();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Não é possível cadastrar a Filial!\n" + ex.getMessage(), "Erro ao cadastrar Filial", JOptionPane.ERROR_MESSAGE);
        }
    }

    jExcluir.setEnabled(false);
}//GEN-LAST:event_jGravarActionPerformed

    private void jExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jExcluirActionPerformed
//        filial = new Filial();
//        filialJPA = new FilialJpaController();
//
//        try {
//            filialJPA.excluir(Long.parseLong(jID.getText()));
//            JOptionPane.showMessageDialog(null, "Filial Excluída Com Sucesso!",
//                    "Atenção", JOptionPane.OK_OPTION + JOptionPane.INFORMATION_MESSAGE);
//            LimparCampos();
//        } catch (Exception ex) {
//            JOptionPane.showMessageDialog(null, "Não é possível excluir o Produto!\n" + ex.getMessage(), "Erro ao excluir Produto", JOptionPane.ERROR_MESSAGE);
//        }
//
//        jExcluir.setEnabled(false);
//        atualizarTblProduto();
    }//GEN-LAST:event_jExcluirActionPerformed

    private void jQuantidadeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jQuantidadeFocusLost
    }//GEN-LAST:event_jQuantidadeFocusLost

    private void tblProdutoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProdutoMouseClicked
//        produto = new Produto();
//        produtoJPA = new ProdutoJpaController();
//
//        int linha = tblProduto.getSelectedRow();
//        Long id = (Long) tblProduto.getModel().getValueAt(linha, 0);
//
//        try {
//            filial = filialJPA.buscaPorId(id);
//            jID.setText(String.valueOf(filial.getId()));
//            jCidade.setText(filial.getCidade());
//            jBairro.setText(filial.getBairro());
//        } catch (Exception ex) {
//            JOptionPane.showMessageDialog(null, "Não foi possível recuperar o registro!\n" + ex.getMessage(), "Erro ao buscar o registro", JOptionPane.ERROR_MESSAGE);
//            Logger.getLogger(FormCadProduto.class.getName()).log(Level.SEVERE, null, ex);
//            return;
//        }
//
//        jExcluir.setEnabled(true);
    }//GEN-LAST:event_tblProdutoMouseClicked

    private void jLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jLimparActionPerformed
        LimparCampos();
        jExcluir.setEnabled(false);
    }//GEN-LAST:event_jLimparActionPerformed

    private void cmbFilialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbFilialActionPerformed
        filial = new Filial();
        filial = (Filial) cmbFilial.getSelectedItem();
        atualizarTblProduto(filial);
    }//GEN-LAST:event_cmbFilialActionPerformed
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                FormCadProduto dialog = new FormCadProduto(new javax.swing.JFrame(), true);
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
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox cmbFilial;
    private javax.swing.JButton jExcluir;
    private javax.swing.JButton jGravar;
    private javax.swing.JTextField jID;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JButton jLimpar;
    private javax.swing.JLabel jNome;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField jQuantidade;
    private javax.swing.JButton jSair;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTipo;
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
                            filial.getId(),
                            filial.toString(),
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

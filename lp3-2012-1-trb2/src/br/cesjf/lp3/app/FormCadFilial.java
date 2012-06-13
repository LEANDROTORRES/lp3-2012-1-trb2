package br.cesjf.lp3.app;

import br.cesjf.lp3.Filial;
import br.cesjf.lp3.db.FilialJpaController;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FormCadFilial extends javax.swing.JDialog {

    Filial filial;
    FilialJpaController filialJPA;

    public FormCadFilial(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);        
        atualizarTblFilial();
    }

    public void LimparCampos() {
        jCidade.setText("");
        jBairro.setText("");
        jID.setText("");
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jCidade = new javax.swing.JTextField();
        jNome = new javax.swing.JLabel();
        jBairro = new javax.swing.JTextField();
        jID = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jGravar = new javax.swing.JButton();
        jSair = new javax.swing.JButton();
        jExcluir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblFilial = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLimpar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Filial");

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Cidade:");

        jCidade.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jNome.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jNome.setText("Bairro:");

        jBairro.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jBairro.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jBairroFocusLost(evt);
            }
        });

        jID.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jID.setEnabled(false);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("ID:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jID)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jNome)
                        .addComponent(jCidade)
                        .addComponent(jBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jNome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
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

        tblFilial.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Cidade", "Bairro"
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
        tblFilial.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblFilial.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblFilialMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblFilial);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 204, 204));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/tela_cliente.jpg"))); // NOI18N
        jLabel2.setText("  Cadastro de Filial");

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
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jExcluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLimpar)
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLimpar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jExcluir)
                        .addComponent(jGravar)
                        .addComponent(jSair)))
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

    filial = new Filial();
    filialJPA = new FilialJpaController();
    if ((jCidade.getText().equals("")) || (jBairro.getText().equals(""))) {

        JOptionPane.showMessageDialog(null, "Preenchimento obrigatório de todos os campos!",
                "Atenção", JOptionPane.OK_OPTION + JOptionPane.INFORMATION_MESSAGE);
    } else {

        filial.setCidade(jCidade.getText());
        filial.setBairro(jBairro.getText());
        try {

            if (jID.getText().equals("")) {
                filialJPA.create(filial);
                JOptionPane.showMessageDialog(null, "Filial Cadastrada Com Sucesso!",
                        "Atenção", JOptionPane.OK_OPTION + JOptionPane.INFORMATION_MESSAGE);
            } else {
                filial.setId(Long.parseLong(jID.getText()));
                filialJPA.edit(filial);
                JOptionPane.showMessageDialog(null, "Filial Alterada Com Sucesso!",
                        "Atenção", JOptionPane.OK_OPTION + JOptionPane.INFORMATION_MESSAGE);
            }
            LimparCampos();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Não é possível cadastrar a Filial!\n" + ex.getMessage(), "Erro ao cadastrar Filial", JOptionPane.ERROR_MESSAGE);
        }
    }

    jExcluir.setEnabled(false);
    atualizarTblFilial();
}//GEN-LAST:event_jGravarActionPerformed

    private void jExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jExcluirActionPerformed
        filial = new Filial();
        filialJPA = new FilialJpaController();

        try {
            filialJPA.excluir(Long.parseLong(jID.getText()));
            JOptionPane.showMessageDialog(null, "Filial Excluída Com Sucesso!",
                    "Atenção", JOptionPane.OK_OPTION + JOptionPane.INFORMATION_MESSAGE);
            LimparCampos();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Não é possível excluir o Produto!\n" + ex.getMessage(), "Erro ao excluir Produto", JOptionPane.ERROR_MESSAGE);
        }

        jExcluir.setEnabled(false);
        atualizarTblFilial();
    }//GEN-LAST:event_jExcluirActionPerformed

    private void jBairroFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jBairroFocusLost
    }//GEN-LAST:event_jBairroFocusLost

    private void tblFilialMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblFilialMouseClicked
        filial = new Filial();
        filialJPA = new FilialJpaController();

        int linha = tblFilial.getSelectedRow();
        Long id = (Long) tblFilial.getModel().getValueAt(linha, 0);

        try {
            filial = filialJPA.buscaPorId(id);
            jID.setText(String.valueOf(filial.getId()));
            jCidade.setText(filial.getCidade());
            jBairro.setText(filial.getBairro());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível recuperar o registro!\n" + ex.getMessage(), "Erro ao buscar o registro", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(FormCadFilial.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }

        jExcluir.setEnabled(true);
    }//GEN-LAST:event_tblFilialMouseClicked

    private void jLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jLimparActionPerformed
        LimparCampos();
        jExcluir.setEnabled(false);
    }//GEN-LAST:event_jLimparActionPerformed
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                FormCadFilial dialog = new FormCadFilial(new javax.swing.JFrame(), true);
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
    private javax.swing.JTextField jBairro;
    private javax.swing.JTextField jCidade;
    private javax.swing.JButton jExcluir;
    private javax.swing.JButton jGravar;
    private javax.swing.JTextField jID;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton jLimpar;
    private javax.swing.JLabel jNome;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JButton jSair;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblFilial;
    // End of variables declaration//GEN-END:variables

    private void atualizarTblFilial() {
        filial = new Filial();
        filialJPA = new FilialJpaController();
        
        DefaultTableModel tm = (DefaultTableModel) tblFilial.getModel();
        tm.getDataVector().removeAllElements();

        try {
            List<Filial> filiais = filialJPA.listAll();
            for (Filial fil : filiais) {
                tm.addRow(new Object[]{
                            fil.getId(),
                            fil.getCidade(),
                            fil.getBairro()
                        });
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível listar os registros!\n" + ex.getMessage(), "Erro ao listar", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(FormCadFilial.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }

    }
}

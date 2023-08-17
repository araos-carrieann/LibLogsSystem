/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.mycompany.finallibrarysystem;

import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author araos
 */
public class ComboBoxContentYearLevel extends javax.swing.JDialog {

    /**
     * Creates new form ComboBoxContentYearLevel
     */
    public ComboBoxContentYearLevel(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        displayYearLvl();
        lblWarningMessage.setVisible(false);
    }

    private void displayYearLvl() {
        DefaultTableModel allYrLvl = (DefaultTableModel) yrLvlTable.getModel();
        allYrLvl.setRowCount(0);

        List<librarysystem.AccountDTO> yearLevelList = librarysystem.LibraryMethods.yearlvlComboContent();

        for (librarysystem.AccountDTO yearLevel : yearLevelList) {
            Object[] yearLvlRow = {yearLevel.getYrlvl()};
            allYrLvl.addRow(yearLvlRow);
        }
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelGradient1 = new com.mycompany.finallibrarysystem.Design.PanelGradient();
        jScrollPane2 = new javax.swing.JScrollPane();
        yrLvlTable = new javax.swing.JTable();
        txtAddYrLvl = new javax.swing.JTextField();
        btnAddYrLvl = new javax.swing.JButton();
        btnDeleteYrLvl = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        lblWarningMessage = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        yrLvlTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "YEAR LEVEL"
            }
        ));
        jScrollPane2.setViewportView(yrLvlTable);

        panelGradient1.add(jScrollPane2);
        jScrollPane2.setBounds(50, 140, 250, 190);

        txtAddYrLvl.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtAddYrLvl.setBorder(null);
        txtAddYrLvl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAddYrLvlActionPerformed(evt);
            }
        });
        panelGradient1.add(txtAddYrLvl);
        txtAddYrLvl.setBounds(140, 50, 64, 16);

        btnAddYrLvl.setBackground(new java.awt.Color(204, 255, 204));
        btnAddYrLvl.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAddYrLvl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add_icon.png"))); // NOI18N
        btnAddYrLvl.setText("ADD");
        btnAddYrLvl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddYrLvlActionPerformed(evt);
            }
        });
        panelGradient1.add(btnAddYrLvl);
        btnAddYrLvl.setBounds(60, 100, 80, 27);

        btnDeleteYrLvl.setBackground(new java.awt.Color(255, 51, 51));
        btnDeleteYrLvl.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnDeleteYrLvl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/delete_icon.png"))); // NOI18N
        btnDeleteYrLvl.setText("DELETE");
        btnDeleteYrLvl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteYrLvlActionPerformed(evt);
            }
        });
        panelGradient1.add(btnDeleteYrLvl);
        btnDeleteYrLvl.setBounds(210, 100, 94, 27);

        btnBack.setBackground(new java.awt.Color(255, 255, 204));
        btnBack.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnBack.setText("BACK");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        panelGradient1.add(btnBack);
        btnBack.setBounds(10, 400, 72, 23);

        lblWarningMessage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblWarningMessage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/warningmsg_icon.png"))); // NOI18N
        lblWarningMessage.setText("jLabel1");
        panelGradient1.add(lblWarningMessage);
        lblWarningMessage.setBounds(50, 350, 250, 24);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("YEAR LEVEL");
        panelGradient1.add(jLabel2);
        jLabel2.setBounds(110, 20, 101, 25);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelGradient1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelGradient1, javax.swing.GroupLayout.DEFAULT_SIZE, 431, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtAddYrLvlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAddYrLvlActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAddYrLvlActionPerformed

    private void btnAddYrLvlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddYrLvlActionPerformed
        String addYrLvl = txtAddYrLvl.getText();
        if (addYrLvl.isEmpty()) {
            lblWarningMessage.setVisible(true);
            lblWarningMessage.setText("Please input appropriate year level.");
        } else {
            LibraryMethods.yearLevelComboBox(addYrLvl);
            displayYearLvl();
            txtAddYrLvl.setText("");
            lblWarningMessage.setVisible(false);
        }
    }//GEN-LAST:event_btnAddYrLvlActionPerformed

    private void btnDeleteYrLvlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteYrLvlActionPerformed
        DefaultTableModel model = (DefaultTableModel) yrLvlTable.getModel();
        int selectedRow = yrLvlTable.getSelectedRow();
        if (selectedRow != 1) {
            String yrLvl = (String) model.getValueAt(selectedRow, 0);
            model.removeRow(selectedRow);
            LibraryMethods.deleteYearLvl(yrLvl);
            displayYearLvl();
            lblWarningMessage.setVisible(false);
        }
    }//GEN-LAST:event_btnDeleteYrLvlActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        dispose();
    }//GEN-LAST:event_btnBackActionPerformed

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
            java.util.logging.Logger.getLogger(ComboBoxContentYearLevel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ComboBoxContentYearLevel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ComboBoxContentYearLevel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ComboBoxContentYearLevel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ComboBoxContentYearLevel dialog = new ComboBoxContentYearLevel(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddYrLvl;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnDeleteYrLvl;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblWarningMessage;
    private com.mycompany.finallibrarysystem.Design.PanelGradient panelGradient1;
    private javax.swing.JTextField txtAddYrLvl;
    private javax.swing.JTable yrLvlTable;
    // End of variables declaration//GEN-END:variables
}

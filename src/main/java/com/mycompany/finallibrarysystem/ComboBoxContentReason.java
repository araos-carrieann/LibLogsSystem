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
public class ComboBoxContentReason extends javax.swing.JDialog {

    /**
     * Creates new form Program
     */
    public ComboBoxContentReason(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        displayReason();
        lblWarningMessage.setVisible(false);
    }

    // Display the reason options in the reason table
    private void displayReason() {
        // Get the DefaultTableModel associated with the reasonTable
        DefaultTableModel reasonTableModel = (DefaultTableModel) reasonTable.getModel();

        // Clear all existing rows from the table
        reasonTableModel.setRowCount(0);

        // Retrieve the list of reason options from the database
        List<AccountsDTO> reasonList = LibraryMethods.reasonComboContent();

        // Iterate through the list and add each reason option to the table
        for (AccountsDTO reason : reasonList) {
            // Create an array containing the reason option to add to the table
            Object[] reasonRow = {reason.getReason()};
            // Add the reason option to the table's model
            reasonTableModel.addRow(reasonRow);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelGradient1 = new com.mycompany.finallibrarysystem.Design.PanelGradient();
        jScrollPane1 = new javax.swing.JScrollPane();
        reasonTable = new javax.swing.JTable();
        txtAddReason = new javax.swing.JTextField();
        btnAddReason = new javax.swing.JButton();
        btnDeleteReason = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        lblWarningMessage = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        panelGradient1.setColorPrimary(new java.awt.Color(255, 255, 51));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 204));

        reasonTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "REASON"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        reasonTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                reasonTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(reasonTable);
        if (reasonTable.getColumnModel().getColumnCount() > 0) {
            reasonTable.getColumnModel().getColumn(0).setResizable(false);
        }

        panelGradient1.add(jScrollPane1);
        jScrollPane1.setBounds(40, 150, 280, 180);

        txtAddReason.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtAddReason.setBorder(null);
        txtAddReason.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAddReasonActionPerformed(evt);
            }
        });
        panelGradient1.add(txtAddReason);
        txtAddReason.setBounds(70, 60, 210, 30);

        btnAddReason.setBackground(new java.awt.Color(204, 255, 204));
        btnAddReason.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAddReason.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add_icon.png"))); // NOI18N
        btnAddReason.setText("ADD");
        btnAddReason.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddReasonActionPerformed(evt);
            }
        });
        panelGradient1.add(btnAddReason);
        btnAddReason.setBounds(40, 110, 100, 27);

        btnDeleteReason.setBackground(new java.awt.Color(255, 51, 51));
        btnDeleteReason.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnDeleteReason.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/delete_icon.png"))); // NOI18N
        btnDeleteReason.setText("DELETE");
        btnDeleteReason.setEnabled(false);
        btnDeleteReason.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteReasonActionPerformed(evt);
            }
        });
        panelGradient1.add(btnDeleteReason);
        btnDeleteReason.setBounds(210, 110, 110, 27);

        btnBack.setBackground(new java.awt.Color(255, 255, 204));
        btnBack.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnBack.setText("BACK");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        panelGradient1.add(btnBack);
        btnBack.setBounds(10, 370, 72, 23);

        lblWarningMessage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblWarningMessage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/warningmsg_icon.png"))); // NOI18N
        lblWarningMessage.setText("jLabel1");
        panelGradient1.add(lblWarningMessage);
        lblWarningMessage.setBounds(35, 340, 280, 24);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("REASON");
        panelGradient1.add(jLabel1);
        jLabel1.setBounds(130, 20, 73, 25);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelGradient1, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelGradient1, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtAddReasonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAddReasonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAddReasonActionPerformed

    private void btnAddReasonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddReasonActionPerformed
        String addReason = txtAddReason.getText();
        if (addReason.isEmpty()) {
            lblWarningMessage.setVisible(true);
            lblWarningMessage.setText("Please Input Appropriate Reason.");
        } else {
            if (LibraryMethods.addReasonComboBox(addReason)) {
                displayReason();
                txtAddReason.setText("");
                lblWarningMessage.setVisible(false);
            } else {
                lblWarningMessage.setVisible(true);
                lblWarningMessage.setText("This Reason Already Exist");
            }
        }
    }//GEN-LAST:event_btnAddReasonActionPerformed

    private void btnDeleteReasonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteReasonActionPerformed
        DefaultTableModel model = (DefaultTableModel) reasonTable.getModel();
        int selectedRow = reasonTable.getSelectedRow();
        if (selectedRow != 0) {
            String reason = (String) model.getValueAt(selectedRow, 0);
            model.removeRow(selectedRow);
            LibraryMethods.deleteReason(reason);
            displayReason();
            lblWarningMessage.setVisible(false);
            btnDeleteReason.setEnabled(false);
        }
    }//GEN-LAST:event_btnDeleteReasonActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private void reasonTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reasonTableMouseClicked
        btnDeleteReason.setEnabled(true);
    }//GEN-LAST:event_reasonTableMouseClicked

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
            java.util.logging.Logger.getLogger(ComboBoxContentReason.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ComboBoxContentReason.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ComboBoxContentReason.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ComboBoxContentReason.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ComboBoxContentReason dialog = new ComboBoxContentReason(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnAddReason;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnDeleteReason;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblWarningMessage;
    private com.mycompany.finallibrarysystem.Design.PanelGradient panelGradient1;
    private javax.swing.JTable reasonTable;
    private javax.swing.JTextField txtAddReason;
    // End of variables declaration//GEN-END:variables
}

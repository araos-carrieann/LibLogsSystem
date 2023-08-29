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
public class ComboBoxContentProgram extends javax.swing.JDialog {

    /**
     * Creates new form Program
     */
    public ComboBoxContentProgram(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        displayProgram();
        lblWarningMessage.setVisible(false);
    }

    private void displayProgram() {
        DefaultTableModel allProgram = (DefaultTableModel) programTable.getModel();
        allProgram.setRowCount(0);

        List<AccountsDTO> programList = LibraryMethods.programComboContent();

        for (AccountsDTO program : programList) {
            Object[] programRow = {program.getProgram()};
            allProgram.addRow(programRow);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelGradient1 = new com.mycompany.finallibrarysystem.Design.PanelGradient();
        jScrollPane1 = new javax.swing.JScrollPane();
        programTable = new javax.swing.JTable();
        txtAddProgram = new javax.swing.JTextField();
        btnAddProgram = new javax.swing.JButton();
        btnDeleteProgram = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        lblWarningMessage = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        panelGradient1.setColorPrimary(new java.awt.Color(255, 255, 51));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 204));

        programTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "PROGRAM"
            }
        ));
        programTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                programTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(programTable);

        panelGradient1.add(jScrollPane1);
        jScrollPane1.setBounds(40, 150, 280, 180);

        txtAddProgram.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtAddProgram.setBorder(null);
        txtAddProgram.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAddProgramActionPerformed(evt);
            }
        });
        panelGradient1.add(txtAddProgram);
        txtAddProgram.setBounds(70, 60, 210, 30);

        btnAddProgram.setBackground(new java.awt.Color(204, 255, 204));
        btnAddProgram.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAddProgram.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add_icon.png"))); // NOI18N
        btnAddProgram.setText("ADD");
        btnAddProgram.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddProgramActionPerformed(evt);
            }
        });
        panelGradient1.add(btnAddProgram);
        btnAddProgram.setBounds(40, 110, 100, 27);

        btnDeleteProgram.setBackground(new java.awt.Color(255, 51, 51));
        btnDeleteProgram.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnDeleteProgram.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/delete_icon.png"))); // NOI18N
        btnDeleteProgram.setText("DELETE");
        btnDeleteProgram.setEnabled(false);
        btnDeleteProgram.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteProgramActionPerformed(evt);
            }
        });
        panelGradient1.add(btnDeleteProgram);
        btnDeleteProgram.setBounds(210, 110, 110, 27);

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
        jLabel1.setText("PROGRAM");
        panelGradient1.add(jLabel1);
        jLabel1.setBounds(130, 20, 92, 25);

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

    private void txtAddProgramActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAddProgramActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAddProgramActionPerformed

    private void btnAddProgramActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddProgramActionPerformed
        String addProgram = txtAddProgram.getText();
        if (addProgram.isEmpty()) {
            lblWarningMessage.setVisible(true);
            lblWarningMessage.setText("Please Input Appropriate Program.");
        } else {
            if (LibraryMethods.addProgramComboBox(addProgram)) {
                System.out.println("HI");
                displayProgram();
                txtAddProgram.setText("");
                lblWarningMessage.setVisible(false);
            }else{
                lblWarningMessage.setVisible(true);
                lblWarningMessage.setText("This Program Already Exist");
            }
        }
    }//GEN-LAST:event_btnAddProgramActionPerformed

    private void btnDeleteProgramActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteProgramActionPerformed
        DefaultTableModel model = (DefaultTableModel) programTable.getModel();
        int selectedRow = programTable.getSelectedRow();
        if (selectedRow != 0) {
            String program = (String) model.getValueAt(selectedRow, 0);
            model.removeRow(selectedRow);
            LibraryMethods.deleteProgram(program);
            displayProgram();
            lblWarningMessage.setVisible(false);
            btnDeleteProgram.setEnabled(false);
        }
    }//GEN-LAST:event_btnDeleteProgramActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private void programTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_programTableMouseClicked
        btnDeleteProgram.setEnabled(true);
    }//GEN-LAST:event_programTableMouseClicked

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
            java.util.logging.Logger.getLogger(ComboBoxContentProgram.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ComboBoxContentProgram.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ComboBoxContentProgram.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ComboBoxContentProgram.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ComboBoxContentProgram dialog = new ComboBoxContentProgram(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnAddProgram;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnDeleteProgram;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblWarningMessage;
    private com.mycompany.finallibrarysystem.Design.PanelGradient panelGradient1;
    private javax.swing.JTable programTable;
    private javax.swing.JTextField txtAddProgram;
    // End of variables declaration//GEN-END:variables
}

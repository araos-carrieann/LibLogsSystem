/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.mycompany.finallibrarysystem;

import java.util.List;

/**
 *
 * @author araos
 */
public class AddAccount extends javax.swing.JDialog {

    /**
     * Creates new form Add
     */
    public AddAccount(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        lblWarningMsg.setVisible(false);
        comboProgram.setVisible(false);
        comboYrLvl.setVisible(false);
        insertContentComboProgram();
        insertContentComboYearLvl();

    }

    private void insertContentComboProgram() {
        List<AccountsDTO> programList = LibraryMethods.programComboContent();
        comboProgram.removeAllItems(); // Clear existing items

        for (AccountsDTO data : programList) {
            comboProgram.addItem(data.getProgram());
        }
    }

    private void insertContentComboYearLvl() {
        List<AccountsDTO> yrLvlList = LibraryMethods.yearlvlComboContent();
        comboYrLvl.removeAllItems(); // Clear existing items

        for (AccountsDTO data : yrLvlList) {
            comboYrLvl.addItem(data.getYrlvl());
        }
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtEmail = new javax.swing.JTextField();
        comboProgram = new javax.swing.JComboBox<>();
        comboYrLvl = new javax.swing.JComboBox<>();
        rbtnStudent = new javax.swing.JRadioButton();
        rbtnFaculty = new javax.swing.JRadioButton();
        btnClear = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        lblWarningMsg = new javax.swing.JLabel();
        txtStudentFacultyID = new javax.swing.JTextField();
        txtFname = new javax.swing.JTextField();
        txtLname = new javax.swing.JTextField();
        lblUserID = new javax.swing.JLabel();
        lblUsername = new javax.swing.JLabel();
        lblUserEmail = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtEmail.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtEmail.setBorder(new javax.swing.border.MatteBorder(null));
        txtEmail.setMinimumSize(new java.awt.Dimension(65, 40));
        txtEmail.setPreferredSize(new java.awt.Dimension(65, 40));
        jPanel1.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(53, 136, 290, -1));

        comboProgram.setBackground(new java.awt.Color(255, 255, 204));
        comboProgram.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel1.add(comboProgram, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 234, 140, 30));

        comboYrLvl.setBackground(new java.awt.Color(255, 255, 204));
        comboYrLvl.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        comboYrLvl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboYrLvlActionPerformed(evt);
            }
        });
        jPanel1.add(comboYrLvl, new org.netbeans.lib.awtextra.AbsoluteConstraints(193, 234, 150, 30));

        rbtnStudent.setText("STUDENT");
        rbtnStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnStudentActionPerformed(evt);
            }
        });
        jPanel1.add(rbtnStudent, new org.netbeans.lib.awtextra.AbsoluteConstraints(63, 194, -1, 30));

        rbtnFaculty.setText("FACULTY");
        rbtnFaculty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnFacultyActionPerformed(evt);
            }
        });
        jPanel1.add(rbtnFaculty, new org.netbeans.lib.awtextra.AbsoluteConstraints(203, 194, -1, 30));

        btnClear.setText("CLEAR");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });
        jPanel1.add(btnClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(83, 337, 180, 30));

        btnSave.setText("SAVE");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        jPanel1.add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 297, 280, 30));

        btnBack.setText("BACK");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        jPanel1.add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(253, 407, 90, -1));

        lblWarningMsg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblWarningMsg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/warningmsg_icon.png"))); // NOI18N
        lblWarningMsg.setText("jLabel1");
        jPanel1.add(lblWarningMsg, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 377, 290, -1));

        txtStudentFacultyID.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtStudentFacultyID.setBorder(new javax.swing.border.MatteBorder(null));
        txtStudentFacultyID.setMinimumSize(new java.awt.Dimension(65, 40));
        txtStudentFacultyID.setPreferredSize(new java.awt.Dimension(65, 40));
        jPanel1.add(txtStudentFacultyID, new org.netbeans.lib.awtextra.AbsoluteConstraints(53, 6, 290, -1));

        txtFname.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtFname.setBorder(new javax.swing.border.MatteBorder(null));
        jPanel1.add(txtFname, new org.netbeans.lib.awtextra.AbsoluteConstraints(53, 66, 130, 40));

        txtLname.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtLname.setBorder(new javax.swing.border.MatteBorder(null));
        txtLname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLnameActionPerformed(evt);
            }
        });
        jPanel1.add(txtLname, new org.netbeans.lib.awtextra.AbsoluteConstraints(203, 66, 140, 40));

        lblUserID.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUserID.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/id_iconBig.png"))); // NOI18N
        jPanel1.add(lblUserID, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        lblUsername.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/frontuser_icon.png"))); // NOI18N
        jPanel1.add(lblUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        lblUserEmail.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/email_icon.png"))); // NOI18N
        jPanel1.add(lblUserEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboYrLvlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboYrLvlActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboYrLvlActionPerformed

    private void rbtnStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnStudentActionPerformed
        comboProgram.setVisible(true);
        comboYrLvl.setVisible(true);
    }//GEN-LAST:event_rbtnStudentActionPerformed

    private void rbtnFacultyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnFacultyActionPerformed
        comboProgram.setVisible(false);
        comboYrLvl.setVisible(false);
    }//GEN-LAST:event_rbtnFacultyActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        txtStudentFacultyID.setText("");
        txtFname.setText("");
        txtLname.setText("");
        txtEmail.setText("");
        rbtnStudent.setSelected(false);
        rbtnFaculty.setSelected(false);
        //combo box set the selected in index zero
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        status = "ACTIVE";
        role = null;
        stuFaculID = txtStudentFacultyID.getText();
        fname = txtFname.getText();
        lname = txtLname.getText();
        email = txtEmail.getText();
        program = (String) comboProgram.getSelectedItem();
        yearLevel = (String) comboYrLvl.getSelectedItem();

        lblWarningMsg.setVisible(true);
        if (stuFaculID.isEmpty() && fname.isEmpty() && lname.isEmpty() && email.isEmpty() && !rbtnStudent.isSelected() && !rbtnFaculty.isSelected()) {
            lblWarningMsg.setText("Please input all required fields.");
        } else if (stuFaculID.isEmpty()) {
            lblWarningMsg.setText("Please Specify your ID");
        } else if (fname.isEmpty() || lname.isEmpty()) {
            lblWarningMsg.setText("Please specify your name.");
        } else if (email.isEmpty()) {
            lblWarningMsg.setText("Please input your email.");
        } else if (!fname.matches("[A-Za-z0-9\\-. ]+")) {
            lblWarningMsg.setText("Name should only consist of letters, numbers, dashes, dots, or spaces.");
        } else if (!email.matches("[\\w.-]+@[a-zA-Z0-9-]+\\.[a-zA-Z]{2,}")) {
            lblWarningMsg.setText("Invalid email address format.");
        } else {
            if (rbtnStudent.isSelected()) {
                role = rbtnStudent.getText();
                if (program.equals("DEFAULT") || yearLevel.equals("DEFAULT")) {
                    lblWarningMsg.setText("Please specify your program/year level.");
                } else {
                    lblWarningMsg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-verified-24.png")));
                    boolean success = LibraryMethods.registerUser(status, role, stuFaculID, fname, lname, email, program, yearLevel);
                    if (success) {
                        lblWarningMsg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-verified-24.png")));
                        lblWarningMsg.setText("User registered successfully.");
                    } else {
                        lblWarningMsg.setText("User registration failed. Account already exists.");
                        System.out.println("failed");
                    }
                }
            }
            if (rbtnFaculty.isSelected()) {
                role = rbtnFaculty.getText();
                program = null;
                yearLevel = null;
                lblWarningMsg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-verified-24.png")));
                boolean success = LibraryMethods.registerUser(status, role, stuFaculID, fname, lname, email, program, yearLevel);
                if (success) {
                    lblWarningMsg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/successfulmsg_icon.png")));
                    lblWarningMsg.setText("User registered successfully.");
                } else {
                    lblWarningMsg.setText("User registration failed. Account already exists.");
                    System.out.println("failed");
                }
            }

        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private void txtLnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLnameActionPerformed

  
    private String stuFaculID, status, fname, lname, role, email, program, yearLevel;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> comboProgram;
    private javax.swing.JComboBox<String> comboYrLvl;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblUserEmail;
    private javax.swing.JLabel lblUserID;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JLabel lblWarningMsg;
    private javax.swing.JRadioButton rbtnFaculty;
    private javax.swing.JRadioButton rbtnStudent;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFname;
    private javax.swing.JTextField txtLname;
    private javax.swing.JTextField txtStudentFacultyID;
    // End of variables declaration//GEN-END:variables
}

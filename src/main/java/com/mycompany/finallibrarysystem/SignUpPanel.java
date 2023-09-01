/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.finallibrarysystem;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.List;

/**
 *
 * @author araos
 */
public class SignUpPanel extends javax.swing.JPanel {

    /**
     * Creates new form SignUpPanel
     */
    public SignUpPanel() {
        initComponents();
        lblWarningMsg.setVisible(false);
        comboProgram.setVisible(false);
        comboYrLvl.setVisible(false);
        insertContentComboProgram();
        insertContentComboYearLvl();
    }

    public void addEventBackLogin(ActionListener event) {
        btnBackToLogin.addActionListener(event);
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

        btnGrp = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        btnClear = new javax.swing.JButton();
        btnSignIn = new javax.swing.JButton();
        btnBackToLogin = new javax.swing.JButton();
        txtFirstName = new javax.swing.JTextField();
        txtLastName = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        rbtnStudent = new javax.swing.JRadioButton();
        rbtnFaculty = new javax.swing.JRadioButton();
        comboProgram = new javax.swing.JComboBox<>();
        comboYrLvl = new javax.swing.JComboBox<>();
        lblWarningMsg = new javax.swing.JLabel();
        txtStudentFacultyID = new javax.swing.JTextField();
        lblUserID = new javax.swing.JLabel();
        lblUsername = new javax.swing.JLabel();
        lblUserEmail = new javax.swing.JLabel();

        setBackground((new Color(0, 0, 0, 0)));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnClear.setBackground(new java.awt.Color(51, 51, 255));
        btnClear.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnClear.setText("CLEAR");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });
        jPanel1.add(btnClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 380, 80, -1));

        btnSignIn.setBackground(new java.awt.Color(51, 51, 255));
        btnSignIn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSignIn.setText("SIGN IN");
        btnSignIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSignInActionPerformed(evt);
            }
        });
        jPanel1.add(btnSignIn, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 380, 190, -1));

        btnBackToLogin.setBackground(new java.awt.Color(51, 51, 255));
        btnBackToLogin.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnBackToLogin.setText("BACK TO LOGIN");
        btnBackToLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackToLoginActionPerformed(evt);
            }
        });
        jPanel1.add(btnBackToLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 410, 279, -1));

        txtFirstName.setBackground((new Color(0, 0, 0, 0)));
        txtFirstName.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        txtFirstName.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtFirstName.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)), "FIRST NAME", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Arial Rounded MT Bold", 0, 12))); // NOI18N
        txtFirstName.setPreferredSize(new java.awt.Dimension(90, 22));
        txtFirstName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFirstNameActionPerformed(evt);
            }
        });
        jPanel1.add(txtFirstName, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, 160, 40));

        txtLastName.setBackground((new Color(0, 0, 0, 0)));
        txtLastName.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        txtLastName.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtLastName.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)), "LAST NAME", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Arial Rounded MT Bold", 0, 12))); // NOI18N
        txtLastName.setPreferredSize(new java.awt.Dimension(90, 22));
        txtLastName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLastNameActionPerformed(evt);
            }
        });
        jPanel1.add(txtLastName, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 120, 150, 40));

        txtEmail.setBackground((new Color(0, 0, 0, 0)));
        txtEmail.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        txtEmail.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtEmail.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)), "EMAIL", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Arial Rounded MT Bold", 0, 12))); // NOI18N
        txtEmail.setPreferredSize(new java.awt.Dimension(90, 22));
        jPanel1.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 200, 310, 40));

        rbtnStudent.setBackground((new Color(0, 0, 0, 0)));
        btnGrp.add(rbtnStudent);
        rbtnStudent.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        rbtnStudent.setText("STUDENT");
        rbtnStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnStudentActionPerformed(evt);
            }
        });
        jPanel1.add(rbtnStudent, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 260, -1, -1));

        rbtnFaculty.setBackground((new Color(0, 0, 0, 0)));
        btnGrp.add(rbtnFaculty);
        rbtnFaculty.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        rbtnFaculty.setText("FACULTY");
        rbtnFaculty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnFacultyActionPerformed(evt);
            }
        });
        jPanel1.add(rbtnFaculty, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 260, -1, -1));

        comboProgram.setBackground(new java.awt.Color(255, 255, 204));
        comboProgram.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboProgramActionPerformed(evt);
            }
        });
        jPanel1.add(comboProgram, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 300, 130, -1));

        comboYrLvl.setBackground(new java.awt.Color(255, 255, 204));
        comboYrLvl.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        comboYrLvl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboYrLvlActionPerformed(evt);
            }
        });
        jPanel1.add(comboYrLvl, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 300, 120, -1));

        lblWarningMsg.setBackground((new Color(0, 0, 0, 0)));
        lblWarningMsg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblWarningMsg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/warningmsg_icon.png"))); // NOI18N
        lblWarningMsg.setText("jLabel1");
        jPanel1.add(lblWarningMsg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 460, 420, -1));

        txtStudentFacultyID.setBackground((new Color(0, 0, 0, 0)));
        txtStudentFacultyID.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        txtStudentFacultyID.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtStudentFacultyID.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)), "STUDENT / FACULTY ID", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Arial Rounded MT Bold", 0, 12))); // NOI18N
        txtStudentFacultyID.setPreferredSize(new java.awt.Dimension(90, 22));
        txtStudentFacultyID.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtStudentFacultyIDMouseClicked(evt);
            }
        });
        txtStudentFacultyID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStudentFacultyIDActionPerformed(evt);
            }
        });
        jPanel1.add(txtStudentFacultyID, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 310, 40));

        lblUserID.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUserID.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/id_iconBig.png"))); // NOI18N
        jPanel1.add(lblUserID, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        lblUsername.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/frontuser_icon.png"))); // NOI18N
        jPanel1.add(lblUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, -1));

        lblUserEmail.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/email_icon.png"))); // NOI18N
        jPanel1.add(lblUserEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, -1, -1));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 420, 500));
    }// </editor-fold>//GEN-END:initComponents

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        txtStudentFacultyID.setText("");
        txtFirstName.setText("");
        txtLastName.setText("");
        txtEmail.setText("");
        btnGrp.clearSelection();
        comboProgram.setVisible(false);
        comboYrLvl.setVisible(false);
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnSignInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSignInActionPerformed
        status = "ACTIVE";
        role = null;
        studentFacultyID = txtStudentFacultyID.getText();
        firstName = txtFirstName.getText();
        lastName = txtLastName.getText();
        email = txtEmail.getText();
        program = (String) comboProgram.getSelectedItem();
        yearLevel = (String) comboYrLvl.getSelectedItem();

        lblWarningMsg.setVisible(true);
        lblWarningMsg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/warningmsg_icon.png")));
        if (studentFacultyID.isEmpty() && firstName.isEmpty() && lastName.isEmpty() && email.isEmpty() && !rbtnStudent.isSelected() && !rbtnFaculty.isSelected()) {
            lblWarningMsg.setText("Please input all required fields.");
        } else if (studentFacultyID.isEmpty()) {
            lblWarningMsg.setText("Please Specify your ID");
        } else if (firstName.isEmpty() || lastName.isEmpty()) {
            lblWarningMsg.setText("Please specify your name.");
        } else if (email.isEmpty()) {
            lblWarningMsg.setText("Please input your email.");
        } else if (!firstName.matches("[A-Za-z0-9\\-. ]+") || !lastName.matches("[A-Za-z0-9\\-. ]+")) {
            lblWarningMsg.setText("Name should only consist of letters, numbers, dashes, dots, or spaces.");
        } else if (!email.matches("[\\w.-]+@[a-zA-Z0-9-]+\\.[a-zA-Z]{2,}")) {
            lblWarningMsg.setText("Invalid email address format.");
        } else if (!rbtnStudent.isSelected() && !rbtnFaculty.isSelected()) {
            lblWarningMsg.setText("Select your Role");
        } else {
            if (rbtnStudent.isSelected()) {
                if (program.equals("DEFAULT") || yearLevel.equals("DEFAULT")) {
                    lblWarningMsg.setText("Please specify your program/year level.");
                } else {
                    role = rbtnStudent.getText();
                    boolean success = LibraryMethods.registerUser(status, role, studentFacultyID, firstName, lastName, email, program, yearLevel);
                    if (success) {
                        lblWarningMsg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/successfulmsg_icon.png")));
                        lblWarningMsg.setText("User registered successfully.");
                    } else {
                        lblWarningMsg.setText("User registration failed. Account already exists.");
                        System.out.println("failed");
                    }
                }
            } else if (rbtnFaculty.isSelected()) {
                role = rbtnFaculty.getText();
                program = null;
                yearLevel = null;
                boolean success = LibraryMethods.registerUser(status, role, studentFacultyID, firstName, lastName, email, program, yearLevel);
                if (success) {
                    lblWarningMsg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/successfulmsg_icon.png")));
                    lblWarningMsg.setText("User registered successfully.");
                    btnSignIn.setEnabled(false);
                    btnClear.setEnabled(false);
                } else {
                    lblWarningMsg.setText("User registration failed. Account already exists.");
                    System.out.println("failed");
                }
            }
        }
    }//GEN-LAST:event_btnSignInActionPerformed

    private void txtFirstNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFirstNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFirstNameActionPerformed

    private void txtLastNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLastNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLastNameActionPerformed

    private void rbtnStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnStudentActionPerformed
        comboProgram.setVisible(true);
        comboYrLvl.setVisible(true);
    }//GEN-LAST:event_rbtnStudentActionPerformed

    private void rbtnFacultyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnFacultyActionPerformed
        comboProgram.setVisible(false);
        comboYrLvl.setVisible(false);
    }//GEN-LAST:event_rbtnFacultyActionPerformed

    private void comboProgramActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboProgramActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboProgramActionPerformed

    private void comboYrLvlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboYrLvlActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboYrLvlActionPerformed

    private void txtStudentFacultyIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStudentFacultyIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStudentFacultyIDActionPerformed

    private void btnBackToLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackToLoginActionPerformed
         lblWarningMsg.setVisible(false);
    }//GEN-LAST:event_btnBackToLoginActionPerformed

    private void txtStudentFacultyIDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtStudentFacultyIDMouseClicked
        lblWarningMsg.setVisible(false);
    }//GEN-LAST:event_txtStudentFacultyIDMouseClicked

    private String studentFacultyID, status, firstName, lastName, role, email, program, yearLevel;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBackToLogin;
    private javax.swing.JButton btnClear;
    private javax.swing.ButtonGroup btnGrp;
    private javax.swing.JButton btnSignIn;
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
    private javax.swing.JTextField txtFirstName;
    private javax.swing.JTextField txtLastName;
    private javax.swing.JTextField txtStudentFacultyID;
    // End of variables declaration//GEN-END:variables
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.finallibrarysystem;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.SwingUtilities;

/**
 *
 * @author araos
 */
public class LoginPanel extends javax.swing.JPanel {

    /**
     * Creates new form LoginPanel
     */
    public LoginPanel() {
        initComponents();
        lblWarningMsg.setVisible(false);
        insertContentComboReason();
    }

    public void addEventRegister(ActionListener event) {
        btnGoToSignUp.addActionListener(event);
    }
    
        private void insertContentComboReason() {
        List<AccountsDTO> programList = LibraryMethods.reasonComboContent();
        comboBoxReason.removeAllItems(); // Clear existing items

        for (AccountsDTO data : programList) {
            comboBoxReason.addItem(data.getReason());
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelGradient1 = new com.mycompany.finallibrarysystem.Design.PanelGradient();
        txtStudentFacultyID = new javax.swing.JTextField();
        comboBoxReason = new javax.swing.JComboBox<>();
        btnLogin = new javax.swing.JButton();
        lblWarningMsg = new javax.swing.JLabel();
        btnGoToSignUp = new javax.swing.JButton();
        lblDoYouHaveanAccount = new javax.swing.JLabel();
        lblStudentFacultyID = new javax.swing.JLabel();
        lblGIF = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelGradient1.setBackground((new Color(0, 0, 0, 0)));
        panelGradient1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtStudentFacultyID.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        txtStudentFacultyID.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtStudentFacultyID.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)), "STUDENT / FACULTY ID", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Arial Rounded MT Bold", 1, 14))); // NOI18N
        txtStudentFacultyID.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtStudentFacultyIDMouseClicked(evt);
            }
        });
        panelGradient1.add(txtStudentFacultyID, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 200, 300, 50));

        comboBoxReason.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "REASON", "SLEEP", "REVIEW", "THESIS" }));
        comboBoxReason.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxReasonActionPerformed(evt);
            }
        });
        panelGradient1.add(comboBoxReason, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 292, 300, 30));

        btnLogin.setBackground(new java.awt.Color(51, 51, 255));
        btnLogin.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnLogin.setText("TIME IN | TIME OUT");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        panelGradient1.add(btnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 370, 320, -1));

        lblWarningMsg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblWarningMsg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/warningmsg_icon.png"))); // NOI18N
        lblWarningMsg.setText("jLabel3");
        panelGradient1.add(lblWarningMsg, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 470, 350, -1));

        btnGoToSignUp.setBackground((new Color(0, 0, 0, 0)));
        btnGoToSignUp.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnGoToSignUp.setText(" SIGN UP");
        btnGoToSignUp.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        btnGoToSignUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGoToSignUpActionPerformed(evt);
            }
        });
        panelGradient1.add(btnGoToSignUp, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 430, 60, 20));

        lblDoYouHaveanAccount.setText("Don't have an account?");
        panelGradient1.add(lblDoYouHaveanAccount, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 430, -1, 20));

        lblStudentFacultyID.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStudentFacultyID.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/id_iconBig.png"))); // NOI18N
        panelGradient1.add(lblStudentFacultyID, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, -1, -1));

        lblGIF.setIcon(new javax.swing.ImageIcon("C:\\Users\\araos\\Downloads\\ezgif.com-resize (1).gif")); // NOI18N
        panelGradient1.add(lblGIF, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 0, -1, 190));

        add(panelGradient1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 420, 504));
    }// </editor-fold>//GEN-END:initComponents

    private void comboBoxReasonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxReasonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxReasonActionPerformed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        stuFaculID = txtStudentFacultyID.getText();
        reason = (String) comboBoxReason.getSelectedItem();
        lblWarningMsg.setVisible(true);
        if (stuFaculID.isEmpty()) {
            lblWarningMsg.setText("Please input your ID");
        } else {
            String userDetails = LibraryMethods.getUserDetails(stuFaculID);

            if (!userDetails.equals("false")) {
                String[] parts = userDetails.split(",");
                String status = parts[0];
                String userRole = parts[1];
                String sfID = parts[2];
                String fname = parts[3];
                String lname = parts[4];

                String fullName = fname + " " + lname;

                UserLogsDAO.createLogs();
                boolean timeinTimeoutChecker = UserLogsDAO.checkLogs(sfID);

                System.out.print(timeinTimeoutChecker);
                if (status.equals("ACTIVE")) {
                    if (userRole.equals("ADMIN")) {
                        if (timeinTimeoutChecker) {
                            System.out.print("CNNNN");
                            LibraryMethods.logUserLogin(sfID, fullName, null);
                        } else {
                            lblWarningMsg.setText("This Account is still online");
                        }
                        AdminDashboard admn = new AdminDashboard(fname, sfID);
                        admn.setVisible(true);
                        SwingUtilities.getWindowAncestor((Component) evt.getSource()).dispose();
                    } else if (userRole.equals("FACULTY")) {
                        if (timeinTimeoutChecker) {
                            LibraryMethods.logUserLogin(sfID, fullName, reason);
                            SwingUtilities.getWindowAncestor((Component) evt.getSource()).dispose();
                            WelcomeUser dialog = new WelcomeUser(new javax.swing.JFrame(), true, fullName);
                            dialog.setVisible(true); // Show the dialog
                            new MainFrame().setVisible(true);
                        } else if (!timeinTimeoutChecker) {
                            UserLogsDAO.userLogout(sfID);
                            SwingUtilities.getWindowAncestor((Component) evt.getSource()).dispose();
                            LogoutDialog dialog = new LogoutDialog(new javax.swing.JFrame(), true);
                            dialog.setVisible(true); // Show the dialog
                            new MainFrame().setVisible(true);
                        }
                    } else if (userRole.equals("STUDENT")) {
                        if (timeinTimeoutChecker) {
                            if (reason.equals("REASON")) {
                                lblWarningMsg.setText("Specify your Reason");
                            } else if (!reason.equals("REASON")) {
                                LibraryMethods.logUserLogin(sfID, fullName, reason);
                                SwingUtilities.getWindowAncestor((Component) evt.getSource()).dispose();
                                WelcomeUser dialog = new WelcomeUser(new javax.swing.JFrame(), true, fullName);
                                dialog.setVisible(true); // Show the dialog
                                new MainFrame().setVisible(true);
                            }
                        } else if (!timeinTimeoutChecker) {
                            UserLogsDAO.userLogout(sfID);
                            SwingUtilities.getWindowAncestor((Component) evt.getSource()).dispose();
                            LogoutDialog dialog = new LogoutDialog(new javax.swing.JFrame(), true);
                            dialog.setVisible(true); // Show the dialog
                            new MainFrame().setVisible(true);
                        }
                    }
                } else {
                    lblWarningMsg.setText("This account doesn't exist anymore");
                }
            } else {
                lblWarningMsg.setText("Invalid Credentials");
            }
        }
    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnGoToSignUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGoToSignUpActionPerformed
        lblWarningMsg.setVisible(false);
    }//GEN-LAST:event_btnGoToSignUpActionPerformed

    private void txtStudentFacultyIDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtStudentFacultyIDMouseClicked
        lblWarningMsg.setVisible(false);
    }//GEN-LAST:event_txtStudentFacultyIDMouseClicked

    private String stuFaculID, reason;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGoToSignUp;
    private javax.swing.JButton btnLogin;
    private javax.swing.JComboBox<String> comboBoxReason;
    private javax.swing.JLabel lblDoYouHaveanAccount;
    private javax.swing.JLabel lblGIF;
    private javax.swing.JLabel lblStudentFacultyID;
    private javax.swing.JLabel lblWarningMsg;
    private com.mycompany.finallibrarysystem.Design.PanelGradient panelGradient1;
    private javax.swing.JTextField txtStudentFacultyID;
    // End of variables declaration//GEN-END:variables
}

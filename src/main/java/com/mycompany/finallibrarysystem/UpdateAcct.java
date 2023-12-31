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
public class UpdateAcct extends javax.swing.JDialog {

    /**
     * Creates new form UpdateStudent
     */
    public UpdateAcct(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        lblWarningMsg.setVisible(false);
        comboProgram.setVisible(false);
        comboYrLvl.setVisible(false);
        insertContentComboProgram();
        insertContentComboYearLvl();

    }

    public void setStudentData(int id, String stuFaculID, String email, String firstName, String lastName, String program, String yearLevel) {
        this.id = id;
        this.stuFaculID = stuFaculID;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.program = program;
        this.yearLevel = yearLevel;

        // Set the values to the corresponding text fields or combo boxes
        txtStudentFacultyID.setText(stuFaculID);
        txtEmail.setText(email);
        txtFirstName.setText(this.firstName);
        txtLastName.setText(this.lastName);
        rbtnStudent.setSelected(true);
        comboProgram.setVisible(true);
        comboYrLvl.setVisible(true);
        comboProgram.setSelectedItem(program);
        comboYrLvl.setSelectedItem(yearLevel);
    }

    public void setFacultyData(int id, String stuFaculID, String email, String firstName, String lastName) {
        this.id = id;
        this.stuFaculID = stuFaculID;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;

        // Set the values to the corresponding text fields or combo boxes
        rbtnFaculty.setSelected(true);
        txtStudentFacultyID.setText(stuFaculID);
        txtEmail.setText(email);
        txtFirstName.setText(this.firstName);
        txtLastName.setText(this.lastName);
    }

    public void setAdminData(int id, String stuFaculID, String firstName, String lastName, String email) {
        this.id = id;
        this.stuFaculID = stuFaculID;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;

        // Set the values to the corresponding text fields or combo boxes
        rbtnAdmin.setSelected(true);
        txtStudentFacultyID.setText(stuFaculID);
        txtEmail.setText(email);
        txtFirstName.setText(this.firstName);
        txtLastName.setText(this.lastName);
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        txtLastName = new javax.swing.JTextField();
        rbtnFaculty = new javax.swing.JRadioButton();
        rbtnAdmin = new javax.swing.JRadioButton();
        txtEmail = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtFirstName = new javax.swing.JTextField();
        saveChanges = new javax.swing.JButton();
        rbtnStudent = new javax.swing.JRadioButton();
        comboProgram = new javax.swing.JComboBox<>();
        lblWarningMsg = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        comboYrLvl = new javax.swing.JComboBox<>();
        txtStudentFacultyID = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtLastName.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtLastName.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)), "LAST NAME", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM));

        buttonGroup1.add(rbtnFaculty);
        rbtnFaculty.setText("FACULTY");
        rbtnFaculty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnFacultyActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbtnAdmin);
        rbtnAdmin.setText("ADMIN");
        rbtnAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnAdminActionPerformed(evt);
            }
        });

        txtEmail.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtEmail.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)), "EMAIL", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Update Account");

        txtFirstName.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtFirstName.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)), "FIRST NAME", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM));

        saveChanges.setBackground(new java.awt.Color(0, 102, 255));
        saveChanges.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        saveChanges.setText("SAVE");
        saveChanges.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveChangesActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbtnStudent);
        rbtnStudent.setText("STUDENT");

        comboProgram.setBackground(new java.awt.Color(255, 255, 204));

        lblWarningMsg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblWarningMsg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/warningmsg_icon.png"))); // NOI18N
        lblWarningMsg.setText("jLabel1");

        btnBack.setBackground(new java.awt.Color(0, 102, 255));
        btnBack.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnBack.setText("BACK");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        comboYrLvl.setBackground(new java.awt.Color(255, 255, 204));

        txtStudentFacultyID.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtStudentFacultyID.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)), "STUDENT / FACULTY ID", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(106, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(104, 104, 104))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtStudentFacultyID, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(txtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(10, 10, 10)
                            .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(rbtnStudent)
                            .addGap(38, 38, 38)
                            .addComponent(rbtnFaculty)
                            .addGap(58, 58, 58)
                            .addComponent(rbtnAdmin))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(comboProgram, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(50, 50, 50)
                            .addComponent(comboYrLvl, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(60, 60, 60)
                            .addComponent(saveChanges, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(5, 5, 5)
                            .addComponent(lblWarningMsg, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(389, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 84, Short.MAX_VALUE)
                    .addComponent(txtStudentFacultyID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(20, 20, 20)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(20, 20, 20)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(10, 10, 10)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(rbtnStudent)
                        .addComponent(rbtnFaculty)
                        .addComponent(rbtnAdmin))
                    .addGap(29, 29, 29)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(comboProgram, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(comboYrLvl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(58, 58, 58)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnBack)
                        .addComponent(saveChanges))
                    .addGap(17, 17, 17)
                    .addComponent(lblWarningMsg)
                    .addGap(0, 12, Short.MAX_VALUE)))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 390, 460));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private void saveChangesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveChangesActionPerformed
        status = "ACTIVE";
        role = null;
        studentFacultyID = txtStudentFacultyID.getText();
        System.out.println(studentFacultyID + "UA");
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
        } else if (!rbtnStudent.isSelected() && !rbtnFaculty.isSelected() && !rbtnAdmin.isSelected()) {
            lblWarningMsg.setText("Select your Role");
        } else {
            AccountDAO acct = new AccountDAO();
            if (rbtnStudent.isSelected()) {
                if (program.equals("DEFAULT") || yearLevel.equals("DEFAULT")) {
                    lblWarningMsg.setText("Please specify your program/year level.");
                } else {
                    role = rbtnStudent.getText();
                    String msg = AccountDAO.updateAccount(id, role, studentFacultyID, firstName, lastName, email, program, yearLevel);
                    lblWarningMsg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/successfulmsg_icon.png")));
                    lblWarningMsg.setText(msg);
                }
            } else if (rbtnFaculty.isSelected()) {
                role = rbtnFaculty.getText();
                program = null;
                yearLevel = null;
                String msg = AccountDAO.updateAccount(id, role, stuFaculID, firstName, lastName, email, program, yearLevel);
                lblWarningMsg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/successfulmsg_icon.png")));
                lblWarningMsg.setText(msg);
            } else {
                role = rbtnAdmin.getText();
                program = null;
                yearLevel = null;
                String msg = AccountDAO.updateAccount(id, role, stuFaculID, firstName, lastName, email, program, yearLevel);
                lblWarningMsg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/successfulmsg_icon.png")));
                lblWarningMsg.setText(msg);
            }
        }
    }//GEN-LAST:event_saveChangesActionPerformed

    private void rbtnFacultyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnFacultyActionPerformed
        comboProgram.setVisible(false);
        comboYrLvl.setVisible(false);
    }//GEN-LAST:event_rbtnFacultyActionPerformed

    private void rbtnAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnAdminActionPerformed
        comboProgram.setVisible(false);
        comboYrLvl.setVisible(false);
    }//GEN-LAST:event_rbtnAdminActionPerformed

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
            java.util.logging.Logger.getLogger(UpdateAcct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UpdateAcct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UpdateAcct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UpdateAcct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                UpdateAcct dialog = new UpdateAcct(new javax.swing.JFrame(), true);
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

    int id;
    private String stuFaculID, studentFacultyID, status, firstName, lastName, role, email, program, yearLevel;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> comboProgram;
    private javax.swing.JComboBox<String> comboYrLvl;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblWarningMsg;
    private javax.swing.JRadioButton rbtnAdmin;
    private javax.swing.JRadioButton rbtnFaculty;
    private javax.swing.JRadioButton rbtnStudent;
    private javax.swing.JButton saveChanges;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFirstName;
    private javax.swing.JTextField txtLastName;
    private javax.swing.JTextField txtStudentFacultyID;
    // End of variables declaration//GEN-END:variables
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.mycompany.finallibrarysystem;

import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author araos
 */
public class WelcomeUser extends javax.swing.JDialog {

    /**
     * Creates new form WelcomeUser
     */
    private final int waitTime = 3;
    private Timer timer;

    public WelcomeUser(java.awt.Frame parent, boolean modal, String name) {

        super(parent, modal);
        initComponents();
        lblUserName.setText(name);
        countDown();
    }

    public void countDown() {
        timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            private int remainingTime = waitTime;

            @Override
            public void run() {
                if (remainingTime > 0) {
                    remainingTime--;
                } else {
                    timer.cancel();
                    timer.purge();
                    dispose(); // Close the dialog
                }
            }
        };

        // Schedule the timer task to run every second
        timer.scheduleAtFixedRate(timerTask, 0, 1000);
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblWelcome = new javax.swing.JLabel();
        lblUserName = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblWelcome.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lblWelcome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblWelcome.setText("WELCOME!");
        jPanel1.add(lblWelcome, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 380, 70));

        lblUserName.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblUserName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUserName.setText("jLabel1");
        jPanel1.add(lblUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 380, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("PLEASE OBSERVE SILENCE");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 370, -1, -1));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/GIFlogin.gif"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 270, 250));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 380, 430));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblUserName;
    private javax.swing.JLabel lblWelcome;
    // End of variables declaration//GEN-END:variables
}

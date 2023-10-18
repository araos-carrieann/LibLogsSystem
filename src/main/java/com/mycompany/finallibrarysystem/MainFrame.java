/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.finallibrarysystem;

import com.formdev.flatlaf.FlatLightLaf;
import static com.mycompany.finallibrarysystem.LibraryMethods.createReasonTable;
import static com.mycompany.finallibrarysystem.LibraryMethods.createTableProgram;
import static com.mycompany.finallibrarysystem.LibraryMethods.createYearLevelTable;
import static com.mycompany.finallibrarysystem.UserLogsDAO.createLogs;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author araos
 */
public class MainFrame extends javax.swing.JFrame {

    public MainFrame() {
        initComponents();
        createLogs();
        createTableProgram();
        createYearLevelTable();
        createReasonTable();
        com.mycompany.finallibrarysystem.LoginPanel login = new com.mycompany.finallibrarysystem.LoginPanel();
        com.mycompany.finallibrarysystem.SignUpPanel signUp = new com.mycompany.finallibrarysystem.SignUpPanel();
        mainSlide.setAnimate(20);
        mainSlide.init(login, signUp);
        login.addEventRegister(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                //  Show register form
                mainSlide.show(1);
            }
        });
        signUp.addEventBackLogin(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                mainSlide.show(0);
            }
        });
    }

    public void closeMain() {
        dispose();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelGradient1 = new com.mycompany.finallibrarysystem.Design.PanelGradient();
        mainBorder = new com.mycompany.finallibrarysystem.Design.PanelBorder();
        mainSlide = new com.mycompany.finallibrarysystem.Design.PanelSlide();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(2000, 1500));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelGradient1.setColorPrimary(new java.awt.Color(255, 255, 102));
        panelGradient1.setColorSecondary(new java.awt.Color(153, 0, 0));
        panelGradient1.setPreferredSize(new java.awt.Dimension(2000, 1200));

        mainBorder.setBackground(new java.awt.Color(255, 255, 255));

        mainSlide.setBackground((new Color(0, 0, 0, 0)));
        mainSlide.setMinimumSize(new java.awt.Dimension(0, 0));

        javax.swing.GroupLayout mainSlideLayout = new javax.swing.GroupLayout(mainSlide);
        mainSlide.setLayout(mainSlideLayout);
        mainSlideLayout.setHorizontalGroup(
            mainSlideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 530, Short.MAX_VALUE)
        );
        mainSlideLayout.setVerticalGroup(
            mainSlideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );

        mainBorder.add(mainSlide);
        mainSlide.setBounds(10, 10, 530, 600);

        panelGradient1.add(mainBorder);
        mainBorder.setBounds(680, 240, 550, 620);

        getContentPane().add(panelGradient1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        setExtendedState(MainFrame.MAXIMIZED_BOTH);
    }//GEN-LAST:event_formWindowOpened

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        FlatLightLaf.setup();
        new MainFrame().setVisible(true);

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.mycompany.finallibrarysystem.Design.PanelBorder mainBorder;
    private com.mycompany.finallibrarysystem.Design.PanelSlide mainSlide;
    private com.mycompany.finallibrarysystem.Design.PanelGradient panelGradient1;
    // End of variables declaration//GEN-END:variables
}

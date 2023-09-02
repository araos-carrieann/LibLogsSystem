/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.finallibrarysystem;

import com.formdev.flatlaf.FlatLightLaf;
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

        panelGradient1.setColorPrimary(new java.awt.Color(255, 255, 102));
        panelGradient1.setColorSecondary(new java.awt.Color(153, 0, 0));

        mainBorder.setBackground(new java.awt.Color(255, 255, 255));

        mainSlide.setBackground((new Color(0, 0, 0, 0)));

        javax.swing.GroupLayout mainSlideLayout = new javax.swing.GroupLayout(mainSlide);
        mainSlide.setLayout(mainSlideLayout);
        mainSlideLayout.setHorizontalGroup(
            mainSlideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 410, Short.MAX_VALUE)
        );
        mainSlideLayout.setVerticalGroup(
            mainSlideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );

        mainBorder.add(mainSlide);
        mainSlide.setBounds(10, 10, 410, 500);

        panelGradient1.add(mainBorder);
        mainBorder.setBounds(210, 20, 430, 520);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelGradient1, javax.swing.GroupLayout.DEFAULT_SIZE, 828, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelGradient1, javax.swing.GroupLayout.DEFAULT_SIZE, 565, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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

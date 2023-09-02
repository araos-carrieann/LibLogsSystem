/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package CustomPieChart;

import com.mycompany.finallibrarysystem.AccountsDTO;
import com.mycompany.finallibrarysystem.DatabaseConnector;
import com.mycompany.finallibrarysystem.LibraryMethods;
import java.awt.Color;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author araos
 */
public class Chart extends javax.swing.JPanel {

    /**
     * Creates new form Chart
     */
    public Chart() {
        initComponents();
        contentComboYearLvl();
        showAllData();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pieChart1 = new CustomPieChart.PieChart();
        comboYrLvl = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(128, 0, 0));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        add(pieChart1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 34, 450, 280));

        comboYrLvl.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboYrLvl.setSelectedIndex(1);
        comboYrLvl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboYrLvlActionPerformed(evt);
            }
        });
        add(comboYrLvl, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 10, 130, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void contentComboYearLvl() {
        List<AccountsDTO> yrLvlList = LibraryMethods.yearlvlComboContent();
        comboYrLvl.removeAllItems(); // Clear existing items

        for (AccountsDTO data : yrLvlList) {
            comboYrLvl.addItem(data.getYrlvl());
        }
    }

    private void showAllData() {
        try {
            pieChart1.clearData();
            String sql = """
                         SELECT 
                                users.program,
                                COUNT(logs.logID) AS logs_count
                            FROM
                                users
                            RIGHT JOIN
                                logs
                                ON logs.user_id_users = users.id
                            WHERE
                                users.program IS NOT NULL
                                AND logs.login_time >= CURRENT_TIMESTAMP - INTERVAL '3 months'
                            GROUP BY
                                users.program;""";
            PreparedStatement pstmt = DatabaseConnector.getConnection().prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            int index = 0;
            while (rs.next()) {
                String program = rs.getString("program");
                int logs_count = rs.getInt("logs_count");
                pieChart1.addData(new ModelPieChart(program, logs_count, getColor(index++)));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void showData(String yrlvl) {
        try {
            pieChart1.clearData();
            String sql = """
                         SELECT 
                             users.yearlvl,
                             users.program,
                             COUNT(logs.logID) AS logs_count
                         FROM
                             users
                         RIGHT JOIN
                             logs
                         ON
                             logs.user_id_users = users.id
                         WHERE
                             users.yearlvl = ? 
                             AND logs.login_time >= CURRENT_TIMESTAMP - INTERVAL '3 months'
                         GROUP BY
                             users.yearlvl, users.program;""";
            PreparedStatement pstmt = DatabaseConnector.getConnection().prepareStatement(sql);
            pstmt.setString(1, yrlvl);
            ResultSet rs = pstmt.executeQuery();
            int index = 0;
            while (rs.next()) {
                String program = rs.getString("program");
                int logs_count = rs.getInt("logs_count");
                pieChart1.addData(new ModelPieChart(program, logs_count, getColor(index++)));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private Color getColor(int index) {
        Color[] color = new Color[]{new Color(204, 204, 255), new Color(153, 153, 255), new Color(255, 204, 255), new Color(255, 51, 255), new Color(255, 204, 255), new Color(204, 255, 204)};
        return color[index];
    }

    private void comboYrLvlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboYrLvlActionPerformed
        if (comboYrLvl.getSelectedIndex() >= 0) {
            String selected = comboYrLvl.getSelectedItem().toString();
            if (selected.equals("YEAR LEVEL")) {
                showAllData();
            } else {
                showData(selected);
            }
        }
    }//GEN-LAST:event_comboYrLvlActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comboYrLvl;
    private CustomPieChart.PieChart pieChart1;
    // End of variables declaration//GEN-END:variables
}

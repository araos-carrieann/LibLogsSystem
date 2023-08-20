/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.finallibrarysystem;

import java.awt.Color;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author araos
 */
public class AdminDashboard extends javax.swing.JFrame {

    private String sfID;

    public String getSfID() {
        return sfID;
    }

    public void setSfID(String sfID) {
        this.sfID = sfID;
    }

    public AdminDashboard(String fname, String sfID) {
        this.sfID = sfID;
        initComponents();
        lblAdminsName.setText(fname);
        librarysystem.LibraryMethods clm = new librarysystem.LibraryMethods();
        displayAllActiveUser();
        displayMostLogs();
        displayLogs();
        displayStudentAccount();
        displayFacultyAccount();
        displayAdminAccount();
    }

    void displayStudentAccount() {
        DefaultTableModel studentAccount = (DefaultTableModel) studentAcctTable.getModel();
        studentAccount.setRowCount(0);

        List<AccountsDTO> acctList = LibraryMethods.getAllStudentDatas();

        for (AccountsDTO acct : acctList) {
            Object[] row = {acct.getStudentfacultyID(), acct.getFirstName(), acct.getLastName(), acct.getEmail(), acct.getProgram(), acct.getYrlvl()};
            studentAccount.addRow(row);
        }
        lblTotalNumberUsers.setText(String.valueOf(librarysystem.LibraryMethods.getTotalUserRows()));
        lblNumberOfActive.setText(String.valueOf(librarysystem.LibraryMethods.getTotalActiveUser()));
    }

    public void searchStudentAcct(String search) {
        DefaultTableModel studentAccount = (DefaultTableModel) studentAcctTable.getModel();
        TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(studentAccount);
        studentAcctTable.setRowSorter(trs);
        trs.setRowFilter(RowFilter.regexFilter(search));

    }

    public void searchFacultyAcct(String search) {
        DefaultTableModel facultyAccount = (DefaultTableModel) facultyAcctTable.getModel();
        TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(facultyAccount);
        facultyAcctTable.setRowSorter(trs);
        trs.setRowFilter(RowFilter.regexFilter(search));

    }

    void displayFacultyAccount() {
        DefaultTableModel facultyAccount = (DefaultTableModel) facultyAcctTable.getModel();
        facultyAccount.setRowCount(0);

        List<UserLogsDTO> acctList = LibraryMethods.getAllFacultiesDatas();

        for (UserLogsDTO acct : acctList) {
            Object[] row = {acct.getStudentfacultyID(), acct.getFirstName(), acct.getLastName(), acct.getEmail()};
            facultyAccount.addRow(row);
        }
        lblTotalNumberUsers.setText(String.valueOf(librarysystem.LibraryMethods.getTotalUserRows()));
    }

    void displayAdminAccount() {
        DefaultTableModel adminAccount = (DefaultTableModel) adminAccountTable.getModel();
        adminAccount.setRowCount(0);

        List<librarysystem.AccountDTO> acctList = librarysystem.LibraryMethods.getAllAdminDatas();

        for (librarysystem.AccountDTO acct : acctList) {
            Object[] row = {acct.getStudentfacultyID(), acct.getFirstName(), acct.getLastName(), acct.getEmail()};
            adminAccount.addRow(row);
        }
        lblTotalNumberUsers.setText(String.valueOf(librarysystem.LibraryMethods.getTotalUserRows()));
    }

    public void searchAdminAcct(String search) {
        DefaultTableModel adminyAccount = (DefaultTableModel) adminAccountTable.getModel();
        TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(adminyAccount);
        adminAccountTable.setRowSorter(trs);
        trs.setRowFilter(RowFilter.regexFilter(search));

    }

    public void searchUserLogs(String search) {
        DefaultTableModel logs = (DefaultTableModel) logsTable.getModel();
        TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(logs);
        logsTable.setRowSorter(trs);
        trs.setRowFilter(RowFilter.regexFilter(search));

    }

    void displayLogs() {
        DefaultTableModel allLogs = (DefaultTableModel) logsTable.getModel();
        allLogs.setRowCount(0);

        List<UserLogsDTO> acctList = UserLogsDAO.getAllLogs();

        for (UserLogsDTO acct : acctList) {
            Object[] logsRow = {acct.getRole(), acct.getFullname(), acct.getProgram(), acct.getYrlvl(), acct.getReason(), acct.getLoginTime(), acct.getLogoutTime()};
            allLogs.addRow(logsRow);
        }
    }

    private void insertContentComboProgram() {
        JComboBox<String> comboBox = new JComboBox<>();
        List<AccountsDTO> programList = LibraryMethods.programComboContent();
        if (!programList.isEmpty()) {
            AccountsDTO acct = programList.get(0);
            comboBox.addItem(acct.getProgram());
        }
    }

    private void insertContentComboYearLvl() {
        JComboBox<String> comboBox = new JComboBox<>();
        List<AccountsDTO> yrLvlList = LibraryMethods.yearlvlComboContent();
        if (!yrLvlList.isEmpty()) {
            AccountsDTO acct = yrLvlList.get(1);
            comboBox.addItem(acct.getYrlvl());
        }
    }

    void displayMostLogs() {
        DefaultTableModel mostLogs = (DefaultTableModel) mostLogsTable.getModel();
        mostLogs.setRowCount(0);

        List<librarysystem.AccountDTO> mostLogsList = librarysystem.LibraryMethods.mostLogs();

        for (librarysystem.AccountDTO acct : mostLogsList) {
            Object[] mLogs = {acct.getRole(), acct.getFullname(), acct.getMostLogs()};
            mostLogs.addRow(mLogs);
        }
    }

    void displayAllActiveUser() {
        DefaultTableModel userOnline = (DefaultTableModel) activeUserNow.getModel();
        userOnline.setRowCount(0);

        List<UserLogsDTO> onlineUsers = LibraryMethods.activeUsers();

        for (UserLogsDTO acct : onlineUsers) {
            Object[] onlineUser = {acct.getFullname(), acct.getProgram(), acct.getYrlvl()};
            userOnline.addRow(onlineUser);
        }
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        panelBorder1 = new com.mycompany.finallibrarysystem.Design.PanelBorder();
        panelHome = new com.mycompany.finallibrarysystem.Design.PanelBorder();
        lblDashboard = new javax.swing.JLabel();
        panelAccounts = new com.mycompany.finallibrarysystem.Design.PanelBorder();
        lblAccounts = new javax.swing.JLabel();
        panelLogs = new com.mycompany.finallibrarysystem.Design.PanelBorder();
        lblAllLogs = new javax.swing.JLabel();
        panelLogout = new com.mycompany.finallibrarysystem.Design.PanelBorder();
        lblLogout = new javax.swing.JLabel();
        lblLogo = new javax.swing.JLabel();
        cardPanel = new javax.swing.JPanel();
        homePage = new javax.swing.JPanel();
        panelBorder2 = new com.mycompany.finallibrarysystem.Design.PanelBorder();
        lblTopFiveLogs = new javax.swing.JLabel();
        scroll = new javax.swing.JScrollPane();
        mostLogsTable = new javax.swing.JTable();
        panelBorder3 = new com.mycompany.finallibrarysystem.Design.PanelBorder();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        activeUserNow = new javax.swing.JTable();
        panelBorder5 = new com.mycompany.finallibrarysystem.Design.PanelBorder();
        lblTotalNumberUsers = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        panelBorder6 = new com.mycompany.finallibrarysystem.Design.PanelBorder();
        lblNumberOfActive = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        panelBorder7 = new com.mycompany.finallibrarysystem.Design.PanelBorder();
        panelBorder4 = new com.mycompany.finallibrarysystem.Design.PanelBorder();
        lblAdminsName = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        accountPage = new javax.swing.JPanel();
        panelBorder8 = new com.mycompany.finallibrarysystem.Design.PanelBorder();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        txtStudentSearchAcct = new javax.swing.JTextField();
        btnAddStudentAcct = new javax.swing.JButton();
        btnDeleteStuAcct = new javax.swing.JButton();
        btnUpdateStudentAccount = new javax.swing.JButton();
        studentAcctPane = new javax.swing.JScrollPane();
        studentAcctTable = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        btnUpdateAdminAcct = new javax.swing.JButton();
        txtAdminSearchAcct = new javax.swing.JTextField();
        btnDeleteAdminAcct = new javax.swing.JButton();
        adminPane = new javax.swing.JScrollPane();
        adminAccountTable = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        txtFacultySearchAcct = new javax.swing.JTextField();
        btnAddFacultyAccount = new javax.swing.JButton();
        btnDeleteFacultyAcct = new javax.swing.JButton();
        btnUpdateFacultyAcct = new javax.swing.JButton();
        facultyAcctPane = new javax.swing.JScrollPane();
        jLabel6 = new javax.swing.JLabel();
        logsPage = new javax.swing.JPanel();
        panelBorder9 = new com.mycompany.finallibrarysystem.Design.PanelBorder();
        logsPane = new javax.swing.JScrollPane();
        logsTable = new javax.swing.JTable();
        txtSearchLogs = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1200, 700));
        setSize(new java.awt.Dimension(1200, 700));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1100, 700));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelBorder1.setBackground(new java.awt.Color(128, 0, 0));

        panelHome.setBackground(new java.awt.Color(128, 0, 0));
        panelHome.setLayout(new java.awt.GridLayout(1, 0));

        lblDashboard.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblDashboard.setForeground(new java.awt.Color(255, 223, 0));
        lblDashboard.setText("DASHBOARD");
        lblDashboard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDashboardMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblDashboardMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblDashboardMouseExited(evt);
            }
        });
        panelHome.add(lblDashboard);

        panelBorder1.add(panelHome);
        panelHome.setBounds(10, 220, 190, 70);

        panelAccounts.setBackground(new java.awt.Color(128, 0, 0));
        panelAccounts.setLayout(new java.awt.GridLayout(1, 0));

        lblAccounts.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblAccounts.setForeground(new java.awt.Color(255, 223, 0));
        lblAccounts.setText("ACCOUNTS");
        lblAccounts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAccountsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblAccountsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblAccountsMouseExited(evt);
            }
        });
        panelAccounts.add(lblAccounts);

        panelBorder1.add(panelAccounts);
        panelAccounts.setBounds(10, 310, 190, 70);

        panelLogs.setBackground(new java.awt.Color(128, 0, 0));
        panelLogs.setLayout(new java.awt.GridLayout(1, 0));

        lblAllLogs.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblAllLogs.setForeground(new java.awt.Color(255, 223, 0));
        lblAllLogs.setText("LOGS");
        lblAllLogs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAllLogsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblAllLogsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblAllLogsMouseExited(evt);
            }
        });
        panelLogs.add(lblAllLogs);

        panelBorder1.add(panelLogs);
        panelLogs.setBounds(10, 410, 190, 70);

        panelLogout.setBackground(new java.awt.Color(128, 0, 0));
        panelLogout.setLayout(new java.awt.GridLayout(1, 0));

        lblLogout.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblLogout.setForeground(new java.awt.Color(255, 223, 0));
        lblLogout.setText("LOGOUT");
        lblLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblLogoutMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblLogoutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblLogoutMouseExited(evt);
            }
        });
        panelLogout.add(lblLogout);

        panelBorder1.add(panelLogout);
        panelLogout.setBounds(10, 560, 190, 70);

        lblLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/PUPLogo_icon.png"))); // NOI18N
        panelBorder1.add(lblLogo);
        lblLogo.setBounds(0, 0, 210, 180);

        jPanel1.add(panelBorder1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 210, 650));

        cardPanel.setLayout(new java.awt.CardLayout());

        homePage.setBackground(new java.awt.Color(255, 255, 255));
        homePage.setPreferredSize(new java.awt.Dimension(1000, 670));
        homePage.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelBorder2.setBackground(new java.awt.Color(128, 0, 0));

        lblTopFiveLogs.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        lblTopFiveLogs.setForeground(new java.awt.Color(255, 255, 255));
        lblTopFiveLogs.setText("TOP 5 MOST LOGS");
        panelBorder2.add(lblTopFiveLogs);
        lblTopFiveLogs.setBounds(20, 20, 250, 29);

        scroll.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        scroll.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        scroll.setRowHeaderView(null);

        mostLogsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ROLE", "NAME", "NUMBER OF LOGS"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        mostLogsTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        mostLogsTable.setEnabled(false);
        mostLogsTable.setGridColor(new java.awt.Color(0, 0, 0));
        mostLogsTable.setOpaque(false);
        mostLogsTable.setRowHeight(22);
        mostLogsTable.setSelectionForeground(new java.awt.Color(101, 100, 124));
        mostLogsTable.setShowGrid(true);
        scroll.setViewportView(mostLogsTable);

        panelBorder2.add(scroll);
        scroll.setBounds(10, 60, 390, 210);

        homePage.add(panelBorder2, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 370, 410, 280));

        panelBorder3.setBackground(new java.awt.Color(128, 0, 0));
        panelBorder3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("ACTIVE NOW");
        panelBorder3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        activeUserNow.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "NAME", "PROGRAM", "YEAR LEVEL"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        activeUserNow.setEnabled(false);
        activeUserNow.setOpaque(false);
        activeUserNow.setRowHeight(22);
        activeUserNow.setSelectionBackground(new java.awt.Color(55, 126, 249));
        activeUserNow.setShowGrid(true);
        jScrollPane2.setViewportView(activeUserNow);

        panelBorder3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, 340));

        homePage.add(panelBorder3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 500, 420));

        panelBorder5.setBackground(new java.awt.Color(128, 0, 0));

        lblTotalNumberUsers.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        lblTotalNumberUsers.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTotalNumberUsers.setText("0");
        panelBorder5.add(lblTotalNumberUsers);
        lblTotalNumberUsers.setBounds(110, 0, 110, 100);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/dashboardRegisteredUserIcon.png"))); // NOI18N
        panelBorder5.add(jLabel2);
        jLabel2.setBounds(30, 0, 100, 100);

        homePage.add(panelBorder5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 230, 100));

        panelBorder6.setBackground(new java.awt.Color(128, 0, 0));

        lblNumberOfActive.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        lblNumberOfActive.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNumberOfActive.setText("0");
        panelBorder6.add(lblNumberOfActive);
        lblNumberOfActive.setBounds(110, 0, 110, 100);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/dashboardActiveUser.png"))); // NOI18N
        panelBorder6.add(jLabel4);
        jLabel4.setBounds(30, 0, 70, 100);

        homePage.add(panelBorder6, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 120, 230, 100));

        panelBorder7.setBackground(new java.awt.Color(128, 0, 0));
        homePage.add(panelBorder7, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 120, 410, 230));

        panelBorder4.setBackground(new java.awt.Color(128, 0, 0));

        lblAdminsName.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        lblAdminsName.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblAdminsName.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/userdashboard_icon.png"))); // NOI18N
        lblAdminsName.setText("name");
        panelBorder4.add(lblAdminsName);
        lblAdminsName.setBounds(170, 10, 230, 70);

        homePage.add(panelBorder4, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 10, 410, 90));

        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 48)); // NOI18N
        jLabel1.setText("DASHBOARD");
        homePage.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        cardPanel.add(homePage, "card2");

        accountPage.setBackground(new java.awt.Color(255, 255, 255));
        accountPage.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelBorder8.setBackground(new java.awt.Color(128, 0, 0));

        jTabbedPane1.setBackground(new java.awt.Color(128, 0, 0));
        jTabbedPane1.setForeground(new java.awt.Color(255, 223, 0));
        jTabbedPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTabbedPane1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jTabbedPane1.setName(""); // NOI18N

        jPanel2.setBackground(new java.awt.Color(128, 0, 0));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtStudentSearchAcct.setText("Enter Search");
        txtStudentSearchAcct.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtStudentSearchAcctKeyReleased(evt);
            }
        });
        jPanel2.add(txtStudentSearchAcct, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 10, 390, 40));

        btnAddStudentAcct.setBackground(new java.awt.Color(204, 255, 204));
        btnAddStudentAcct.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAddStudentAcct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add_user.png"))); // NOI18N
        btnAddStudentAcct.setText("ADD USER");
        btnAddStudentAcct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddStudentAcctActionPerformed(evt);
            }
        });
        jPanel2.add(btnAddStudentAcct, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 60, -1, -1));

        btnDeleteStuAcct.setBackground(new java.awt.Color(255, 51, 51));
        btnDeleteStuAcct.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnDeleteStuAcct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/delete_icon.png"))); // NOI18N
        btnDeleteStuAcct.setText("DELETE");
        btnDeleteStuAcct.setEnabled(false);
        btnDeleteStuAcct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteStuAcctActionPerformed(evt);
            }
        });
        jPanel2.add(btnDeleteStuAcct, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 60, -1, -1));

        btnUpdateStudentAccount.setBackground(new java.awt.Color(51, 102, 255));
        btnUpdateStudentAccount.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnUpdateStudentAccount.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/update_icon.png"))); // NOI18N
        btnUpdateStudentAccount.setText("UPDATE");
        btnUpdateStudentAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateStudentAccountActionPerformed(evt);
            }
        });
        jPanel2.add(btnUpdateStudentAccount, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, -1, -1));

        studentAcctTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "STUDENT ID", "EMAIL", "FIRST NAME", "LAST NAME", "PROGRAM", "YEAR LEVEL"
            }
        ));
        studentAcctTable.setShowGrid(true);
        studentAcctTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                studentAcctTableMouseClicked(evt);
            }
        });
        studentAcctPane.setViewportView(studentAcctTable);

        jPanel2.add(studentAcctPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 910, 390));

        jTabbedPane1.addTab("STUDENT", jPanel2);

        jPanel3.setBackground(new java.awt.Color(128, 0, 0));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnUpdateAdminAcct.setBackground(new java.awt.Color(51, 102, 255));
        btnUpdateAdminAcct.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnUpdateAdminAcct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/update_icon.png"))); // NOI18N
        btnUpdateAdminAcct.setText("UPDATE");
        btnUpdateAdminAcct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateAdminAcctActionPerformed(evt);
            }
        });
        jPanel3.add(btnUpdateAdminAcct, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        txtAdminSearchAcct.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtAdminSearchAcct.setText("Search");
        txtAdminSearchAcct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAdminSearchAcctActionPerformed(evt);
            }
        });
        txtAdminSearchAcct.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtAdminSearchAcctKeyReleased(evt);
            }
        });
        jPanel3.add(txtAdminSearchAcct, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 30, 390, 40));

        btnDeleteAdminAcct.setBackground(new java.awt.Color(255, 51, 51));
        btnDeleteAdminAcct.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnDeleteAdminAcct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/delete_icon.png"))); // NOI18N
        btnDeleteAdminAcct.setText("DELETE");
        btnDeleteAdminAcct.setEnabled(false);
        btnDeleteAdminAcct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteAdminAcctActionPerformed(evt);
            }
        });
        jPanel3.add(btnDeleteAdminAcct, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 60, -1, -1));

        adminAccountTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "FIRST NAME", "LAST NAME", "EMAIL"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        adminAccountTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                adminAccountTableMouseClicked(evt);
            }
        });
        adminPane.setViewportView(adminAccountTable);

        jPanel3.add(adminPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 910, 400));

        jTabbedPane1.addTab("ADMIN", jPanel3);

        jPanel4.setBackground(new java.awt.Color(128, 0, 0));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtFacultySearchAcct.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtFacultySearchAcct.setText("Search");
        txtFacultySearchAcct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFacultySearchAcctActionPerformed(evt);
            }
        });
        txtFacultySearchAcct.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFacultySearchAcctKeyReleased(evt);
            }
        });
        jPanel4.add(txtFacultySearchAcct, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 20, 390, 40));

        btnAddFacultyAccount.setBackground(new java.awt.Color(204, 255, 204));
        btnAddFacultyAccount.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAddFacultyAccount.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add_user.png"))); // NOI18N
        btnAddFacultyAccount.setText("ADD USER");
        btnAddFacultyAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddFacultyAccountActionPerformed(evt);
            }
        });
        jPanel4.add(btnAddFacultyAccount, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 60, -1, -1));

        btnDeleteFacultyAcct.setBackground(new java.awt.Color(255, 51, 51));
        btnDeleteFacultyAcct.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnDeleteFacultyAcct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/delete_icon.png"))); // NOI18N
        btnDeleteFacultyAcct.setText("DELETE");
        btnDeleteFacultyAcct.setEnabled(false);
        btnDeleteFacultyAcct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteFacultyAcctActionPerformed(evt);
            }
        });
        jPanel4.add(btnDeleteFacultyAcct, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 60, -1, -1));

        btnUpdateFacultyAcct.setBackground(new java.awt.Color(51, 102, 255));
        btnUpdateFacultyAcct.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnUpdateFacultyAcct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/update_icon.png"))); // NOI18N
        btnUpdateFacultyAcct.setText("UPDATE");
        btnUpdateFacultyAcct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateFacultyAcctActionPerformed(evt);
            }
        });
        jPanel4.add(btnUpdateFacultyAcct, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, -1));

        facultyAcctTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "FACULTY ID", "DEPARTMENT", "EMAIL", "FIRST NAME", "LASTNAME"
            }
        ));
        facultyAcctTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        facultyAcctTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                facultyAcctTableMouseClicked(evt);
            }
        });
        facultyAcctPane.setViewportView(facultyAcctTable);

        jPanel4.add(facultyAcctPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 910, 400));

        jTabbedPane1.addTab("FACULTY", jPanel4);

        panelBorder8.add(jTabbedPane1);
        jTabbedPane1.setBounds(10, 10, 850, 520);

        accountPage.add(panelBorder8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 940, 550));

        jLabel6.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 48)); // NOI18N
        jLabel6.setText("ACCOUNTS");
        accountPage.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 340, 50));

        cardPanel.add(accountPage, "card3");

        logsPage.setBackground(new java.awt.Color(255, 255, 255));
        logsPage.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelBorder9.setBackground(new java.awt.Color(128, 0, 0));

        logsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ROLE", "FULL NAME", "PROGRAM", "YEAR LEVEL", "REASON", "LOG IN TIME", "LOG OUT TIME"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        logsTable.setEnabled(false);
        logsTable.setRowSelectionAllowed(false);
        logsTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        logsTable.setShowGrid(true);
        logsPane.setViewportView(logsTable);

        panelBorder9.add(logsPane);
        logsPane.setBounds(10, 130, 930, 440);

        txtSearchLogs.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtSearchLogs.setText("Search");
        txtSearchLogs.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchLogsKeyReleased(evt);
            }
        });
        panelBorder9.add(txtSearchLogs);
        txtSearchLogs.setBounds(650, 10, 290, 30);

        logsPage.add(panelBorder9, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 79, 950, 580));

        jLabel5.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 48)); // NOI18N
        jLabel5.setText("LOGS");
        logsPage.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 170, 40));

        cardPanel.add(logsPage, "card4");

        jPanel1.add(cardPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 0, 1050, 670));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 13, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 667, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblDashboardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDashboardMouseClicked
        cardPanel.removeAll();
        cardPanel.add(homePage);
        cardPanel.repaint();
        cardPanel.revalidate();
    }//GEN-LAST:event_lblDashboardMouseClicked

    private void lblDashboardMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDashboardMouseEntered
        panelHome.setBackground(new Color(0, 0, 0, 50));
    }//GEN-LAST:event_lblDashboardMouseEntered

    private void lblDashboardMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDashboardMouseExited
        panelHome.setBackground(new Color(0, 0, 0, 0));
    }//GEN-LAST:event_lblDashboardMouseExited

    private void lblAccountsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAccountsMouseClicked
        cardPanel.removeAll();
        cardPanel.add(accountPage);
        cardPanel.repaint();
        cardPanel.revalidate();
    }//GEN-LAST:event_lblAccountsMouseClicked

    private void lblAccountsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAccountsMouseEntered
        panelAccounts.setBackground(new Color(0, 0, 0, 50));
    }//GEN-LAST:event_lblAccountsMouseEntered

    private void lblAccountsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAccountsMouseExited
        panelAccounts.setBackground(new Color(0, 0, 0, 0));
    }//GEN-LAST:event_lblAccountsMouseExited

    private void lblAllLogsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAllLogsMouseClicked
        cardPanel.removeAll();
        cardPanel.add(logsPage);
        cardPanel.repaint();
        cardPanel.revalidate();
    }//GEN-LAST:event_lblAllLogsMouseClicked

    private void lblAllLogsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAllLogsMouseEntered
        panelLogs.setBackground(new Color(0, 0, 0, 50));
    }//GEN-LAST:event_lblAllLogsMouseEntered

    private void lblAllLogsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAllLogsMouseExited
        panelLogs.setBackground(new Color(0, 0, 0, 0));
    }//GEN-LAST:event_lblAllLogsMouseExited

    private void lblLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLogoutMouseClicked
        System.out.println(getSfID());
        UserLogsDAO.userLogout(getSfID());
        dispose();
    }//GEN-LAST:event_lblLogoutMouseClicked

    private void lblLogoutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLogoutMouseEntered
        panelLogout.setBackground(new Color(0, 0, 0, 50));
    }//GEN-LAST:event_lblLogoutMouseEntered

    private void lblLogoutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLogoutMouseExited
        panelLogout.setBackground(new Color(0, 0, 0, 0));
    }//GEN-LAST:event_lblLogoutMouseExited

    private void btnDeleteStuAcctActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteStuAcctActionPerformed
        DefaultTableModel model = (DefaultTableModel) studentAcctTable.getModel();
        int selectedRow = studentAcctTable.getSelectedRow();
        if (selectedRow != 1) {
            String studentID = (String) model.getValueAt(selectedRow, 0);
            model.removeRow(selectedRow);
            AccountDAO.deleteAcct(studentID);
        }
    }//GEN-LAST:event_btnDeleteStuAcctActionPerformed

    private void studentAcctTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_studentAcctTableMouseClicked
        btnDeleteStuAcct.setEnabled(true);
    }//GEN-LAST:event_studentAcctTableMouseClicked

    private void btnAddStudentAcctActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddStudentAcctActionPerformed
        AddAccount dialog = new AddAccount(new javax.swing.JFrame(), true);
        dialog.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                System.exit(0);
            }
        });
        dialog.setVisible(true);
    }//GEN-LAST:event_btnAddStudentAcctActionPerformed

    private void txtStudentSearchAcctKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtStudentSearchAcctKeyReleased
        String search = txtStudentSearchAcct.getText();
        searchStudentAcct(search);
    }//GEN-LAST:event_txtStudentSearchAcctKeyReleased

    private void btnUpdateStudentAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateStudentAccountActionPerformed
        DefaultTableModel model = (DefaultTableModel) studentAcctTable.getModel();
        int selectedRow = studentAcctTable.getSelectedRow();

        if (selectedRow != -1) {
            // Get the values of each column in the selected row
            String studentID = (String) model.getValueAt(selectedRow, 0);
            String email = (String) model.getValueAt(selectedRow, 1);
            String firstName = (String) model.getValueAt(selectedRow, 2);
            String lastName = (String) model.getValueAt(selectedRow, 3);
            String program = (String) model.getValueAt(selectedRow, 4);
            String yearLevel = (String) model.getValueAt(selectedRow, 5);

            int id = LibraryMethods.getUserID(studentID);
            UpdateAcct updateDialog = new UpdateAcct(new javax.swing.JFrame(), true);
            updateDialog.setStudentData(id, studentID, email, firstName, lastName, program, yearLevel);
            updateDialog.setVisible(true);
            displayStudentAccount();
            System.out.println("bakit ayaw?");
        }
        displayStudentAccount();
        displayFacultyAccount();
        displayAdminAccount();
    }//GEN-LAST:event_btnUpdateStudentAccountActionPerformed

    private void btnDeleteFacultyAcctActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteFacultyAcctActionPerformed
        DefaultTableModel model = (DefaultTableModel) facultyAcctTable.getModel();
        int selectedRow = facultyAcctTable.getSelectedRow();
        if (selectedRow != 1) {
            String facultyID = (String) model.getValueAt(selectedRow, 0);
            model.removeRow(selectedRow);
            AccountDAO.deleteAcct(facultyID);
        } else {
            // lblWarningMessage.setText("Please Select a row you want to delete before hitting the button");
        }
    }//GEN-LAST:event_btnDeleteFacultyAcctActionPerformed

    private void btnAddFacultyAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddFacultyAccountActionPerformed
        AddAccount dialog = new AddAccount(new javax.swing.JFrame(), true);
        dialog.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                System.exit(0);
            }
        });
        dialog.setVisible(true);
    }//GEN-LAST:event_btnAddFacultyAccountActionPerformed

    private void txtFacultySearchAcctActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFacultySearchAcctActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFacultySearchAcctActionPerformed

    private void txtFacultySearchAcctKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFacultySearchAcctKeyReleased
        String search = txtFacultySearchAcct.getText();
        searchFacultyAcct(search);
    }//GEN-LAST:event_txtFacultySearchAcctKeyReleased

    private void facultyAcctTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_facultyAcctTableMouseClicked
        btnDeleteFacultyAcct.setEnabled(true);
    }//GEN-LAST:event_facultyAcctTableMouseClicked

    private void btnUpdateFacultyAcctActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateFacultyAcctActionPerformed
        DefaultTableModel model = (DefaultTableModel) facultyAcctTable.getModel();
        int selectedRow = facultyAcctTable.getSelectedRow();

        if (selectedRow != -1) {
            // Get the values of each column in the selected row
            String facultyAdminID = (String) model.getValueAt(selectedRow, 0);
            String department = (String) model.getValueAt(selectedRow, 1);
            String email = (String) model.getValueAt(selectedRow, 2);
            String firstName = (String) model.getValueAt(selectedRow, 3);
            String lastName = (String) model.getValueAt(selectedRow, 4);

            int id = LibraryMethods.getUserID(facultyAdminID);
            UpdateAcct updateDialog = new UpdateAcct(new javax.swing.JFrame(), true);
            updateDialog.setFacultyData(id, facultyAdminID, department, email, firstName, lastName);
            updateDialog.setVisible(true);
        }
        displayStudentAccount();
        displayFacultyAccount();
        displayAdminAccount();
    }//GEN-LAST:event_btnUpdateFacultyAcctActionPerformed

    private void adminAccountTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_adminAccountTableMouseClicked
        btnDeleteAdminAcct.setEnabled(true);
    }//GEN-LAST:event_adminAccountTableMouseClicked

    private void btnDeleteAdminAcctActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteAdminAcctActionPerformed
        DefaultTableModel model = (DefaultTableModel) adminAccountTable.getModel();
        int selectedRow = adminAccountTable.getSelectedRow();
        if (selectedRow != 1) {
            String adminID = (String) model.getValueAt(selectedRow, 0);
            model.removeRow(selectedRow);
            AccountDAO.deleteAcct(adminID);
            displayStudentAccount();
            displayFacultyAccount();
            displayAdminAccount();
        }
    }//GEN-LAST:event_btnDeleteAdminAcctActionPerformed

    private void txtAdminSearchAcctActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAdminSearchAcctActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAdminSearchAcctActionPerformed

    private void txtAdminSearchAcctKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAdminSearchAcctKeyReleased
        String search = txtAdminSearchAcct.getText();
        searchAdminAcct(search);
    }//GEN-LAST:event_txtAdminSearchAcctKeyReleased

    private void btnUpdateAdminAcctActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateAdminAcctActionPerformed
        DefaultTableModel model = (DefaultTableModel) adminAccountTable.getModel();
        int selectedRow = adminAccountTable.getSelectedRow();

        if (selectedRow != -1) {
            // Get the values of each column in the selected row
            String facultyAdminID = (String) model.getValueAt(selectedRow, 0);
            String firstName = (String) model.getValueAt(selectedRow, 1);
            String lastName = (String) model.getValueAt(selectedRow, 2);
            String email = (String) model.getValueAt(selectedRow, 3);

            int id = LibraryMethods.getUserID(facultyAdminID);
            UpdateAcct updateDialog = new UpdateAcct(new javax.swing.JFrame(), true);
            updateDialog.setAdminData(id, facultyAdminID, firstName, lastName, email);
            updateDialog.setVisible(true);
        }
        displayStudentAccount();
        displayFacultyAccount();
        displayAdminAccount();
    }//GEN-LAST:event_btnUpdateAdminAcctActionPerformed

    private void txtSearchLogsKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchLogsKeyReleased
        String search = txtSearchLogs.getText();
        searchUserLogs(search);
    }//GEN-LAST:event_txtSearchLogsKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel accountPage;
    private javax.swing.JTable activeUserNow;
    private javax.swing.JTable adminAccountTable;
    private javax.swing.JScrollPane adminPane;
    private javax.swing.JButton btnAddFacultyAccount;
    private javax.swing.JButton btnAddStudentAcct;
    private javax.swing.JButton btnDeleteAdminAcct;
    private javax.swing.JButton btnDeleteFacultyAcct;
    private javax.swing.JButton btnDeleteStuAcct;
    private javax.swing.JButton btnUpdateAdminAcct;
    private javax.swing.JButton btnUpdateFacultyAcct;
    private javax.swing.JButton btnUpdateStudentAccount;
    private javax.swing.JPanel cardPanel;
    private javax.swing.JScrollPane facultyAcctPane;
    private final javax.swing.JTable facultyAcctTable = new javax.swing.JTable();
    private javax.swing.JPanel homePage;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblAccounts;
    private javax.swing.JLabel lblAdminsName;
    private javax.swing.JLabel lblAllLogs;
    private javax.swing.JLabel lblDashboard;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblLogout;
    private javax.swing.JLabel lblNumberOfActive;
    private javax.swing.JLabel lblTopFiveLogs;
    private javax.swing.JLabel lblTotalNumberUsers;
    private javax.swing.JPanel logsPage;
    private javax.swing.JScrollPane logsPane;
    private javax.swing.JTable logsTable;
    private javax.swing.JTable mostLogsTable;
    private com.mycompany.finallibrarysystem.Design.PanelBorder panelAccounts;
    private com.mycompany.finallibrarysystem.Design.PanelBorder panelBorder1;
    private com.mycompany.finallibrarysystem.Design.PanelBorder panelBorder2;
    private com.mycompany.finallibrarysystem.Design.PanelBorder panelBorder3;
    private com.mycompany.finallibrarysystem.Design.PanelBorder panelBorder4;
    private com.mycompany.finallibrarysystem.Design.PanelBorder panelBorder5;
    private com.mycompany.finallibrarysystem.Design.PanelBorder panelBorder6;
    private com.mycompany.finallibrarysystem.Design.PanelBorder panelBorder7;
    private com.mycompany.finallibrarysystem.Design.PanelBorder panelBorder8;
    private com.mycompany.finallibrarysystem.Design.PanelBorder panelBorder9;
    private com.mycompany.finallibrarysystem.Design.PanelBorder panelHome;
    private com.mycompany.finallibrarysystem.Design.PanelBorder panelLogout;
    private com.mycompany.finallibrarysystem.Design.PanelBorder panelLogs;
    private javax.swing.JScrollPane scroll;
    private javax.swing.JScrollPane studentAcctPane;
    private javax.swing.JTable studentAcctTable;
    private javax.swing.JTextField txtAdminSearchAcct;
    private javax.swing.JTextField txtFacultySearchAcct;
    private javax.swing.JTextField txtSearchLogs;
    private javax.swing.JTextField txtStudentSearchAcct;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.qarisiqmallar.veneramarket;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author samil
 */
public class BorcYazmaq extends javax.swing.JFrame {

    /**
     * Creates new form BorcYazmaq
     */
    public void connect() throws Exception {

        Class.forName("com.mysql.cj.jdbc.Driver");

        con = DriverManager.getConnection("jdbc:mysql://localhost/mehsullar", "root", "dxdiag92");

    }

    public void sebetinSilinmesi() {

        try {
            connect();

            String query2 = "delete from sebet";

            stmt = con.createStatement();
            stmt.execute(query2);

        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void load() {

        int a;
        try {
            pres = con.prepareCall("select * from sebet");

            ResultSet rs = pres.executeQuery();

            ResultSetMetaData rd = rs.getMetaData();
            a = rd.getColumnCount();
            df = (DefaultTableModel) tblBorcSiyahisi.getModel();
            df.setRowCount(0);

            while (rs.next()) {
                Vector v2 = new Vector();
                for (int i = 0; i < a; i++) {
                    v2.add(rs.getString("Borc_alanin_adi"));
                    v2.add(rs.getString("Malin_adi"));
                    v2.add(rs.getInt("id"));
                    v2.add(rs.getDouble("Miqdari"));
                    v2.add(rs.getDouble("Satis_qiymeti"));
                    v2.add(rs.getDouble("Umumi_Mebleg"));
                    v2.add(rs.getDouble("Qismen_Odenis"));
                    Double s = rs.getDouble("Qaliq_borc");
                    v2.add(s);
                    v2.add(rs.getString("Tarix"));

                }
                df.addRow(v2);

            }

        } catch (Exception ex) {
            Logger.getLogger(Satici_Elave_Etmek.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public BorcYazmaq() throws SQLException, Exception {
        initComponents();
        connect();
        tableBorclar();

    }

    Connection con;
    PreparedStatement pres;
    Statement stmt;
    DefaultTableModel df;

    public void tableBorclar() throws SQLException {

        int a;

        String query222 = "SELECT s.id, s.Malin_adi, s.Miqdari, s.Satis_qiymeti, s.Umumi_Mebleg, s.Borc_alanin_adi, s.Qismen_Odenis, s.Qaliq_borc, s.Tarix from sebet s";
        stmt = con.createStatement();
        stmt.execute(query222);
        ResultSet rs = stmt.getResultSet();
        ResultSetMetaData rd = rs.getMetaData();
        a = rd.getColumnCount();
        df = (DefaultTableModel) tblBorcSiyahisi.getModel();
        df.setRowCount(0);

        while (rs.next()) {

            Vector v2 = new Vector();
            for (int i = 0; i < a; i++) {
                v2.add(rs.getString("Borc_alanin_adi"));
                v2.add(rs.getString("Malin_adi"));
                v2.add(rs.getInt("id"));
                v2.add(rs.getDouble("Miqdari"));
                v2.add(rs.getDouble("Satis_qiymeti"));
                v2.add(rs.getDouble("Umumi_Mebleg"));
                v2.add(rs.getDouble("Qismen_Odenis"));
                v2.add(rs.getDouble("Qaliq_borc"));

                Date s = rs.getDate("Tarix");
                v2.add(s);

            }
            df.addRow(v2);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtBorcAlaninAdi = new javax.swing.JTextField();
        txtMehsul = new javax.swing.JTextField();
        txtID = new javax.swing.JTextField();
        txtMiqdari = new javax.swing.JTextField();
        txtUmumiMebleg = new javax.swing.JTextField();
        txtQismenOdenis = new javax.swing.JTextField();
        txtQaliqBorc = new javax.swing.JTextField();
        txtQiymeti = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBorcSiyahisi = new javax.swing.JTable();
        txtUmumiBorc = new javax.swing.JTextField();
        txtBorc = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTextField11 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 51, 204));

        jPanel1.setBackground(new java.awt.Color(102, 0, 102));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Borca aldigi mehsulun adi");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Borc alanin adi");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("ID");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Miqdari");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Umumi meleg");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Qiymeti");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Qismen odenis");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Qaliq borc");

        txtBorcAlaninAdi.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        txtMehsul.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        txtID.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        txtMiqdari.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        txtUmumiMebleg.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        txtQismenOdenis.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtQismenOdenis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQismenOdenisActionPerformed(evt);
            }
        });
        txtQismenOdenis.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtQismenOdenisKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtQismenOdenisKeyTyped(evt);
            }
        });

        txtQaliqBorc.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        txtQiymeti.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        tblBorcSiyahisi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Borc alanin adi", "Mehsul", "ID", "Miqdari", "Qiymeti", "Umumi mebleg", "Qismen odenis", "Qaliq borc", "Borc alma tarixi"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblBorcSiyahisi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBorcSiyahisiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblBorcSiyahisi);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 691, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        txtUmumiBorc.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        txtUmumiBorc.setForeground(new java.awt.Color(255, 0, 0));
        txtUmumiBorc.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtBorc.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        txtBorc.setForeground(new java.awt.Color(255, 0, 0));
        txtBorc.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Axtar..");

        jTextField11.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtBorcAlaninAdi, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                            .addComponent(txtMehsul))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField11)
                        .addGap(18, 18, 18)
                        .addComponent(txtBorc, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtUmumiBorc, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtMiqdari, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                                .addComponent(txtQaliqBorc, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtQismenOdenis, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtUmumiMebleg, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtQiymeti, javax.swing.GroupLayout.Alignment.LEADING)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField11)
                            .addComponent(txtBorcAlaninAdi))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMehsul, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(txtUmumiBorc)
                    .addComponent(txtBorc))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMiqdari, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtQiymeti, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtUmumiMebleg, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtQismenOdenis, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtQaliqBorc, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18))
        );

        jButton1.setBackground(new java.awt.Color(51, 255, 51));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Borcu qeyd et");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(51, 255, 51));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Update");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(51, 255, 51));
        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Bağla");
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
        });
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(11, 11, 11))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tblBorcSiyahisiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBorcSiyahisiMouseClicked
        txtQismenOdenis.setText("");
        txtQaliqBorc.setText("");

        df = (DefaultTableModel) tblBorcSiyahisi.getModel();

        int selected = tblBorcSiyahisi.getSelectedRow();

        // String BorcAlaninAdi =(df.getValueAt(selected, 0).toString());
        // txtBorcAlaninAdi.setText(df.getValueAt(selected, 0).toString());
        txtMehsul.setText(df.getValueAt(selected, 1).toString());
        txtID.setText(df.getValueAt(selected, 2).toString());
        txtMiqdari.setText(df.getValueAt(selected, 3).toString());
        txtQiymeti.setText(df.getValueAt(selected, 4).toString());
        txtUmumiMebleg.setText(df.getValueAt(selected, 5).toString());
        //txtQismenOdenis.setText(df.getValueAt(selected, 6).toString());
        // txtQaliqBorc.setText(df.getValueAt(selected, 7).toString());


    }//GEN-LAST:event_tblBorcSiyahisiMouseClicked

    private void txtQismenOdenisKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtQismenOdenisKeyReleased


    }//GEN-LAST:event_txtQismenOdenisKeyReleased

    private void txtQismenOdenisKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtQismenOdenisKeyTyped

    }//GEN-LAST:event_txtQismenOdenisKeyTyped

    private void txtQismenOdenisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQismenOdenisActionPerformed
        double umumiBorc = Double.parseDouble(txtUmumiMebleg.getText());
        double borcdanOdenis = Double.parseDouble(txtQismenOdenis.getText());
        double netice = umumiBorc - borcdanOdenis;

        txtQaliqBorc.setText(Double.toString(netice));

        txtBorc.setText("");
        txtBorc.setText(Double.toString(netice));

        boolean yoxla = txtUmumiBorc.getText().isEmpty();

        if (yoxla != true) {

            double txtumumiBorc = Double.parseDouble(txtUmumiBorc.getText());
            double netice2 = txtumumiBorc + netice;
            txtUmumiBorc.setText(Double.toString(netice2));

        } else {

            txtUmumiBorc.setText(Double.toString(netice));
        }

    }//GEN-LAST:event_txtQismenOdenisActionPerformed

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        // bura
        try {
            if (txtBorcAlaninAdi.getText().isEmpty() || txtMehsul.getText().isEmpty() || txtID.getText().isEmpty() || txtMiqdari.getText().isEmpty() || txtQiymeti.getText().isEmpty() || txtUmumiMebleg.getText().isEmpty() || txtQismenOdenis.getText().isEmpty()) {

                JOptionPane.showMessageDialog(this, "Zəhmət olmasa bütün məlumatları doldurun");
            } else {
                String BorcAlaninAdi = txtBorcAlaninAdi.getText();
                String Mehsul = txtMehsul.getText();
                int ID = Integer.parseInt(txtID.getText());
                double Miqdari = Double.parseDouble(txtMiqdari.getText());
                double Qiymeti = Double.parseDouble(txtQiymeti.getText());
                double UmumiMebleg = Double.parseDouble(txtUmumiMebleg.getText());
                double QismenOdenis = Double.parseDouble(txtQismenOdenis.getText());
                double QaliqBorc = Double.parseDouble(txtQaliqBorc.getText());

                pres = con.prepareStatement("update sebet set id = ?,  Malin_adi = ?, Miqdari=?, Satis_qiymeti =?, Umumi_Mebleg=?, Borc_alanin_adi=?, Qismen_Odenis=?, Qaliq_borc =? where id = ?");

                pres.setInt(1, ID);
                pres.setString(2, Mehsul);
                pres.setDouble(3, Miqdari);
                pres.setDouble(4, Qiymeti);
                pres.setDouble(5, UmumiMebleg);
                pres.setString(6, BorcAlaninAdi);
                pres.setDouble(7, QismenOdenis);
                pres.setDouble(8, QaliqBorc);
                pres.setInt(9, ID);

                pres.executeUpdate();

                pres = con.prepareStatement("update mehsullar set Satis_miqdari = Satis_miqdari + ?  where id = ?;");
                pres.setDouble(1, Miqdari);
                pres.setInt(2, ID);
                pres.executeUpdate();

                pres = con.prepareStatement("update mehsullar set Qaliq_say = Miqdari - Satis_miqdari  where id = ?;");
                pres.setInt(1, ID);
                pres.executeUpdate();
                
//                pres = con.prepareStatement("truncate table sebet;");
//                pres.executeUpdate();

//                 String query = "insert into satilan_mallar ( id, Malin_adi, Miqdari, Satis_qiymeti, Umumi_Mebleg, Satis_Tarixi, Borc_Alanin_Adi,OdenisinNovu, QiemenOdenis, Borcdan_Gelen) values(?,?,?,?,?,?,?,?,?,?)";
//
//                            pres = con.prepareStatement(query);
//                            pres.setInt(1, 0);
//                            pres.setString(2, "Borcdan-" + Mehsul);
//                            pres.setInt(3, Miqdari);
//                            pres.setDouble(4, Qiymeti);
//                            pres.setDouble(5, UmumiMebleg);
//                            pres.setString(6, SatisTarixi);
//                            pres.setString(7, borcAlaninAdi);
//                            pres.setString(8, "Borcdan gələn");
//                            pres.setDouble(9, qismenOdenis);
//                            pres.setDouble(10, umumimebleg);
//
//                            pres.execute();
                JOptionPane.showMessageDialog(this, "Borc qeyd olundu");

            }
            load();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked

        df = (DefaultTableModel) tblBorcSiyahisi.getModel();
        if (df.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "Səbət boşdur!");
        } else {

            int ID;
            double Qiymeti, UmumiMebleg, QismenOdenis, QaliqBorc , Miqdari;
            String BorcAlaninAdi, Mehsul, Tarix;
            try {
                connect();

                for (int i = 0; i < df.getRowCount(); i++) {

                    BorcAlaninAdi = df.getValueAt(i, 0).toString();
                    Mehsul = df.getValueAt(i, 1).toString();
                    ID = Integer.parseInt(df.getValueAt(i, 2).toString());
                    Miqdari = Double.parseDouble(df.getValueAt(i, 3).toString());
                    Qiymeti = Double.parseDouble(df.getValueAt(i, 4).toString());
                    UmumiMebleg = Double.parseDouble(df.getValueAt(i, 5).toString());
                    QismenOdenis = Double.parseDouble(df.getValueAt(i, 6).toString());
                    QaliqBorc = Double.parseDouble(df.getValueAt(i, 7).toString());
                    Tarix = df.getValueAt(i, 8).toString();

                    String query = "insert into borclar_siyahisi( Borc_alanin_adi, Borca_goturduyu_mehsul, Mehsul_ID, Miqdari, Qiymeti, Umumi_mebleg, Qismen_odenis, Qaliq_borc, Borc_alma_tarixi ) values(?,?,?,?,?,?,?,?,?)";

                    pres = con.prepareStatement(query);
                    pres.setString(1, BorcAlaninAdi);
                    pres.setString(2, Mehsul);
                    pres.setInt(3, ID);
                    pres.setDouble(4, Miqdari);
                    pres.setDouble(5, Qiymeti);
                    pres.setDouble(6, UmumiMebleg);
                    pres.setDouble(7, QismenOdenis);
                    pres.setDouble(8, QaliqBorc);
                    pres.setString(9, Tarix);
                    pres.execute();
                

//                df = (DefaultTableModel) tblBorcSiyahisi.getModel();
//
//                double qaliqBorc, qiymeti, umumiMebleg, qismenOdenis;
//                String borcAlaninAdi2, Mehsul2, SatisTarixi;
//                int MehsulID2, Miqdari2;

//                for (int i = 0; i < df.getRowCount(); i++) {
//
//                    qaliqBorc = Double.parseDouble(df.getValueAt(i, 7).toString());
//                    umumiMebleg = Double.parseDouble(df.getValueAt(i, 5).toString());
//
//                    borcAlaninAdi2 = df.getValueAt(i, 0).toString();
//                    Mehsul2 = df.getValueAt(i, 1).toString();
//                    MehsulID2 = Integer.parseInt(df.getValueAt(i, 2).toString());
//                    Miqdari2 = Integer.parseInt(df.getValueAt(i, 4).toString());
//                    qiymeti = Double.parseDouble(df.getValueAt(i, 5).toString());
//                    umumiMebleg = Double.parseDouble(df.getValueAt(i, 6).toString());
//                    qismenOdenis = Double.parseDouble(df.getValueAt(i, 7).toString());
//                    SatisTarixi = df.getValueAt(i, 10).toString();

                    if ( QaliqBorc != UmumiMebleg) {

                        String query2 = "insert into satilan_mallar ( id, Malin_adi, Miqdari, Satis_qiymeti, Umumi_Mebleg, Satis_Tarixi, Borc_Alanin_Adi,OdenisinNovu, QiemenOdenis, Borcdan_Gelen) values(?,?,?,?,?,?,?,?,?,?)";

                        pres = con.prepareStatement(query2);
                        pres.setInt(1, 0);
                        pres.setString(2, "Borcdan-" + Mehsul);
                        pres.setDouble(3, Miqdari);
                        pres.setDouble(4, Qiymeti);
                        pres.setDouble(5, UmumiMebleg);
                        pres.setString(6, Tarix);
                        pres.setString(7, BorcAlaninAdi);
                        pres.setString(8, "Borcdan gələn");
                        pres.setDouble(9, QismenOdenis);
                        pres.setDouble(10, UmumiMebleg);

                        pres.execute();

                    }
                }
                

                sebetinSilinmesi();

                JOptionPane.showMessageDialog(this, "Borc qeyd olundu!");

                df.setRowCount(0);

            } catch (Exception ex) {

                System.out.println(ex);

            }

        }
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked

        this.setVisible(false);

    }//GEN-LAST:event_jButton4MouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(BorcYazmaq.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BorcYazmaq.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BorcYazmaq.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BorcYazmaq.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new BorcYazmaq().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(BorcYazmaq.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(BorcYazmaq.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTable tblBorcSiyahisi;
    private javax.swing.JTextField txtBorc;
    private javax.swing.JTextField txtBorcAlaninAdi;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtMehsul;
    private javax.swing.JTextField txtMiqdari;
    private javax.swing.JTextField txtQaliqBorc;
    private javax.swing.JTextField txtQismenOdenis;
    private javax.swing.JTextField txtQiymeti;
    private javax.swing.JTextField txtUmumiBorc;
    private javax.swing.JTextField txtUmumiMebleg;
    // End of variables declaration//GEN-END:variables
}

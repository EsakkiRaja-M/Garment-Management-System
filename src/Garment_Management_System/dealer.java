/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Garment_Management_System;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.HeadlessException;
import java.sql.*;
;

/**
 *
 * @author HP
 */
public class dealer extends javax.swing.JFrame {
   Connection con=null;
        PreparedStatement st=null;
        ResultSet rs=null;

    public dealer() {
        initComponents();
        Selectseller();
    }   
    public void Selectseller(){
     
    try {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "ur_password");
        st = con.prepareStatement("SELECT * FROM dealer_proj");
        rs = st.executeQuery();
        ResultSetMetaData rsmd = rs.getMetaData();

        DefaultTableModel tbl = new DefaultTableModel();

        int col = rsmd.getColumnCount();
        String[] colname = new String[col];
        for (int i = 0; i < col; i++) {
            colname[i] = rsmd.getColumnName(i + 1);
        }

        tbl.setColumnIdentifiers(colname);

        while (rs.next()) {
            String id = String.valueOf(rs.getInt(1));
            String name = rs.getString(2);
            String password = rs.getString(3);
            String gender = rs.getString(4);

            String[] tdata = {id, name, password, gender};
            tbl.addRow(tdata);
        }

        // Set the new model to the JTable
        tablesell.setModel(tbl);

        con.close();
    } catch (Exception e) {
        System.out.println(e.getMessage());
    }


    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        sellname = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        sellid = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        sellpassword = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        sellgen = new javax.swing.JComboBox<>();
        addbtn = new javax.swing.JButton();
        editbtn = new javax.swing.JButton();
        clrbtn = new javax.swing.JButton();
        delbtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablesell = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Stencil Std", 1, 36)); // NOI18N
        jLabel2.setText("DEALER DEATILS");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("ID");

        sellname.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        sellname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sellnameActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("NAME");

        sellid.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        sellid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sellidActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("CITY");

        sellpassword.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        sellpassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sellpasswordActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("GENDER");

        sellgen.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        sellgen.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));
        sellgen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sellgenActionPerformed(evt);
            }
        });

        addbtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        addbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Garment_Management_System/images/add.png"))); // NOI18N
        addbtn.setText("ADD");
        addbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addbtnMouseClicked(evt);
            }
        });
        addbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addbtnActionPerformed(evt);
            }
        });

        editbtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        editbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Garment_Management_System/images/save.png"))); // NOI18N
        editbtn.setText("EDIT");
        editbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editbtnMouseClicked(evt);
            }
        });
        editbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editbtnActionPerformed(evt);
            }
        });

        clrbtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        clrbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Garment_Management_System/images/Reset.png"))); // NOI18N
        clrbtn.setText("RESET");
        clrbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clrbtnMouseClicked(evt);
            }
        });
        clrbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clrbtnActionPerformed(evt);
            }
        });

        delbtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        delbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Garment_Management_System/images/delete.png"))); // NOI18N
        delbtn.setText("DELETE");
        delbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                delbtnMouseClicked(evt);
            }
        });
        delbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delbtnActionPerformed(evt);
            }
        });

        tablesell.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tablesell.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tablesell.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NAME", "CITY", "GENDER"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablesell.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tablesell.setSelectionBackground(new java.awt.Color(204, 204, 255));
        tablesell.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablesellMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablesell);
        if (tablesell.getColumnModel().getColumnCount() > 0) {
            tablesell.getColumnModel().getColumn(0).setResizable(false);
            tablesell.getColumnModel().getColumn(1).setResizable(false);
            tablesell.getColumnModel().getColumn(2).setResizable(false);
            tablesell.getColumnModel().getColumn(3).setResizable(false);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel2))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(clrbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(addbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(delbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(editbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel7))
                                        .addGap(30, 30, 30))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(23, 23, 23)))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(sellgen, 0, 115, Short.MAX_VALUE)
                                    .addComponent(sellpassword)
                                    .addComponent(sellname)
                                    .addComponent(sellid))
                                .addGap(17, 17, 17)))))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(13, 13, 13)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(sellid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(sellname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(62, 62, 62)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(sellpassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(62, 62, 62)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sellgen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(62, 62, 62)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(editbtn)
                            .addComponent(addbtn))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(clrbtn)
                            .addComponent(delbtn))
                        .addGap(21, 21, 21))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Garment_Management_System/images/new product.png"))); // NOI18N
        jLabel11.setText("PRODUCT");
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel11MouseEntered(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Garment_Management_System/images/details product.png"))); // NOI18N
        jLabel12.setText("CATEGORY");
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Garment_Management_System/images/logout.png"))); // NOI18N
        jLabel13.setText("LOGOUT");
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Garment_Management_System/images/Close.png"))); // NOI18N
        jLabel1.setText("QUIT");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel11)
                .addGap(66, 66, 66)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addGap(49, 49, 49)
                .addComponent(jLabel1)
                .addGap(41, 41, 41))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sellnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sellnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sellnameActionPerformed

    private void sellidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sellidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sellidActionPerformed

    private void sellpasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sellpasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sellpasswordActionPerformed

    private void sellgenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sellgenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sellgenActionPerformed

    private void addbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addbtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addbtnActionPerformed

    private void editbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editbtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editbtnActionPerformed

    private void delbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delbtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_delbtnActionPerformed

    private void clrbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clrbtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_clrbtnActionPerformed

    private void addbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addbtnMouseClicked
    if (sellid.getText().isEmpty() || sellname.getText().isEmpty() || sellpassword.getText().isEmpty()) {
        JOptionPane.showMessageDialog(this, "PLEASE FILL DEATILS");
    } else {
        try {
           // Class.forName("oracle.jdbc.driver.OracleDriver");
        con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "ur_password");
            String sql = "{CALL insert_dealer(?, ?, ?, ?)}";
            CallableStatement callableStatement = con.prepareCall(sql);
                // Set parameter values
                callableStatement.setInt(1, Integer.valueOf(sellid.getText()));
            callableStatement.setString(2, sellname.getText());
            callableStatement.setString(3, sellpassword.getText());
            callableStatement.setString(4, sellgen.getSelectedItem().toString());

              
          int rowsAffected =  callableStatement.executeUpdate();
                            
         

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "DEALER INSERTED");
                Selectseller();
            } else {
                JOptionPane.showMessageDialog(null, "INSERTION FAILED");
            }

            con.close();
           
        }
     catch (HeadlessException | SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }}
    }//GEN-LAST:event_addbtnMouseClicked

    private void tablesellMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablesellMouseClicked
      DefaultTableModel model = (DefaultTableModel) tablesell.getModel();
    int myindex = tablesell.getSelectedRow();
    sellid.setText(model.getValueAt(myindex, 0).toString());
    sellname.setText(model.getValueAt(myindex, 1).toString());
    sellpassword.setText(model.getValueAt(myindex, 2).toString());    
    }//GEN-LAST:event_tablesellMouseClicked

    private void clrbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clrbtnMouseClicked
      sellid.setText("");
      sellname.setText("");
      sellpassword.setText("");
    }//GEN-LAST:event_clrbtnMouseClicked

    private void delbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_delbtnMouseClicked
        if (sellid.getText().isEmpty()) {
        JOptionPane.showMessageDialog(null, "ENTER DEALER ID");
    } else {
        try {
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "ur_password");
            String sid = sellid.getText();
            String query = "DELETE FROM dealer_proj WHERE ID=?";
            try (PreparedStatement pstmt = con.prepareStatement(query)) {
                pstmt.setInt(1, Integer.parseInt(sid));
                pstmt.executeUpdate();
            }
            Selectseller();
            JOptionPane.showMessageDialog(null, "DEALER DELETED");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error :" + e.getMessage());
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    }//GEN-LAST:event_delbtnMouseClicked

    private void editbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editbtnMouseClicked
       if (sellid.getText().isEmpty() || sellname.getText().isEmpty() || sellpassword.getText().isEmpty()) {
        JOptionPane.showMessageDialog(null, "PLEASE FILL DEATILS");
    } else {
        try {
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "ur_password");
            String query = "update dealer_proj set NAME='" +sellname.getText()+ "',CITY='" +sellpassword.getText()+ "',GENDER='" +sellgen.getSelectedItem().toString()+ "' where ID="+sellid.getText();
            Statement add=con.createStatement();
            add.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "DEALER UPDATED");
            Selectseller();
        }
        catch(SQLException e){
             e.printStackTrace();
        }   }
    }//GEN-LAST:event_editbtnMouseClicked

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        new Product().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel11MouseClicked

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
      new category().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel12MouseClicked

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
       int exit=JOptionPane.showConfirmDialog(null, "ARE YOU SURE YOU WANT TO LOGOUT");
       if(exit==0){
            setVisible(false);
            new login().setVisible(true);
    } 
    }//GEN-LAST:event_jLabel13MouseClicked

    private void jLabel11MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel11MouseEntered

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
int exit=JOptionPane.showConfirmDialog(null, "ARE YOU SURE YOU WANT TO EXIT?");
       if(exit==0){
            JOptionPane.showMessageDialog(null, "Thank You :)");
        System.exit(0);
    }         // TODO add your handling code here:
    }//GEN-LAST:event_jLabel1MouseClicked

  public static void main(String args[]) {
        
        try {
            System.setProperty("java.util.logging.ConsoleHandler.level", "FINEST");

            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dealer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            new dealer().setVisible(true);
        });
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addbtn;
    private javax.swing.JButton clrbtn;
    private javax.swing.JButton delbtn;
    private javax.swing.JButton editbtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> sellgen;
    private javax.swing.JTextField sellid;
    private javax.swing.JTextField sellname;
    private javax.swing.JTextField sellpassword;
    private javax.swing.JTable tablesell;
    // End of variables declaration//GEN-END:variables
}

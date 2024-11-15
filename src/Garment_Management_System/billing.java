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



        
public class billing extends javax.swing.JFrame {

        Connection con=null;
        PreparedStatement st=null;
        ResultSet rs=null;
    public billing() {
        initComponents();
        SelectProduct();
        getcat();
    }
    public void SelectProduct() {
    try {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "ur_password");
        st = con.prepareStatement("SELECT * FROM product_proj");
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
            String pid = String.valueOf(rs.getInt(1));
            String pname = rs.getString(2);
            String pqunatity = String.valueOf(rs.getInt(3));
            String pprice = String.valueOf(rs.getInt(4));
            String pcate = rs.getString(5); 
            String[] tdata = {pid, pname, pqunatity, pprice, pcate};
            tbl.addRow(tdata);
        }
        producttable.setModel(tbl);
        con.close();
    } catch (Exception e) {
        System.out.println(e.getMessage());
    }
}
    int prid,newq;
public void update(){
    try {
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "ur_password");
            String query = "UPDATE product_proj SET QUANTITY=? WHERE ID=?";
            try (PreparedStatement pstmt = con.prepareStatement(query)) {
              
                pstmt.setInt(1, newq);
                pstmt.setInt(2, prid);
                int rowsAffected = pstmt.executeUpdate();

                if (rowsAffected > 0) {
                    SelectProduct();
                } else {
                    JOptionPane.showMessageDialog(null, "NO DATA FOUND ");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error " + e.getMessage());
        }
}
private void getcat(){
    try {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "ur_password");
        st = con.prepareStatement("SELECT * FROM category_proj");
        rs = st.executeQuery();
        while(rs.next()){
            String mycat = rs.getString("name");
            pcate.addItem(mycat);
        }
    } catch (Exception e) {
        System.out.println(e.getMessage());
    }
}
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jProgressBar1 = new javax.swing.JProgressBar();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        quantity = new javax.swing.JTextField();
        clrbtn = new javax.swing.JButton();
        delbtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        producttable = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        biltxt = new javax.swing.JTextArea();
        pcate = new javax.swing.JComboBox<>();
        billbtn = new javax.swing.JButton();
        delbtn1 = new javax.swing.JButton();
        gtotb = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Stencil Std", 1, 36)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Garment_Management_System/images/billing frame.png"))); // NOI18N
        jLabel2.setText("BILL");

        name.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("NAME");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("QUANTITY");

        quantity.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        quantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quantityActionPerformed(evt);
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
        delbtn.setText("RESET");
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

        producttable.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        producttable.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        producttable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NAME", "QUANTITY", "PRICE", "CATEGORY"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        producttable.setIntercellSpacing(new java.awt.Dimension(1, 1));
        producttable.setRowHeight(25);
        producttable.setSelectionBackground(new java.awt.Color(204, 204, 255));
        producttable.setSelectionForeground(new java.awt.Color(255, 255, 255));
        producttable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                producttableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(producttable);
        if (producttable.getColumnModel().getColumnCount() > 0) {
            producttable.getColumnModel().getColumn(0).setResizable(false);
            producttable.getColumnModel().getColumn(1).setResizable(false);
            producttable.getColumnModel().getColumn(2).setResizable(false);
            producttable.getColumnModel().getColumn(3).setResizable(false);
            producttable.getColumnModel().getColumn(4).setResizable(false);
        }

        biltxt.setColumns(20);
        biltxt.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        biltxt.setRows(5);
        jScrollPane2.setViewportView(biltxt);

        pcate.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        pcate.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                pcateItemStateChanged(evt);
            }
        });
        pcate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pcateMouseClicked(evt);
            }
        });
        pcate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pcateActionPerformed(evt);
            }
        });

        billbtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        billbtn.setText("PREVIEW");
        billbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                billbtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                billbtnMouseEntered(evt);
            }
        });
        billbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                billbtnActionPerformed(evt);
            }
        });

        delbtn1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        delbtn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Garment_Management_System/images/print.png"))); // NOI18N
        delbtn1.setText("PRINT");
        delbtn1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                delbtn1MouseClicked(evt);
            }
        });
        delbtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delbtn1ActionPerformed(evt);
            }
        });

        gtotb.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        gtotb.setText("RS");

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("FILTER");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(58, 58, 58)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(jLabel2))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addComponent(billbtn)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(pcate, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton1)
                                .addGap(28, 28, 28)
                                .addComponent(delbtn))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(quantity, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(name, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(clrbtn)
                                        .addGap(44, 44, 44)))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 469, Short.MAX_VALUE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(gtotb)
                                .addGap(122, 122, 122)
                                .addComponent(delbtn1))
                            .addComponent(jScrollPane2))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(delbtn, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(pcate, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1))))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(delbtn1)
                            .addComponent(gtotb))
                        .addGap(12, 12, 12))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(72, 72, 72)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(quantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(billbtn)
                            .addComponent(clrbtn))
                        .addGap(62, 62, 62)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Garment_Management_System/images/logout.png"))); // NOI18N
        jLabel12.setText("LOGOUT");
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
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

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Garment_Management_System/images/new product.png"))); // NOI18N
        jLabel7.setText("PRODUCT");
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Garment_Management_System/images/buyer Details.png"))); // NOI18N
        jLabel8.setText("DEALER");
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Garment_Management_System/images/details product.png"))); // NOI18N
        jLabel9.setText("CATEGORY");
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)))
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jLabel7)
                .addGap(41, 41, 41)
                .addComponent(jLabel8)
                .addGap(49, 49, 49)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel12)
                .addGap(51, 51, 51)
                .addComponent(jLabel1)
                .addGap(36, 36, 36))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameActionPerformed

    private void quantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quantityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_quantityActionPerformed

    private void clrbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clrbtnMouseClicked
      
        name.setText("");
        quantity.setText("");
    }//GEN-LAST:event_clrbtnMouseClicked

    private void clrbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clrbtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_clrbtnActionPerformed

    private void delbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_delbtnMouseClicked
    SelectProduct();
    }//GEN-LAST:event_delbtnMouseClicked

    private void delbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delbtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_delbtnActionPerformed
Double uprice,prodtot=0.0,gtot=0.0;int aquan;
    private void producttableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_producttableMouseClicked
    DefaultTableModel model = (DefaultTableModel) producttable.getModel();
    int myindex = producttable.getSelectedRow();
    prid = Integer.valueOf(model.getValueAt(myindex, 0).toString());
    aquan = Integer.valueOf(model.getValueAt(myindex, 2).toString());
   
    uprice = Double.valueOf(model.getValueAt(myindex, 3).toString());
    name.setText(model.getValueAt(myindex, 1).toString());
    }//GEN-LAST:event_producttableMouseClicked

    private void pcateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pcateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pcateActionPerformed
int i=0;
    private void billbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_billbtnMouseClicked
    String quantityText = quantity.getText().trim();
    if (!quantityText.isEmpty() && quantityText.matches("\\d+")) {
        int quantityValue = Integer.parseInt(quantityText);
        prodtot = uprice * quantityValue;
         newq = aquan - Integer.valueOf(quantity.getText());
    } else {
        
        JOptionPane.showMessageDialog(this, "QUANTITY INVALID");

    }
    if(quantity.getText().isEmpty()||name.getText().isEmpty())
    {
         JOptionPane.showMessageDialog(this, "PLEASE FILL DETAILS");
    }else if(aquan<=Integer.valueOf(quantity.getText())){
        JOptionPane.showMessageDialog(this, "NOT ENOUGH STOCK");
    }
    else{
        i++;
        gtot = gtot + prodtot;
        if(i==1){
            biltxt.setText(biltxt.getText()+"        ~~~~~~~~~~SENTEX TRADERS~~~~~~~~~~        \n\n"+" NUM      PRODUCT      PRICE      QUANTITY      TOTAL\n"+i+"            " +name.getText()+"          "+uprice+"               "+quantity.getText()+"             " +prodtot+"\n");
            
        }else{
            biltxt.setText(                   biltxt.getText()+i+"             "+name.getText()+"            "+uprice+"             "+quantity.getText()+"            "+prodtot+"\n");
             
        }
        gtotb.setText("RS "+gtot);
        update();
    }
    }//GEN-LAST:event_billbtnMouseClicked

    private void billbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_billbtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_billbtnActionPerformed

    private void delbtn1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_delbtn1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_delbtn1MouseClicked

    private void delbtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delbtn1ActionPerformed
try{

biltxt.print();
}  catch(Exception e){}      // TODO add your handling code here:
    }//GEN-LAST:event_delbtn1ActionPerformed

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        int exit=JOptionPane.showConfirmDialog(null, "ARE YOU SURE YOU WANT TO LOGOUT");
       if(exit==0){
            setVisible(false);
            new login().setVisible(true);
    } 
    }//GEN-LAST:event_jLabel12MouseClicked

    private void pcateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pcateMouseClicked
    
    }//GEN-LAST:event_pcateMouseClicked

    private void pcateItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_pcateItemStateChanged
       
    }//GEN-LAST:event_pcateItemStateChanged

    private void billbtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_billbtnMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_billbtnMouseEntered

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
 try {
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "ur_password");

            // Using parameterized query to avoid SQL injection
            st = con.prepareStatement("SELECT * FROM product_proj WHERE CATEGORY = ?");
            st.setString(1, pcate.getSelectedItem().toString()); 

            rs = st.executeQuery();

            // Get ResultSet metadata to get column names
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();

            // Create a DefaultTableModel with column names
            DefaultTableModel model = new DefaultTableModel();
            for (int i = 1; i <= columnCount; i++) {
                model.addColumn(rsmd.getColumnName(i));
            }

            // Populate the model with data
            while (rs.next()) {
                Object[] rowData = new Object[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    rowData[i - 1] = rs.getObject(i);
                }
                model.addRow(rowData);
            }

            // Set the model to your JTable
            producttable.setModel(model);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close resources (ResultSet, PreparedStatement, and Connection)
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
new Product().setVisible(true);
     this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel7MouseClicked

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
new category().setVisible(true);
     this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel9MouseClicked

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
new dealer().setVisible(true);
     this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel8MouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
int exit=JOptionPane.showConfirmDialog(null, "ARE YOU SURE YOU WANT TO EXIT?");
       if(exit==0){
            JOptionPane.showMessageDialog(null, "Thank You :)");
        System.exit(0);
    }         // TODO add your handling code here:
    }//GEN-LAST:event_jLabel1MouseClicked

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
            java.util.logging.Logger.getLogger(billing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(billing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(billing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(billing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new billing().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton billbtn;
    private javax.swing.JTextArea biltxt;
    private javax.swing.JButton clrbtn;
    private javax.swing.JButton delbtn;
    private javax.swing.JButton delbtn1;
    private javax.swing.JLabel gtotb;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField name;
    private javax.swing.JComboBox<String> pcate;
    private javax.swing.JTable producttable;
    private javax.swing.JTextField quantity;
    // End of variables declaration//GEN-END:variables
}

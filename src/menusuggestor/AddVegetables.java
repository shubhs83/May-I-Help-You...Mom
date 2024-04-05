
package menusuggestor;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.awt.event.KeyEvent;


public class AddVegetables extends javax.swing.JFrame {
    
    private void clearFields() {
    txtVdate.setDate(null);
    txtVweight.setText("");
    txtVunit.setSelectedIndex(0);
    txtUB.setDate(null);
}
    public AddVegetables() {
        initComponents();
        Connect();
        LoadVegNo();
        fetch();
        txtId.setSelectedItem(null);
        
        
       Color customColor = new Color(225,205,225);
       
       btnAdd.setBackground(Color.cyan);
       btnUpdate.setBackground(Color.cyan);
       btnDelete.setBackground(Color.cyan);
       btnBack.setBackground(Color.cyan);
       btnSearch.setBackground(Color.cyan);

      label1.setForeground(Color.BLACK);
      label2.setForeground(Color.BLACK);
      label3.setForeground(Color.BLACK);
      label4.setForeground(Color.BLACK);
      label5.setForeground(Color.BLACK);
      label6.setForeground(Color.BLACK);

      jTable1.setSelectionBackground(Color.YELLOW);
      getContentPane().setBackground(customColor);
      
        txtVname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtVnameKeyTyped(evt);
            }
        });
        
        txtVweight.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtVweightKeyTyped(evt);
            }
        });
    }

    private void txtVnameKeyTyped(java.awt.event.KeyEvent evt) {
        char c = evt.getKeyChar();
        if (!Character.isLetter(c) && c != KeyEvent.VK_BACK_SPACE && c != KeyEvent.VK_DELETE) {
            evt.consume();
        }
    }

  private void txtVweightKeyTyped(java.awt.event.KeyEvent evt) {
    char c = evt.getKeyChar();

    if (!Character.isDigit(c) && c != KeyEvent.VK_BACK_SPACE && c != KeyEvent.VK_DELETE && c != '.' && txtVweight.getText().contains(".")) {
        evt.consume();
    }
}
    
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    
    public void Connect(){
       
        try {
            Class.forName("com.mysql.jdbc.Driver");
              con = DriverManager.getConnection("jdbc:mysql://localhost/msuggestion","root","shubhs#R83");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AddVegetables.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AddVegetables.class.getName()).log(Level.SEVERE, null, ex);
        }
               
    }
    
        
    public void LoadVegNo(){ 
        try {
            pst =con.prepareStatement("SELECT id from vegetable_tbl ");
            rs=pst.executeQuery();
            txtId.removeAllItems();
            while(rs.next()){
                txtId.addItem(rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AddVegetables.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
   
  private void fetch() {
    try {
        int q;
        pst = con.prepareStatement("SELECT * FROM vegetable_tbl ORDER BY use_before");
        rs = pst.executeQuery();
        ResultSetMetaData rss = rs.getMetaData();
        q = rss.getColumnCount();

        DefaultTableModel df = (DefaultTableModel) jTable1.getModel();
        df.setRowCount(0);
        while (rs.next()) {
            Vector v2 = new Vector();
            for (int a = 1; a <= q; a++) {
                v2.add(rs.getString("id"));
                v2.add(rs.getString("date"));
                v2.add(rs.getString("name"));
                v2.add(rs.getString("weight"));
                v2.add(rs.getString("unit"));
                v2.add(rs.getString("use_before"));
            }
            df.addRow(v2);
        }
    } catch (SQLException ex) {
        Logger.getLogger(AddVegetables.class.getName()).log(Level.SEVERE, null, ex);
    }
}

    private void txtVnameKeyReleased(java.awt.event.KeyEvent evt) {
        searchVegetable();
    }

    private void searchVegetable() {
        try {
            String vegName = txtVname.getText();

            pst = con.prepareStatement("SELECT * FROM vegetable_tbl WHERE name LIKE ?");
            pst.setString(1, "%" + vegName + "%");
            rs = pst.executeQuery();

            if (rs.next()) {
                txtId.setSelectedItem(rs.getString("id"));
                txtVdate.setDate(rs.getDate("date"));
                txtVname.setText(rs.getString("name"));
                txtVweight.setText(rs.getString("weight"));
                txtVunit.setSelectedItem(rs.getString("unit"));
                txtUB.setDate(rs.getDate("use_before"));
            } else {
                clearFields();
            }
        } catch (SQLException ex) {
            Logger.getLogger(AddVegetables.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        label1 = new java.awt.Label();
        label2 = new java.awt.Label();
        label3 = new java.awt.Label();
        label4 = new java.awt.Label();
        txtVname = new java.awt.TextField();
        txtVweight = new java.awt.TextField();
        txtVdate = new com.toedter.calendar.JDateChooser();
        txtVunit = new javax.swing.JComboBox<>();
        txtId = new javax.swing.JComboBox<>();
        label6 = new java.awt.Label();
        txtUB = new com.toedter.calendar.JDateChooser();
        label5 = new java.awt.Label();
        btnSearch = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnBack = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        label1.setFont(new java.awt.Font("Times New Roman", 1, 14)); 
        label1.setText("Vegetable");

        label2.setFont(new java.awt.Font("Times New Roman", 1, 14)); 
        label2.setText("Date");

        label3.setFont(new java.awt.Font("Times New Roman", 1, 14)); 
        label3.setText("Weight\n");

        label4.setFont(new java.awt.Font("Times New Roman", 1, 14)); 
        label4.setText("Unit\n");

        txtVweight.setText("\n");

        txtVunit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Kg", "gm", "Qty" }));

        txtId.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        label6.setFont(new java.awt.Font("Times New Roman", 1, 14)); 
        label6.setText("Vegetable Id");

        label5.setFont(new java.awt.Font("Times New Roman", 1, 14)); 
        label5.setText("Use Before\n\n");

        btnSearch.setFont(new java.awt.Font("Segoe UI", 1, 14)); 
        btnSearch.setText("Search ");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); 
        jLabel1.setText("Manage Vegetables");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "SR.No", "Date", "Vegetable Name", "Weight", "Unit", "Use Before"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        btnBack.setFont(new java.awt.Font("Segoe UI", 1, 14)); 
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnDelete.setFont(new java.awt.Font("Segoe UI", 1, 14)); 
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnUpdate.setFont(new java.awt.Font("Segoe UI", 1, 14)); 
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnAdd.setFont(new java.awt.Font("Segoe UI", 1, 14)); 
        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(label3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(label2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(label1, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                                        .addComponent(label4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(label5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(34, 34, 34)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtVname, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtVdate, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                                    .addComponent(txtVweight, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtVunit, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtUB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(btnAdd)
                        .addGap(18, 18, 18)
                        .addComponent(btnUpdate)
                        .addGap(18, 18, 18)
                        .addComponent(btnDelete)
                        .addGap(18, 18, 18)
                        .addComponent(btnBack)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(label6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSearch))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 466, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtVdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtVname, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label6, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtVweight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtVunit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtUB, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(82, 82, 82)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(51, Short.MAX_VALUE))
                
                
        );
        

        pack();
    }// </editor-fold>                        

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {                                          
     try {
            
            
            String pid=txtId.getSelectedItem().toString();
            pst=con.prepareStatement("SELECT * FROM vegetable_tbl WHERE id=?");
            pst.setString(1,pid);
            rs=pst.executeQuery();
            
            if(rs.next()==true){
                txtVdate.setDate(rs.getDate("date"));
                txtVname.setText(rs.getString("name"));
                txtVweight.setText(rs.getString("weight"));
                txtVunit.setSelectedItem(rs.getString("unit"));
                txtUB.setDate(rs.getDate("use_before"));

            } else{
                    JOptionPane.showMessageDialog(this, "No vegetable Found !");
            }
            

         }catch (SQLException ex) {
            Logger.getLogger(AddVegetables.class.getName()).log(Level.SEVERE, null, ex);
        }   
     }  

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) { 
        this.dispose();
        Dashboard dashboard = new Dashboard();
        dashboard.setVisible(true);
}                                       

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {                                          

        try {
            String pid = txtId.getSelectedItem().toString();
            pst = con.prepareStatement("DELETE FROM vegetable_tbl WHERE id=?");
            pst.setString(1, pid);

            int k = pst.executeUpdate();
            if (k == 1) {
                JOptionPane.showMessageDialog(this, "Record has been successfully deleted");

                txtVdate.setDate(null);
                txtVname.setText("");
                txtVweight.setText("");
                txtVunit.setSelectedIndex(0);
                txtUB.setDate(null);

                txtVname.requestFocus();

                fetch();
                LoadVegNo();
            } else {
                JOptionPane.showMessageDialog(this, "Record failed to delete");
            }

        } catch (SQLException ex) {
            Logger.getLogger(AddVegetables.class.getName()).log(Level.SEVERE, null, ex);
        }
    }                                         

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {                                          
        try {
            String date = new SimpleDateFormat("yyyy-MM-dd").format(txtVdate.getDate());
            String Vname = txtVname.getText();
            String weight = txtVweight.getText();
            String unit = txtVunit.getSelectedItem().toString();
            String use_before = new SimpleDateFormat("yyyy-MM-dd").format(txtUB.getDate());
            String Vid = txtId.getSelectedItem().toString();

            pst = con.prepareStatement("UPDATE vegetable_tbl SET date=?,name=?,weight=?,unit=?,use_before=? WHERE id=?");

            pst.setString(1, date);
            pst.setString(2, Vname);
            pst.setString(3, weight);
            pst.setString(4, unit);
            pst.setString(5, use_before);
            pst.setString(6, Vid);
            
              txtId.setSelectedItem(null);

            int k = pst.executeUpdate();
            if (k == 1) {
                JOptionPane.showMessageDialog(this, "Vegetables Updated Successfully !");
                txtVdate.setDate(null);
                txtVname.setText("");
                txtVweight.setText("");
                txtVunit.setSelectedIndex(0);
                txtUB.setDate(null);
                txtVname.requestFocus();
                fetch();
                LoadVegNo();
            }

        } catch (SQLException ex) {
            Logger.getLogger(AddVegetables.class.getName()).log(Level.SEVERE, null, ex);

        }

        txtVname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtVnameKeyReleased(evt);
            }
        });
    }                                         

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {                                       
    try {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        if (txtVdate.getDate() != null && txtVdate.getDate().after(new java.util.Date())) {
            JOptionPane.showMessageDialog(this, "Date must not be Greater than Todays's Date.");
            return;
        }

        String date = sdf.format(txtVdate.getDate());
        String vName = txtVname.getText();
        String weight = txtVweight.getText();
        String unit = txtVunit.getSelectedItem().toString();
        String useBefore = sdf.format(txtUB.getDate());

        if (txtUB.getDate().before(txtVdate.getDate())) {
            JOptionPane.showMessageDialog(this, "Use Before date must be greater than or equal to the purchase date");
            return;
        }

        try {
            Float.parseFloat(weight);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid Weight");
            return;
        }

        if (vName.isEmpty() || vName.matches(".*\\d.*")) {
            JOptionPane.showMessageDialog(this, "Please enter a valid Vegetable Name");
            return;
        }

        if (isVegetableAlreadyExists(vName)) {
            JOptionPane.showMessageDialog(this, "Vegetable already present. Please update it.");
            return;
        }

        pst = con.prepareStatement("INSERT INTO vegetable_tbl (date,name,weight,unit,use_before) VALUES(?,?,?,?,?)");
        pst.setString(1, date);
        pst.setString(2, vName);
        pst.setString(3, weight);
        pst.setString(4, unit);
        pst.setString(5, useBefore);

        int k = pst.executeUpdate();
        if (k == 1) {
            JOptionPane.showMessageDialog(this, "Vegetables added successfully !");
            clearFields();
            fetch();
            LoadVegNo();
        } else {
            JOptionPane.showMessageDialog(this, "Vegetables failed to add !");
        }
    } catch (SQLException ex) {
        Logger.getLogger(AddVegetables.class.getName()).log(Level.SEVERE, null, ex);
    }
}

        private boolean isVegetableAlreadyExists(String vegetableName) throws SQLException {
            pst = con.prepareStatement("SELECT * FROM vegetable_tbl WHERE name=?");
            pst.setString(1, vegetableName);
            rs = pst.executeQuery();
            return rs.next(); 
    }   
        
                                             
    public static void main(String args[]) {
      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddVegetables().setVisible(true);
            }
        });
    }

    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private java.awt.Label label1;
    private java.awt.Label label2;
    private java.awt.Label label3;
    private java.awt.Label label4;
    private java.awt.Label label5;
    private java.awt.Label label6;
    private javax.swing.JComboBox<String> txtId;
    private com.toedter.calendar.JDateChooser txtUB;
    private com.toedter.calendar.JDateChooser txtVdate;
    private java.awt.TextField txtVname;
    private javax.swing.JComboBox<String> txtVunit;
    private java.awt.TextField txtVweight;
}

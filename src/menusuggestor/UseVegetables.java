package menusuggestor;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.DefaultComboBoxModel;
import com.toedter.calendar.JDateChooser;

public class UseVegetables extends javax.swing.JFrame {

    private Connection con;
    private PreparedStatement pst;
    private ResultSet rs;
    private javax.swing.JComboBox<String> cmbVegetables;
    private JDateChooser dateChooser;  

    private void clearFields() {
        txtVname.setText("");
        txtVweight.setText("");
        dateChooser.setDate(null);  
    }

    public UseVegetables() {
        initComponents();
        Connect();
        fetch();
        loadVegetableNames();

        Color customColor = new Color(220,210,224);

        btnUse.setBackground(Color.cyan);
        btnBack.setBackground(Color.cyan);

        label1.setForeground(Color.BLACK);
        label2.setForeground(Color.BLACK);

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

    private void Connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/msuggestion", "root", "shubhs#R83");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UseVegetables.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void initComponents() {

        label1 = new java.awt.Label();
        label2 = new java.awt.Label();
        txtVname = new java.awt.TextField();
        txtVweight = new java.awt.TextField();
        btnUse = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        cmbVegetables = new javax.swing.JComboBox<>();
        dateChooser = new JDateChooser(); 

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        label1.setFont(new java.awt.Font("Times New Roman", 1, 14));
        label1.setText("Vegetable Name");

        label2.setFont(new java.awt.Font("Times New Roman", 1, 14));
        label2.setText("Weight");

        btnUse.setFont(new java.awt.Font("Segoe UI", 1, 14));
        btnUse.setText("Use");
        btnUse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUseActionPerformed(evt);
            }
        });

        btnBack.setFont(new java.awt.Font("Segoe UI", 1, 14));
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null}
                },
                new String[]{
                    "Vegetable Name", "Available Weight", "Unit", "Use Before Date", "Date"
                }
        ));
        jScrollPane1.setViewportView(jTable1);

        dateChooser.setDateFormatString("yyyy-MM-dd");  // Set date format
javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtVname, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                            .addComponent(dateChooser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtVweight, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(71, 71, 71)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnUse, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(btnBack, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(40, 40, 40))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(53, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(label1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtVname, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(31, 31, 31)
                        .addComponent(dateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(label2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtVweight, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnUse, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(40, 40, 40)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(65, Short.MAX_VALUE))
    );

    pack();
}

    private void loadVegetableNames() {
        try {
            pst = con.prepareStatement("SELECT name FROM vegetable_tbl");
            rs = pst.executeQuery();

            DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
            while (rs.next()) {
                model.addElement(rs.getString("name"));
            }
            cmbVegetables.setModel(model);
        } catch (SQLException ex) {
            Logger.getLogger(UseVegetables.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void btnUseActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            String vName = txtVname.getText();
            String usedWeight = txtVweight.getText();
            java.util.Date selectedDate = dateChooser.getDate();  // Get selected date

            if (vName.isEmpty() || usedWeight.isEmpty() || selectedDate == null) {
                JOptionPane.showMessageDialog(this, "Please enter Vegetable Name, Used Weight, and Date");
                return;
            }

            try {
                Float.parseFloat(usedWeight);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Please enter a valid Used Weight");
                return;
            }

        
            if (isUsedWeightValid(vName, Float.parseFloat(usedWeight))) {
                updateUsedWeightInAddVegetables(vName, Float.parseFloat(usedWeight));
                JOptionPane.showMessageDialog(this, "Vegetable Used Successfully!");
                clearFields();
                fetch();
            } else {
                JOptionPane.showMessageDialog(this, "Used Weight is greater than Available Weight");
            }
        } catch (SQLException ex) {
            Logger.getLogger(UseVegetables.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private boolean isUsedWeightValid(String vegetableName, float usedWeight) throws SQLException {
        pst = con.prepareStatement("SELECT weight FROM vegetable_tbl WHERE name=?");
        pst.setString(1, vegetableName);
        rs = pst.executeQuery();

        if (rs.next()) {
            float availableWeight = Float.parseFloat(rs.getString("weight"));
            return usedWeight <= availableWeight;
        }

        return false;
    }

    private void updateUsedWeightInAddVegetables(String vegetableName, float usedWeight) throws SQLException {
        pst = con.prepareStatement("UPDATE vegetable_tbl SET weight=weight-? WHERE name=?");
        pst.setFloat(1, usedWeight);
        pst.setString(2, vegetableName);
        pst.executeUpdate();
    }

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
        Dashboard dashboard = new Dashboard();
        dashboard.setVisible(true);
    }

    private void fetch() {
        try {
            pst = con.prepareStatement("SELECT name, weight, unit, use_before, date FROM vegetable_tbl");
            rs = pst.executeQuery();
            ResultSetMetaData rss = rs.getMetaData();

            DefaultTableModel df = (DefaultTableModel) jTable1.getModel();
            df.setRowCount(0);

            while (rs.next()) {
                Vector v2 = new Vector();
                v2.add(rs.getString("name"));
                v2.add(rs.getString("weight"));
                v2.add(rs.getString("unit"));
                v2.add(rs.getString("use_before"));
                v2.add(rs.getString("date"));
                df.addRow(v2);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UseVegetables.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UseVegetables().setVisible(true);
            }
        });
    }

    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnUse;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private java.awt.Label label1;
    private java.awt.Label label2;
    private java.awt.TextField txtVname;
    private java.awt.TextField txtVweight;
}

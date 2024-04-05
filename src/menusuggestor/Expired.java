package menusuggestor;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;

public class Expired extends javax.swing.JFrame {

    Connection con;
    PreparedStatement pst;
    ResultSet rs;

    public Expired() {
        initComponents();
        Connect();
        fetchExpiredVegetables();

        Color customColor = new Color(182, 3, 252);

        btnBack.setBackground(Color.cyan);
        btnRemove.setBackground(Color.cyan);

        label1.setForeground(Color.BLACK);

        jTable1.setSelectionBackground(Color.YELLOW);
        getContentPane().setBackground(customColor);
    }

    public void Connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/msuggestion", "root", "shubhs#R83");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Expired.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void fetchExpiredVegetables() {    
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String currentDate = sdf.format(new java.util.Date());

            pst = con.prepareStatement("SELECT * FROM vegetable_tbl WHERE use_before <= ?");
            pst.setString(1, currentDate);
            rs = pst.executeQuery();

            DefaultTableModel df = (DefaultTableModel) jTable1.getModel();
            df.setRowCount(0);

            while (rs.next()) {
                Vector v2 = new Vector();
                v2.add(rs.getString("id"));
                v2.add(rs.getString("date"));
                v2.add(rs.getString("name"));
                v2.add(rs.getString("weight"));
                v2.add(rs.getString("unit"));
                v2.add(rs.getString("use_before"));
                df.addRow(v2);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Expired.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
        Dashboard dashboard = new Dashboard();
        dashboard.setVisible(true);
    }

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
        AddVegetables addVegetables = new AddVegetables();
        addVegetables.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        label1 = new java.awt.Label();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnBack = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        label1.setFont(new java.awt.Font("Times New Roman", 1, 18)); 
        label1.setText("Expired Vegetables");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "ID", "Date", "Vegetable Name", "Weight", "Unit", "Use Before"
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

        btnRemove.setFont(new java.awt.Font("Segoe UI", 1, 14)); 
        btnRemove.setText("Remove");
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(207, 207, 207)
                                                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 514, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(139, 139, 139)
                                                .addComponent(btnBack)
                                                .addGap(18, 18, 18)
                                                .addComponent(btnRemove)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Expired().setVisible(true);
            }
        });
    }

    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnRemove;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private java.awt.Label label1;
}

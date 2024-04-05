package menusuggestor;

import java.awt.Color;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;

public class VegetableUsageHistory extends javax.swing.JFrame {

    private Connection con;
    private PreparedStatement pst;
    private ResultSet rs;
    private JTable jTableHistory;

    public VegetableUsageHistory() {
        initComponents();
        Connect();
        fetchHistory();

        Color customColor = new Color(182, 3, 252);
        jTableHistory.setSelectionBackground(Color.YELLOW);
        getContentPane().setBackground(customColor);
    }

    private void initComponents() {
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableHistory = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTableHistory.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "Vegetable Name", "Used Weight", "Date"
                }
        ));
        jScrollPane1.setViewportView(jTableHistory);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(53, 53, 53)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(53, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(57, 57, 57)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(65, Short.MAX_VALUE))
        );

        pack();
    }

    private void Connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/msuggestion", "root", "shubhs#R83");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(VegetableUsageHistory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void fetchHistory() {
        try {
            pst = con.prepareStatement("SELECT name, used_weight, date FROM usage_history");
            rs = pst.executeQuery();
            ResultSetMetaData rss = rs.getMetaData();

            DefaultTableModel df = (DefaultTableModel) jTableHistory.getModel();
            df.setRowCount(0);

            while (rs.next()) {
                Vector v2 = new Vector();
                v2.add(rs.getString("name"));
                v2.add(rs.getString("used_weight"));
                v2.add(rs.getString("date"));
                df.addRow(v2);
            }
        } catch (SQLException ex) {
            Logger.getLogger(VegetableUsageHistory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VegetableUsageHistory().setVisible(true);
            }
        });
    }

    private javax.swing.JScrollPane jScrollPane1;
  //  private javax.swing.JTable jTableHistory;
}
